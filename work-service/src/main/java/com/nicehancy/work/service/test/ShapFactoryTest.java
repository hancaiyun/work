package com.nicehancy.work.service.test;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *     工厂测试类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/7/9 17:02
 **/
@Slf4j
public class ShapFactoryTest {

    public static void main(String[] args) {

        ShapFactory shapeFactory = new ShapFactory();

        //获取 Circle 的对象，并调用它的 draw 方法
        shapeFactory.getShap("Circle").draw();

        //获取 Rectangle 的对象，并调用它的 draw 方法
        shapeFactory.getShap("RECTANGLE").draw();

        //获取 Square 的对象，并调用它的 draw 方法
        shapeFactory.getShap("SQUARE").draw();
    }
}