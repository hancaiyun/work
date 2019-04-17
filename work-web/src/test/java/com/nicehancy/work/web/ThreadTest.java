package com.nicehancy.work.web;

import com.nicehancy.work.web.base.BaseSpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static java.lang.Thread.sleep;

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
        log.info("我：一份薯条，一杯可乐，谢谢（12号餐桌）");
        String message = order();
        log.info("前台：{}", message);
    }

    public void giveMe(){
        log.info("服务员：您的薯条、可乐，请慢用");
    }

    /**
     * 服务员
     * @return              同步回复
     */
    //@Test
    public String order() {

        Thread t = new Thread(() -> {
        log.info("制作中");
        log.info("制作完成");

        //回调
        giveMe();
        });

        t.start();//开始，开始去执行线程
        return "请稍等，马上就好";
    }
}