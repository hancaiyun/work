package com.nicehancy.work.web;

import com.nicehancy.work.common.utils.UUIDUtil;
import com.nicehancy.work.web.base.BaseSpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * <p>
 *     UUID测试
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/6/3 11:27
 **/
@Slf4j
public class UUIDTest extends BaseSpringTest {

    @Test
    public void createUUIDTest(){
        log.info("生成结果:{}", UUIDUtil.createNoByUUId());
    }
}