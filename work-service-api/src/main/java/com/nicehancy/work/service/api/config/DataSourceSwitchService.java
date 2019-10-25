package com.nicehancy.work.service.api.config;

import com.nicehancy.work.service.api.model.base.Result;

/**
 * 数据源切换接口
 * <p>
 *     1、查询数据源当前所处状态
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/9/17 10:29
 **/
public interface DataSourceSwitchService {

    /**
     * 1、查询数据源当前所处状态
     * @param traceLogId        日志ID
     * @return                  数据源当前状态
     */
    Result<String> queryDataSourceSwitch(String traceLogId);

    /**
     * 2、切换数据源状态
     * @param dataSource        数据源状态：MYSQL/MONGODB
     * @param traceLogId        日志ID
     * @return                  切换结果
     */
    Result<Boolean> switchDataSource(String dataSource, String traceLogId);
}
