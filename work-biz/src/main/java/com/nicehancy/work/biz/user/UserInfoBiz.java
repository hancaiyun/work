package com.nicehancy.work.biz.user;

import com.nicehancy.work.common.utils.GsonUtil;
import com.nicehancy.work.manager.UserInfoManager;
import com.nicehancy.work.manager.model.UserInfoBO;
import com.nicehancy.work.manager.redis.RedisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 *     用户信息操作业务处理
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/2 17:36
 **/
@Component
public class UserInfoBiz {

    @Autowired
    private UserInfoManager userInfoManager;

    /**
     * redis缓存管理类
     */
    @Autowired
    private RedisManager redisManager;

    /**
     *  用户信息查询
     * @param userNo                登录号
     * @return                      用户信息
     */
    public UserInfoBO queryUserInfo(String userNo) {

        //查询缓存
        UserInfoBO userInfoBO = GsonUtil.fromJson(redisManager.queryObjectByKey(userNo), UserInfoBO.class);
        if(null != userInfoBO){
            return userInfoBO;
        }else{
            userInfoBO = userInfoManager.queryUserInfo(userNo);
            //缓存空结果,设置超时时间（5分钟）
            if(null == userInfoBO){
                redisManager.insertObject(GsonUtil.toJson(userInfoBO), userNo, 300);
            }else{
                //缓存用户信息，设置超时时间（2小时） TODO 暂不新增到缓存，日期格式缓存后解析时会报错-日期格式错误
                //redisManager.insertObject(userInfoBO, userNo, 7200);
            }
            return userInfoBO;
        }
    }

    /**
     * 新增用户信息
     * @param userInfoBO               用户信息
     */
    public void addUser(UserInfoBO userInfoBO) {

        userInfoManager.addUser(userInfoBO);
    }
}
