package com.nicehancy.work.web.service.config;

import com.nicehancy.work.common.enums.DataSuorceEnum;
import com.nicehancy.work.service.api.config.DataSourceSwitchService;
import com.nicehancy.work.web.base.BaseSpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * <p>
 *     数据源配置接口测试类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/9/17 15:46
 **/
@Slf4j
public class DataSourceSwitchServiceTest extends BaseSpringTest {

    @Autowired
    private DataSourceSwitchService dataSourceSwitchService;

    @Test
    public void queryDataSourceTest(){

        String traceLogId = UUID.randomUUID().toString();
        dataSourceSwitchService.queryDataSourceSwitch(traceLogId);
    }

    @Test
    public void switchDataSourceTest(){

        String dataSource = DataSuorceEnum.MYSQL.getCode();
        String traceLogId = UUID.randomUUID().toString();
        dataSourceSwitchService.switchDataSource(dataSource, traceLogId);
    }
}
