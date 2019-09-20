package com.nicehancy.work.manager.model;

import com.nicehancy.work.manager.model.base.BaseBO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@ToString
public class UserInfoBO extends BaseBO {

    /**
     * 用户名称/登陆号
     */
    private String userNo;

    /**
     * 登陆号
     */
    private String userName;

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
     * 权限编号
     */
    private String authCode;

    /**
     * 备注
     */
    private String remark;
}
