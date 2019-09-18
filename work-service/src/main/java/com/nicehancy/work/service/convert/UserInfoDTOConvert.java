package com.nicehancy.work.service.convert;

import com.nicehancy.work.common.utils.TripleDESUtil;
import com.nicehancy.work.manager.model.UserInfoBO;
import com.nicehancy.work.service.api.model.user.UserInfoDTO;
import lombok.extern.slf4j.Slf4j;

/**
 * 用户信息转换类
 * <p>
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/3 0:42
 **/
@Slf4j
public class UserInfoDTOConvert {

    /**
     * 无参构造函数
     */
    private UserInfoDTOConvert(){
    }

    /**
     * 用户信息BO转DTO
     * @param userInfoBO                用户信息BO
     * @return                          用户信息DTO
     */
    public static UserInfoDTO getDTOByBO(UserInfoBO userInfoBO) {

        if (userInfoBO == null) {
            return null;
        }

        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserNo(userInfoBO.getUserNo());
        userInfoDTO.setUserName(userInfoBO.getUserName());
        userInfoDTO.setNickName(userInfoBO.getNickName());
        userInfoDTO.setPassword(userInfoBO.getPassword());
        userInfoDTO.setEMail(userInfoBO.getEMail());
        userInfoDTO.setAuthCode(userInfoBO.getAuthCode());
        userInfoDTO.setRemark(userInfoBO.getRemark());
        userInfoDTO.setCreatedBy(userInfoBO.getCreatedBy());
        userInfoDTO.setCreatedAt(userInfoBO.getCreatedAt());
        userInfoDTO.setUpdatedBy(userInfoBO.getUpdatedBy());
        userInfoDTO.setUpdatedAt(userInfoBO.getUpdatedAt());

        return userInfoDTO;
    }

    /**
     * DTO转BO
     * @param userInfoDTO                   用户信息DTO
     * @return                              用户信息BO
     */
    public static UserInfoBO getBOByDTO(UserInfoDTO userInfoDTO) {

        if (userInfoDTO == null) {
            return null;
        }

        UserInfoBO userInfoBO = new UserInfoBO();
        userInfoBO.setUserNo(userInfoDTO.getUserNo());
        userInfoBO.setUserName(userInfoDTO.getUserName());
        userInfoBO.setNickName(userInfoDTO.getNickName());
        //加密
        try {
            userInfoBO.setPassword(TripleDESUtil.encrypt(userInfoDTO.getPassword()));
        } catch (Exception e) {
            log.error("密码加密失败，失败原因:{}", e);
            userInfoBO.setPassword(userInfoDTO.getPassword());
        }
        userInfoBO.setEMail(userInfoDTO.getEMail());
        userInfoBO.setAuthCode(userInfoDTO.getAuthCode());
        userInfoBO.setRemark(userInfoDTO.getRemark());
        userInfoBO.setCreatedAt(userInfoDTO.getCreatedAt());
        userInfoBO.setCreatedBy(userInfoDTO.getCreatedBy());
        userInfoBO.setUpdatedAt(userInfoDTO.getUpdatedAt());
        userInfoBO.setUpdatedBy(userInfoDTO.getUpdatedBy());

        return userInfoBO;
    }
}
