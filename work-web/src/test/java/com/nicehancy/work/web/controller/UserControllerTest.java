package com.nicehancy.work.web.controller;

import com.nicehancy.work.controller.user.UserController;
import com.nicehancy.work.web.base.BaseSpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 *     用户管理controller测试类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/11 20:20
 **/
@Slf4j
public class UserControllerTest extends BaseSpringTest {

    @Autowired
    private UserController userController;

    /**
     * 用户信息查询测试
     */
    @Test
    public void queryUserInfoTest(){

        String userNo = "19921577717";
        //userController.queryUserInfo(userNo);
    }
}
