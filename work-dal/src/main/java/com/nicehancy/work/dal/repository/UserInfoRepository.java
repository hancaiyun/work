package com.nicehancy.work.dal.repository;

import com.nicehancy.work.dal.model.UserInfoDO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *     用户信息表操作接口
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/9/17 9:14
 **/
public interface UserInfoRepository {

    /**
     * 用户信息查询
     * @param userNo                用户登录号
     * @return                      用户信息
     */
    UserInfoDO queryUserInfo(String userNo);

    /**
     * 新增用户
     * @param userInfoDO            用户信息
     */
    void insert(UserInfoDO userInfoDO);
}
