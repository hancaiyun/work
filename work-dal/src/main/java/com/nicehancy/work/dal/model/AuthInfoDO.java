package com.nicehancy.work.dal.model;

import com.nicehancy.work.dal.model.base.BaseDO;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *     权限表DO
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/16 10:14
 **/
@Getter
@Setter
public class AuthInfoDO extends BaseDO {

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