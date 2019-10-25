package com.nicehancy.work.web.reflect;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * <p>
 *     反射
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/8/6 9:10
 **/
public class AnnotationsRunner {

    public static void main(String[] args) throws Exception {
        System.out.println("执行自定义注解开始时间："+new Date());
        Class clazz = Test.class;
        Method[] ms = clazz.getMethods();
        for (Method method : ms) {
            boolean flag = method.isAnnotationPresent(Annotations.class);
            if (flag) {
                method.invoke(clazz.newInstance(), (Object) null);
            }
        }
    }
}
