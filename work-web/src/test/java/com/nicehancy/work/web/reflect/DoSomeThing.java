package com.nicehancy.work.web.reflect;

import java.util.Date;

/**
 * <p>
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/8/6 9:08
 **/
public class DoSomeThing {

    public void test(){
        System.out.println("执行自定义注解");
        System.out.println("执行自定义注解结束时间：" + new Date());
    }
}
