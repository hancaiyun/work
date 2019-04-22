package com.nicehancy.work.common.utils;

import com.google.gson.Gson;
import org.springframework.util.Assert;

/**
 * <p>
 *     Gson工具类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/19 9:13
 **/
public class GsonUtil {

    /**
     * java对象转json字符串
     * @param obj               message对象
     * @return                  字符
     */
    public static  String toJson(Object obj){
        Assert.notNull(obj, "null 不能转换为json");
        Gson gson = new Gson();
        return  gson.toJson(obj);
    }

    /**
     * json字符串转成java对象
     * @param str           字符串
     * @param type           class对象
     * @param <T>            class对象
     * @return
     */
    public static <T> T fromJson(String str,Class<T> type){
        Gson gson = new Gson();
        return gson.fromJson(str, type);
    }
}