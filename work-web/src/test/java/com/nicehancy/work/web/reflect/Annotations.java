package com.nicehancy.work.web.reflect;

import java.lang.annotation.*;

/**
 * <p>
 *     自定义注解类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/8/6 9:05
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Annotations {
    long time() default -1;
}
