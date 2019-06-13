package com.nicehancy.configuration;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *     注册中心配置类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/6/13 10:21
 **/
@Configuration
public class ElasticRegCenterConfig {

    /**
     * 配置zookeeper
     * @param serverList    服务器列表
     * @param namespace     命名空间
     * @return
     */
    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter regCenter(
            @Value("${regCenter.serverList}") final String serverList,
            @Value("${regCenter.namespace}") final String namespace) {
        return new ZookeeperRegistryCenter(new ZookeeperConfiguration(serverList, namespace));
    }
}