package com.nicehancy.work.service.config;

import com.nicehancy.work.biz.config.DataSourceSwitchBiz;
import com.nicehancy.work.common.enums.DataSuorceEnum;
import com.nicehancy.work.common.exception.BusinessErrorCode;
import com.nicehancy.work.common.exception.BusinessException;
import com.nicehancy.work.service.api.config.DataSouceSwitchService;
import com.nicehancy.work.service.api.model.base.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 数据源切换接口
 * <p>
 *     1、查询当前数据源状态
 *     2、切换数据源
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/9/17 10:34
 **/
@Slf4j
@Service
public class DataSourceSwitchServiceImpl implements DataSouceSwitchService {

    @Autowired
    private DataSourceSwitchBiz dataSourceSwitchBiz;

    /**
     * 数据源查询
     * @param traceLogId        日志ID
     * @return
     */
    @Override
    public Result<String> queryDataSourceSwitch(String traceLogId) {

        Result<String> result = new Result<>();
        try{
            log.info("call DataSourceSwitchServiceImpl queryDataSourceSwitch param: traceLogId={}", traceLogId);
            //业务处理
            String dataSwitch = dataSourceSwitchBiz.queryDataSourceSwitch();
            result.setResult(dataSwitch);
            log.info("call DataSourceSwitchServiceImpl queryDataSourceSwitch result: {}", result);
        }catch (Exception e){
            log.error("call DataSourceSwitchServiceImpl queryDataSourceSwitch failed, message：e={}", e);
            result.setErrorMsg(e.getMessage());
        }
        return result;
    }

    /**
     * 数据源切换
     * @param dataSource        数据源状态：MYSQL/MONGODB
     * @param traceLogId        日志ID
     * @return
     */
    @Override
    public Result<Boolean> switchDataSource(String dataSource, String traceLogId) {

        Result<Boolean> result = new Result<>();
        try{
            log.info("call DataSourceSwitchServiceImpl switchDataSource param: dataSource={},traceLogId={}",
                    dataSource, traceLogId);
            //参数校验
            if(null == DataSuorceEnum.explain(dataSource)){
                throw new BusinessException(BusinessErrorCode.DATA_SOURCE_IS_ERROR);
            }
            //业务处理
            dataSourceSwitchBiz.switchDataSource(dataSource);
            result.setResult(true);
            log.info("call DataSourceSwitchServiceImpl switchDataSource result: {}", result);
        }catch (Exception e){
            log.error("call DataSourceSwitchServiceImpl switchDataSource failed, message：e={}", e);
            result.setErrorMsg(e.getMessage());
        }
        return result;
    }
}
