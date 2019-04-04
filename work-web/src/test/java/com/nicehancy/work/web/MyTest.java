package com.nicehancy.work.web;


import com.nicehancy.work.common.utils.MD5Util;
import com.nicehancy.work.common.utils.TripleDESUtil;
import com.nicehancy.work.service.api.model.login.UserInfoDTO;
import com.nicehancy.work.service.login.UserInfoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *     测试
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/3/13 19:53
 **/
@Slf4j
public class MyTest extends BaseSpringTest {

    @Autowired
    private UserInfoServiceImpl userInfoService;

    @Test
    public void queryUserInfoTest(){

        UserInfoDTO userInfoDTO = userInfoService.queryUserInfo("19921577717");
        log.info("result:{}", userInfoDTO);
    }

    @Test
    public void encryptTest(){
        try {
            log.info(TripleDESUtil.encrypt("hancaiyun"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
