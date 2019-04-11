package com.nicehancy.work.manager.impl;

import com.nicehancy.work.dal.mapper.UserInfoMapper;
import com.nicehancy.work.dal.model.UserInfoDO;
import com.nicehancy.work.manager.UserInfoManager;
import com.nicehancy.work.manager.convert.UserInfoBOConvert;
import com.nicehancy.work.manager.model.UserInfoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 *     用户信息数据库管理类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/3 2:14
 **/
@Component
public class UserInfoManagerImpl implements UserInfoManager {

    /**
     * 用户信息表
     */
    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 用户信息查询
     * @param userNo        登录号
     * @return              用户信息
     */
    @Override
    public UserInfoBO queryUserInfo(String userNo) {

        return UserInfoBOConvert.getBOByDO(userInfoMapper.queryUserInfo(userNo));
    }
}
