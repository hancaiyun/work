package com.nicehancy.work.manager.model;

import com.nicehancy.work.manager.model.base.BaseBO;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *     权限信息BO
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/16 10:14
 **/
@Getter
@Setter
public class AuthInfoBO extends BaseBO {

    /**
     * 权限编码
     */
    private String authCode;

    /**
     * 权限名称
     */
    private String authName;

    /**
     * 备注
     */
    private String remark;
}