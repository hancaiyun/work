package com.nicehancy.work.common.exception.base;

import com.nicehancy.work.common.utils.IPUtil;
import com.nicehancy.work.common.utils.MessageHelper;

/**
 * <p>
 *     基础异常类
 *
 *     提供各种组合的构造方法
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/9/17 9:46
 **/
public abstract class BaseException extends RuntimeException{

    /**
     * 错误码信息
     */
    private ErrorCode errorCode;

    /**
     * 除了错误码本身描述的提示信息外，额外补充的信息
     */
    private String errorMsg;

    /**
     * 原始错误码
     */
    private String primaryErrorCode;

    /**
     * 原始错误描述
     */
    private String primaryErrorMsg;

    /**
     * 原始错误IP
     */
    private String primaryErrorIP;

    /**
     * 错误信息模板
     */
    private final static String MSG_TEMPLATE = "错误码:{0}, 描述:{1}, 异常信息:{2}";

    /**
     * 提供错误码、异常原因构造方法
     *
     * @param errorCode         错误码
     * @param cause             异常原因
     */
    public BaseException(ErrorCode errorCode, Throwable cause) {
        this(errorCode, null, null, null, null, cause);
    }

    /**
     * 提供错误码、补充错误描述、异常原因构造方法
     *
     * @param errorCode         错误码
     * @param errorMsg          补充错误描述
     * @param cause             异常原因
     */
    public BaseException(ErrorCode errorCode, String errorMsg, Throwable cause) {
        this(errorCode, errorMsg, null, null, IPUtil.getServerIp(), cause);
    }

    /**
     * 提供错误码、原始错误码、异常原因构造方法
     *
     * @param errorCode         错误码
     * @param primaryErrorCode 原始错误码
     * @param primaryErrorMsg   原始错误描述
     * @param cause             异常原因
     */
    public BaseException(ErrorCode errorCode, String primaryErrorCode, String primaryErrorMsg, Throwable cause) {
        this(errorCode, null, primaryErrorCode, primaryErrorMsg, IPUtil.getServerIp(), cause);
    }

    /**
     * 提供错误码、原始错误码、原始错误IP、异常原因构造方法
     *
     * @param errorCode         错误码
     * @param primaryErrorCode 原始错误码
     * @param primaryErrorMsg   原始错误描述
     * @param primaryErrorIP    原始错误IP
     * @param cause             异常原因
     */
    public BaseException(ErrorCode errorCode, String primaryErrorCode, String primaryErrorMsg,
                         String primaryErrorIP, Throwable cause) {
        this(errorCode, null, primaryErrorCode, primaryErrorMsg, primaryErrorIP, cause);
    }

    /**
     * 提供错误码、补充错误描述、原始错误码、原始错误IP、异常原因构造方法
     *
     * @param errorCode         错误码
     * @param errorMsg          补充错误描述
     * @param primaryErrorCode 原始错误码
     * @param primaryErrorMsg   原始错误描述
     * @param primaryErrorIP    原始错误IP
     * @param cause             异常原因
     */
    public BaseException(ErrorCode errorCode, String errorMsg, String primaryErrorCode, String primaryErrorMsg,
                         String primaryErrorIP, Throwable cause) {
        super(getMessage(errorCode, errorMsg), cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.primaryErrorCode = primaryErrorCode;
        this.primaryErrorMsg = primaryErrorMsg;
        this.primaryErrorIP = primaryErrorIP;
    }

    /**
     * 提供错误码构造方法
     *
     * @param errorCode         错误码
     */
    public BaseException(ErrorCode errorCode) {
        this(errorCode, null, null, null, null, null);
    }

    /**
     * 提供错误码、原始错误码构造方法
     *
     * @param errorCode         错误码
     * @param primaryErrorCode 原始错误码
     * @param primaryErrorMsg   原始错误描述
     */
    public BaseException(ErrorCode errorCode, String primaryErrorCode, String primaryErrorMsg) {
        this(errorCode, null, primaryErrorCode, primaryErrorMsg, IPUtil.getServerIp(), null);
    }

    /**
     * 提供错误码、原始错误码、原始错误IP构造方法
     *
     * @param errorCode         错误码
     * @param primaryErrorCode 原始错误码
     * @param primaryErrorMsg   原始错误描述
     * @param primaryErrorIP    原始错误IP
     */
    public BaseException(ErrorCode errorCode, String primaryErrorCode, String primaryErrorMsg, String primaryErrorIP) {
        this(errorCode, null, primaryErrorCode, primaryErrorMsg, primaryErrorIP, null);
    }

    /**
     * 提供错误码、补充错误描述构造方法
     *
     * @param errorCode         错误码
     * @param extraMsg          补充错误描述
     */
    public BaseException(ErrorCode errorCode, String extraMsg) {
        this(errorCode, extraMsg, null, null, null, null);
    }

    /**
     * 提供错误码、补充错误描述、原始错误码、原始错误IP构造方法
     *
     * @param errorCode         错误码
     * @param extraMsg          补充错误描述
     * @param primaryErrorCode 原始错误码
     * @param primaryErrorMsg   原始错误描述
     * @param primaryErrorIP    原始错误IP
     */
    public BaseException(ErrorCode errorCode, String extraMsg, String primaryErrorCode, String primaryErrorMsg,
                         String primaryErrorIP) {
        this(errorCode, extraMsg, primaryErrorCode, primaryErrorMsg, primaryErrorIP, null);
    }

    /**
     * 获得异常码信息
     *
     * @return ErrorCode
     */
    public ErrorCode getErrorCode() {
        return errorCode;
    }

    /**
     * 返回除了错误码本身描述的提示信息外，额外补充的信息
     *
     * @return the extraMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * 返回原始错误码
     * @return
     */
    public String getPrimaryErrorCode() {
        return primaryErrorCode;
    }

    /**
     * 设置原始错误码
     * @return
     */
    public void setPrimaryErrorCode(String primaryErrorCode) {
        this.primaryErrorCode = primaryErrorCode;
    }

    /**
     * 返回原始错误码描述
     * @return
     */
    public String getPrimaryErrorMsg() {
        return primaryErrorMsg;
    }

    /**
     * 设置原始错误码描述
     * @return
     */
    public void setPrimaryErrorMsg(String primaryErrorMsg) {
        this.primaryErrorMsg = primaryErrorMsg;
    }

    /**
     * 返回原始错误IP
     * @return
     */
    public String getPrimaryErrorIP() {
        return primaryErrorIP;
    }

    /**
     * 设置原始错误码IP
     * @return
     */
    public void setPrimaryErrorIP(String primaryErrorIP) {
        this.primaryErrorIP = primaryErrorIP;
    }

    /**
     * 设置除了错误码本身描述的提示信息外，额外补充的信息
     *
     * @param errorMsg the errorMsg to set
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
     * 获取错误码描述
     * @param errorCode
     * @param extraMessage
     * @return
     */
    private static String getMessage(ErrorCode errorCode, String extraMessage) {
        extraMessage = (null != extraMessage) ? extraMessage : "";
        return MessageHelper.formatMsg(MSG_TEMPLATE, errorCode.getCode(), errorCode.getDesc(), extraMessage);
    }
}
