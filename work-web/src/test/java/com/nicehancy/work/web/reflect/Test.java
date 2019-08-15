package com.nicehancy.work.web.reflect;

/**
 * <p>
 *     测试类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/8/6 9:09
 **/
public class Test {

    private DoSomeThing doSomeThing = new DoSomeThing();

    @Annotations
    public void test(){
        doSomeThing.test();
    }
}
