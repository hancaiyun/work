package com.nicehancy.work.web;

import com.nicehancy.work.web.base.BaseSpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import static com.nicehancy.work.web.KeyBordTest.keyPress;

/**
 * 鼠标定时点击事件
 * 键盘按键事件
 */
@Slf4j
public class KeyTest extends BaseSpringTest {

    /**
     * 鼠标点击
     * @throws AWTException
     */
    public static void main(String srg[]) throws AWTException {
        // 创建 Robot 实例
        Robot robot = new Robot();

        for(int i=0;i<10000;i++) {

            // 执行完一个事件后再执行下一个
            robot.setAutoWaitForIdle(true);

            // 移动鼠标到指定屏幕坐标
           // robot.mouseMove(1564, 477);
            try {
                Thread.sleep(5000);
                // 按下鼠标左键
                robot.mousePress(InputEvent.BUTTON1_MASK);
                // 延时100毫秒
                robot.delay(100);
                // 释放鼠标左键（按下后必须要释放, 一次点击操作包含了按下和释放）
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
                log.info("鼠标左键点击"+ i +"次");
            } catch (Exception e) {
                log.error("鼠标点击失败");
            }
        }
    }


    /**
     * 按键事件
     * @param srg
     */
//    public static void main(String srg[]){
//        Robot robot = null; //创建一个robot对象
//        try {
//            robot = new Robot();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
//        try {
//            for (int i = 0; i < 10000; i++) {
//                Thread.sleep(10000);
//                keyPress(robot, KeyEvent.VK_R);  //按下R键
//                log.info("这是第"+i+1+"次按键");
//            }
//        }catch (Exception e){
//            log.error("按键失败");
//        }
//    }
}
