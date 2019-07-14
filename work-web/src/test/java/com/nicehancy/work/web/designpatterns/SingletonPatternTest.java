package com.nicehancy.work.web.designpatterns;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *     单例模式测试类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/7/11 11:29
 **/
@Slf4j
public class SingletonPatternTest {

    public static void main(String[] args){

        //不合法的构造函数
        //编译时报错：构造函数SingleObject() 是不可见的
        //SingleObject object = new SingleObject();
        SingleObject object = SingleObject.getInstance();
        object.showMessage();
    }
}