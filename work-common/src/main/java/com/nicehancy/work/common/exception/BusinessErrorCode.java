package com.nicehancy.work.common.exception;

import com.nicehancy.work.common.exception.base.ErrorCode;

/**
 * <p>
 *     错误码枚举
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/9/17 9:38
 **/
public enum BusinessErrorCode implements ErrorCode {

    /**
     * 系统内部错误
     */
    SYSTEM_INNER_ERROR("SYSTEM_INNER_ERROR", "系统内部错误"),

    /**
     * 数据源类型有误
     */
    DATA_SOURCE_IS_ERROR("DATA_SOURCE_IS_ERROR","数据源类型有误"),

    /**
     * 待脱敏数据类型有误
     */
    DATA_TYPE_IS_ERROR("DATA_TYPE_IS_ERROR", "待脱敏数据类型有误"),


    ;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误描述
     */
    private String desc;

    BusinessErrorCode(String code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }}
