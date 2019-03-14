package com.nicehancy.work;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * <p>
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/3/13 19:50
 **/
public class SpringBootStartApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        /**
         * 这里要指向原先用main方法执行的Application启动类
         */
        return builder.sources(Application.class);
    }
}
