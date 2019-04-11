package com.nicehancy.work.web;


import com.nicehancy.work.common.utils.TripleDESUtil;
import com.nicehancy.work.service.api.model.login.UserInfoDTO;
import com.nicehancy.work.service.user.UserInfoServiceImpl;
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

        //UserInfoDTO userInfoDTO = userInfoService.queryUserInfo("19921577717");
        //log.info("result:{}", userInfoDTO);
    }

    @Test
    public void encryptTest(){
        try {
            log.info(TripleDESUtil.encrypt("hancaiyun"));
            log.info(TripleDESUtil.decrypt("352F2B6B633273474A4F2B334931634C5A5A445234673D3D"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
