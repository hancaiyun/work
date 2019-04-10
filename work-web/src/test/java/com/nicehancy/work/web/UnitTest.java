package com.nicehancy.work.web;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * <p>
 *     单元、自定义测试
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/9 12:10
 **/
@Slf4j
public class UnitTest extends BaseSpringTest{

    static int arr[] = new int[10];

    @Test
    public void test(){
        log.info("{}",arr[1]);
    }


}
