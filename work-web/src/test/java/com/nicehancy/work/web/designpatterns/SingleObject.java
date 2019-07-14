package com.nicehancy.work.web.designpatterns;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *     单例模式-只有一个实例
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/7/11 11:24
 **/
@Slf4j
public class SingleObject {

    //创建SingleObject的一个对象
    private static SingleObject instance = new SingleObject();

    //私有化构造函数， 这样该类就不会被实例化
    private SingleObject(){}

    //获取唯一可用的对象
    public static SingleObject getInstance(){
        return instance;
    }

    public void showMessage(){
        log.info("Hello Word");
    }
}