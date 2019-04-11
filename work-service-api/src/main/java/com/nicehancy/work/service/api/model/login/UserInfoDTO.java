package com.nicehancy.work.service.api.model.login;

import com.nicehancy.work.service.api.model.BaseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

/**
 * <p>
 *     用户信息DTO
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/2 16:23
 **/
@Getter
@Setter
@ToString(callSuper = true)
public class UserInfoDTO extends BaseDTO implements Serializable{

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 4593695207378829868L;

    /**
     * 用户编号/登陆号
     */
    private String userNo;

    /**
     * 用户名
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
     * 备注
     */
    private String remark;
}
