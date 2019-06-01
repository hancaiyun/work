package com.nicehancy.work.web;

import com.nicehancy.work.web.base.BaseSpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * <p>
 * 多线程测试类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/15 13:42
 **/
@Slf4j
public class ThreadTest extends BaseSpringTest {

    /**
     * 点餐-我
     */
    @Test
    public void me(){
        log.info("Thread-id:{},我：一份薯条，一杯可乐，谢谢（12号餐桌）",Thread.currentThread().getId());
        String message = order();
        log.info("Thread-id:{},前台：{}", Thread.currentThread().getId(),message);
    }

    public void giveMe(){
        log.info("Thread-id:{},服务员：您的薯条、可乐，请慢用", Thread.currentThread().getId());
    }

    /**
     * 服务员
     * @return              同步回复
     */
    //@Test
    public String order() {

        Thread t = new Thread(() -> {
        log.info("Thread-id:{},制作中",Thread.currentThread().getId());
        log.info("Thread-id:{},制作完成",Thread.currentThread().getId());

        //回调
        giveMe();
        });

        t.start();//开始，开始去执行线程
        return "Thread-id:"+Thread.currentThread().getId()+",请稍等，马上就好";
    }

    /**
     * 调试大量的线程
     */
    public class Probe extends Thread {
        public Probe() {}
        public void run() {
            while(true) {
                Thread[] x = new Thread[100];
                Thread.enumerate(x);
                for(int i=0; i<100; i++) {
                    Thread t = x[i];
                    if(t == null)
                        break;
                    else
                        System.out.println(t.getName() + "\t" + t.getPriority()
                                + "\t" + t.isAlive() + "\t" + t.isDaemon());
                }
            }
        }
    }

    /**
     * 线程开启测试类
     */
    @Test
    public void threadTest(){

        Probe probe = new Probe();
        probe.run();
    }
}