package com.nicehancy.work.dal.mapper;

import com.nicehancy.work.dal.model.UserInfoDO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *     用户信息Mapper
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/3 0:57
 **/
public interface UserInfoMapper {

    /**
     * 用户信息查询
     * @param userNo                用户登录号
     * @return                      用户信息
     */
    UserInfoDO queryUserInfo(@Param("userNo") String userNo);

    /**
     * 新增用户信息
     * @param userInfoDO            用户信息
     * @return                      新增条目数
     */
    int insert(UserInfoDO userInfoDO);
}
