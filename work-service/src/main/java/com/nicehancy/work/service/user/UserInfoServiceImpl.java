package com.nicehancy.work.service.user;

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
     * @param userNo                用户编号/登录号
     * @param traceLogId            日志ID
     * @return
     */
    public UserInfoDTO queryUserInfo(String userNo, String traceLogId){

        UserInfoDTO userInfoDTO = new UserInfoDTO();
        try{
            log.info("call UserInfoServiceImpl queryUserInfo param: userNo={}, traceLogId={}", userNo, traceLogId);
            UserInfoBO userInfoBO = userInfoBiz.queryUserInfo(userNo);
            userInfoDTO = UserInfoDTOConvert.getDTOByBO(userInfoBO);
            log.info("call UserInfoServiceImpl queryUserInfo result: {}", userInfoDTO);
        }catch (Exception e){
            log.error("call UserInfoServiceImpl queryUserInfo failed, message：e={}", e);
        }
        return userInfoDTO;
    }
}
