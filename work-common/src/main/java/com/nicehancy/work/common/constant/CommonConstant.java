package com.nicehancy.work.common.constant;

/**
 * <p>
 *     常量类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/18 14:45
 **/
public final class CommonConstant {

    /**
     * 私有的构造函数
     */
    private CommonConstant() {
    }

    /**
     * 系统操作人
     */
    public static final String SYSTEM_OPERATOR = "SYSTEM";


    /********************文件常量************************/

    /**
     * 本地文件临时路径
     */
    public static final String LOCAL_FILE_LOCATION = "/data/dataTemp/";

    /**
     * 文件头
     */
    public static final String[] FILE_HEADER_DEMO = { "序号", "用户编号", "用户名", "权限", "操作", "原因" };
}