package com.nicehancy.work.common.exception.base;

/**
 * <p>
 *     错误码接口
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/9/17 10:03
 **/
public interface ErrorCode {

    /**
     * 获取错误码
     * @return
     */
    String getCode();

    /**
     * 获取错误描述
     * @return
     */
    String getDesc();
}
