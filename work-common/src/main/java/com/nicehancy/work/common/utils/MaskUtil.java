package com.nicehancy.work.common.utils;

import com.nicehancy.work.common.exception.BusinessErrorCode;
import com.nicehancy.work.common.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Method;

/**
 * <p>
 *     掩码工具类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/8/30 15:13
 **/
public class MaskUtil {

    /**
     * 私有构造函数
     */
    private MaskUtil(){
    }

    /**
     * 掩码处理
     * @param type              数据类型
     * @param str               待脱敏字符串
     * @return                  掩码
     */
    public static String getMask(String type, String str){

        /**
         * 姓名脱敏
         */
        if(SensitiveType.NAME.getCode().equals(type)){
            int length = str.length();
            StringBuffer sb = new StringBuffer();
            for(int i =0; i < length-1; i++){
                sb.append("*");
            }
            return str.substring(0,1) + sb;
        }
        /**
         * 手机号脱敏
         */
        if(SensitiveType.MOBILE.getCode().equals(type)){
            return str.replaceAll("(?<=\\w{3})\\w(?=\\w{4})", "*");
        }
        /**
         * 身份证脱敏
         */
        if(SensitiveType.IDCARD.getCode().equals(type)){
            return str.replaceAll("(?<=\\w{4})\\w(?=\\w{4})", "*");
        }
        /**
         * 营业执照脱敏
         */
//        if(DataTypeEnum.LICENCE.getCode().equals(type)){
//
//        }

        throw new BusinessException(BusinessErrorCode.DATA_TYPE_IS_ERROR);
    }


    public static Method [] findAllMethod(Class<?> clazz){
        Method[] methods= clazz.getMethods();
        return methods;
    }

    /**
     * 脱敏属性类型
     */
    @AllArgsConstructor
    @Getter
    public enum SensitiveType {

        /**
         * 账户名
         * 姓名
         */
        NAME("NAME", "姓名"),

        /**
         * 手机号
         */
        MOBILE("MOBILE", "手机号"),

        /**
         * 身份证号
         */
        IDCARD("IDCARD", "身份证");

        private String code;

        private String desc;
    }

}
