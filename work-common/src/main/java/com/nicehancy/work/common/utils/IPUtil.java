package com.nicehancy.work.common.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 获取IP地址工具类
 * <p>
 *     1、获取IP地址
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/9/17 9:49
 **/
public class IPUtil {

    /**
     * 获取IP地址
     *
     * @return
     */
    public static String getServerIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        }
        catch (UnknownHostException e) {
            return "127.0.0.1";
        }
    }
}
