package com.nicehancy.work.manager;

import com.nicehancy.work.manager.model.UserInfoBO;

/**
 * <p>
 *     用户信息数据库管理类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/3 2:11
 **/
public interface UserInfoManager {

    /**
     * 查询用户信息
     * @param loginNo       登录号
     * @return              用户信息
     */
    UserInfoBO queryUserInfo(String loginNo);
}
