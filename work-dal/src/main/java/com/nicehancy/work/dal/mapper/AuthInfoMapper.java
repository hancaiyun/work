package com.nicehancy.work.dal.mapper;

import com.nicehancy.work.dal.model.AuthInfoDO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *     权限信息mapper
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/16 10:17
 **/
public interface AuthInfoMapper {

    /**
     * 权限信息查询
     * @param authNo                权限编号
     * @return                      权限信息
     */
    AuthInfoDO queryAuthInfo(@Param("authNo") String authNo);
}