package com.nicehancy.work.web;

import com.nicehancy.work.web.base.BaseSpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *     锁测试
 *     循环输出ABC十次
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/9/24 10:46
 **/
@Slf4j
public class LockTest extends BaseSpringTest {

    /**
     * 启动类
     */
    @Test
    public void start(){
        PrintABCUsingReentrantLock printABC = new PrintABCUsingReentrantLock();
        new Thread(() -> printABC.printA()).start();
        new Thread(() -> printABC.printB()).start();
        new Thread(() -> printABC.printC()).start();
    }


    /**
     *
     */
    class PrintABCUsingReentrantLock {
        private Lock lock = new ReentrantLock();
        private int state = 0;

        //private int attempts =0;

        public void printA() {
            print("A", 0);
        }

        public void printB() {
            print("B", 1);
        }

        public void printC() {
            print("C", 2);
        }

        /**
         * 打印
         * @param name
         * @param currentState
         */
        private void print(String name, int currentState) {
            for (int i = 0; i < 10; ) {
                lock.lock();
                try {
                    while (state % 3 == currentState) {
                        System.out.println(Thread.currentThread().getName() + " print " + name);
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
