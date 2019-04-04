package com.nicehancy.work.manager.convert;

import com.nicehancy.work.dal.model.UserInfoDO;
import com.nicehancy.work.manager.model.UserInfoBO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *     用户信息BO转换类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/3 2:17
 **/
public class UserInfoBOConvert {

    /**
     * 私有构造函数
     */
    @Autowired
    private UserInfoBOConvert(){
    }

    /**
     * 用户信息DO转BO
     * @param userInfoDO        用户信息DO
     * @return                  用户信息BO
     */
    public static UserInfoBO getBOByDO(UserInfoDO userInfoDO) {

        if (userInfoDO == null) {
            return null;
        }

        UserInfoBO userInfoBO = new UserInfoBO();
        userInfoBO.setLoginNo(userInfoDO.getLoginNo());
        userInfoBO.setNickName(userInfoDO.getNickName());
        userInfoBO.setPassword(userInfoDO.getPassword());
        userInfoBO.setEMail(userInfoDO.getEMail());
        userInfoBO.setDemo(userInfoDO.getDemo());
        userInfoBO.setCreatedAt(userInfoDO.getCreatedAt());
        userInfoBO.setCreatedBy(userInfoDO.getCreatedBy());
        userInfoBO.setUpdatedAt(userInfoDO.getUpdatedAt());
        userInfoBO.setUpdatedBy(userInfoDO.getUpdatedBy());

        return userInfoBO;
    }

}
