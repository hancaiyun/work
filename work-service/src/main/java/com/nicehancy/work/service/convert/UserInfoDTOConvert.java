package com.nicehancy.work.service.convert;

import com.nicehancy.work.manager.model.UserInfoBO;
import com.nicehancy.work.service.api.model.UserInfoDTO;

/**
 * <p>
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/3 0:42
 **/

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
}
