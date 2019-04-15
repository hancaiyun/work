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

    @Test
    public void threadTest() {

        Thread t = new Thread(() -> {
        log.info("子线程开始执行，线程ID：{}", Thread.currentThread().getId());
        //Thread.sleep(10000);
        log.info("子线程执行结束，线程ID：{}", Thread.currentThread().getId());
        });

        t.start();//开始，开始去执行线程
        log.info("主线程即将结束，线程ID:{}", Thread.currentThread().getId());
    }
}