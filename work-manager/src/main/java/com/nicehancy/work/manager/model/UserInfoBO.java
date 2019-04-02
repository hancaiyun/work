package com.nicehancy.work.manager.model;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *     用户信息BO
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/3 0:35
 **/
@Getter
@Setter
public class UserInfoBO extends BaseBO{

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
