package com.nicehancy.work.biz.config;

import com.nicehancy.work.common.constant.CommonConstant;
import com.nicehancy.work.manager.redis.RedisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 数据源切换
 * <p>
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/9/17 10:45
 **/
@Component
public class DataSourceSwitchBiz {

    @Autowired
    private RedisManager redisManager;

    /**
     * 1、查询当前数据源状态
     * @return              数据源状态
     */
    public String queryDataSourceSwitch() {

        return redisManager.queryObjectByKey(CommonConstant.DATA_SOURCE_SWITCH);
    }

    /**
     * 2、数据源切换
     * @param dataSource     数据源
     */
    public void switchDataSource(String dataSource) {

        redisManager.insertObject(dataSource, CommonConstant.DATA_SOURCE_SWITCH);
    }
}
