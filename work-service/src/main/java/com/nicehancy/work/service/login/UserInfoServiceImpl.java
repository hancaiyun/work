package com.nicehancy.work.service.login;

import com.nicehancy.work.biz.user.UserInfoBiz;
import com.nicehancy.work.manager.model.UserInfoBO;
import com.nicehancy.work.service.api.model.login.UserInfoDTO;
import com.nicehancy.work.service.convert.UserInfoDTOConvert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *     用户信息操作类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/2 16:21
 **/
@Service
@Slf4j
public class UserInfoServiceImpl {

    /**
     * 用户信息处理类
     */
    @Autowired
    private UserInfoBiz userInfoBiz;
    /**
     * 用户信息查询
     * @param loginNo               登录号
     * @return
     */
    public UserInfoDTO queryUserInfo(String loginNo){

        UserInfoDTO userInfoDTO = new UserInfoDTO();
        try{
            log.info("call UserInfoServiceImpl queryUserInfo param: loginNo={}", loginNo);
            UserInfoBO userInfoBO = userInfoBiz.queryUserInfo(loginNo);
            userInfoDTO = UserInfoDTOConvert.getDTOByBO(userInfoBO);
        }catch (Exception e){
            log.error("call UserInfoServiceImpl queryUserInfo failed, message：e={}", e);
        }
        return userInfoDTO;
    }
}
