package com.nicehancy.work.common.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * bcrypt加密工具类
 * <p>
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/9/19 18:10
 **/
public class BCryptPasswordEncoderUtil {

    /**
     * 对明文加密
     * @param str       明文
     * @return          密文
     */
    public static String encode(String str){

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //加密
        return bCryptPasswordEncoder.encode(str);
    }


    /**
     * 密码匹配
     * @param rawPassword               明文
     * @param encodedPassword           密文
     * @return                          匹配结果
     */
    public static Boolean matches(String rawPassword, String encodedPassword){

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //密码判定
        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
    }
}
