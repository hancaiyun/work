package com.nicehancy.work.dal.model;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *     用户信息DO
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/3 0:57
 **/
@Getter
@Setter
public class UserInfoDO extends BaseDO{

    /**
     * 登陆号
     */
    private String loginNo;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 密码
     * MD5密文
     */
    private String password;

    /**
     * 邮箱
     */
    private String eMail;

    /**
     * 备注
     */
    private String demo;
}
