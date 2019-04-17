package com.nicehancy.work.web.service;

import com.nicehancy.work.service.user.UserInfoServiceImpl;
import com.nicehancy.work.web.base.BaseSpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * <p>
 *     用户信息管理测试
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/3/13 19:53
 **/
@Slf4j
public class UserInfoTest extends BaseSpringTest {

    @Autowired
    private UserInfoServiceImpl userInfoService;

    /**
     * 用户信息查询测试
     */
    @Test
    public void queryUserInfoTest(){

        userInfoService.queryUserInfo("19921577717", UUID.randomUUID().toString());
    }
}
