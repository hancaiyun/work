package com.nicehancy.work.biz.user;

import com.nicehancy.work.manager.UserInfoManager;
import com.nicehancy.work.manager.model.UserInfoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *     用户信息操作业务处理
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/2 17:36
 **/
@Service
public class UserInfoBiz {

    @Autowired
    private UserInfoManager userInfoManager;

    /**
     *  用户信息查询
     * @param loginNo               登录号
     * @return                      用户信息
     */
    public UserInfoBO queryUserInfo(String loginNo) {

        return userInfoManager.queryUserInfo(loginNo);
    }
}
