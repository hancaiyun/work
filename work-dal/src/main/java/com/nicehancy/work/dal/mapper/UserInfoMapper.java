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
     * @param loginNo               用户登录号
     * @return                      用户信息
     */
    UserInfoDO queryUserInfo(@Param("loginNo") String loginNo);
}
