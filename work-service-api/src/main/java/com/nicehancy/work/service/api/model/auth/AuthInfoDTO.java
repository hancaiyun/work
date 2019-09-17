package com.nicehancy.work.service.api.model.auth;

import com.nicehancy.work.service.api.model.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

/**
 * <p>
 *     权限信息DTO
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/16 10:14
 **/
@Getter
@Setter
@ToString(callSuper = true)
public class AuthInfoDTO extends BaseDTO implements Serializable{

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 2709305515779879835L;

    /**
     * 权限编号
     */
    private String authNo;

    /**
     * 权限名称
     */
    private String authName;

    /**
     * 备注
     */
    private String remark;
}