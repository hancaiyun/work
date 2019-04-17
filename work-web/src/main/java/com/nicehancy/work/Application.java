package com.nicehancy.work;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * <p>
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/3/13 19:49
 **/
@SpringBootApplication
@EnableKafka
@EnableCaching
//@EnableDubbo(scanBasePackages = "com.nicehancy.work.service")
@MapperScan(basePackages = "com.nicehancy.work.dal.mapper")
@EnableScheduling
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
