package com.nicehancy.configuration;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *     注册中心配置
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/15 16:59
 **/
@Configuration
@ConditionalOnExpression("'${regCenter.serverList}'.length() > 0")
public class ZookeeperConfig {


    @Value("${zookeeper.serverList}")
    private String serverList;
    @Value("${zookeeper.namespace.elasticJob}")
    private String namespace;

    @Bean
    public ZookeeperConfiguration zkConfig() {
        return new ZookeeperConfiguration(serverList, namespace);
    }

    @Bean(initMethod = "init", destroyMethod = "close")
    public ZookeeperRegistryCenter regCenter(ZookeeperConfiguration config) {
        return new ZookeeperRegistryCenter(config);
    }
}