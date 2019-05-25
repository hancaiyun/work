package com.nicehancy.work.web.countDownLatch;

import com.nicehancy.work.web.base.BaseSpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *     countDownLatch测试
 *     同步处理多件事，等待全部处理完成，提交结果
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/15 14:47
 **/
@Slf4j
public class CountDownLatchSimpleTest extends BaseSpringTest {

    @Test
    public void doWork(){
        ExecutorService executor= Executors.newFixedThreadPool(5);
        final CountDownLatch countDownLatch=new CountDownLatch(3);

        executor.execute(() -> {
            try{
                System.out.println("订机票");
                try {

                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }finally{
                countDownLatch.countDown();
            }
        });
        executor.execute(() -> {
            try{
                System.out.println("订巴士");
            }finally{
                countDownLatch.countDown();
            }
        });
        executor.execute(() -> {
            try{
                System.out.println("订酒店");
            }finally{
                countDownLatch.countDown();
            }
        });

        try {
            countDownLatch.await();
            System.out.println("所有都已准备好，可以出发了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}