package com.nicehancy.work.common.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * <p>
 *     MD5工具类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/4 16:34
 **/
public final class MD5Util {

    /**
     * 无参构造
     */
    private MD5Util(){}

    /**
     *  MD5加密
     * @param text              明文
     * @param key               密匙
     * @return                  密文
     */
    public static String md5(String text, String key){
        return DigestUtils.md5Hex(text + key);
    }

}
