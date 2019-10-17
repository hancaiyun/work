package com.nicehancy.work.common.utils;

import com.nicehancy.work.common.constant.CommonConstant;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一目录ID处理工具类
 * <p>
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/10/16 20:12
 **/
public class DirectoryIdDealUtil {

    /**
     * 根据id获取三级目录目录名
     * @param id            id
     * @return              目录名map
     */
    public Map<String, String> getDirectoryById(String id){
        if(null == id || "".equals(id)){
            return null;
        }
        Map<String, String> directory = new HashMap<>();
        if("111".equals(id)){
            directory.put(CommonConstant.KEY_OF_PRIMARY_DIRECTORY,"工作");
            return directory;
        }
        if("112".equals(id)){
            directory.put(CommonConstant.KEY_OF_SECONDARY_DIRECTORY,"备份");
            return directory;
        }
        if("113".equals(id)){
            directory.put(CommonConstant.KEY_OF_TERTIARY_DIRECTORY,"学习");
            return directory;
        }

        if("114".equals(id)){
            directory.put(CommonConstant.KEY_OF_PRIMARY_DIRECTORY,"工作");
            directory.put(CommonConstant.KEY_OF_SECONDARY_DIRECTORY,"POS");
        }

        return null;
    }
}
