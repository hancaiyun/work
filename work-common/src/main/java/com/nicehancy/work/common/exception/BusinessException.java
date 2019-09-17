package com.nicehancy.work.common.exception;

import com.nicehancy.work.common.exception.base.BaseException;
import com.nicehancy.work.common.exception.base.ErrorCode;

/**
 * <p>
 *     异常类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/9/17 9:37
 **/
public class BusinessException extends BaseException {

    /**
     * 构造方法
     * @param errorCode     错误码
     * @param cause         异常
     */
    public BusinessException(ErrorCode errorCode, Throwable cause){
        this(errorCode, null, cause);
    }

    /**
     * 构造方法
     * @param errorCode     错误码
     * @param errorMsg      错误信息
     * @param cause         异常
     */
    public BusinessException(ErrorCode errorCode, String errorMsg, Throwable cause){
        super(errorCode, errorMsg, cause);
    }

    /**
     * 构造方法
     * @param errorCode     错误码
     */
    public BusinessException(ErrorCode errorCode){
        this(errorCode, null, null);
    }

    /**
     * 构造方法
     * @param errorCode     错误码
     * @param errorMsg      错误描述
     */
    public BusinessException(ErrorCode errorCode, String errorMsg){
        this(errorCode, errorMsg, null);
    }
}
