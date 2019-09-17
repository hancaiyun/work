package com.nicehancy.work.manager.dao;

import com.nicehancy.work.common.constant.CommonConstant;
import com.nicehancy.work.common.enums.DataSuorceEnum;
import com.nicehancy.work.common.exception.BusinessErrorCode;
import com.nicehancy.work.common.exception.BusinessException;
import com.nicehancy.work.dal.mapper.UserInfoMapper;
import com.nicehancy.work.dal.model.UserInfoDO;
import com.nicehancy.work.dal.repository.UserInfoRepository;
import com.nicehancy.work.manager.redis.RedisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * <p>
 *     用户信息表Dao
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/9/17 9:25
 **/
@Component
public class UserInfoDao {

    @Autowired
    private RedisManager redisManager;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserInfoRepository userInfoRepository;

    /**
     * 1、根据用户编号查询用户信息
     * @param userNo            用户ID
     * @return                  用户信息DO
     */
    public UserInfoDO queryUserInfo(String userNo){

        if(isMySQL()){
            return userInfoMapper.queryUserInfo(userNo);
        }else{
            return userInfoRepository.queryUserInfo(userNo);
        }
    }

    /**
     * 2、用户信息新增
     * @param userInfoDO        用户信息DO
     */
    public void insert(UserInfoDO userInfoDO){

        if(isMySQL()){
            userInfoMapper.insert(userInfoDO);
        }else{
            userInfoRepository.insert(userInfoDO);
        }
    }


    /**
     * 数据源判定， 是否为MySQL，不为MySQL即为MongoDB
     * @return                  是否为MySQL数据源
     */
    private boolean isMySQL(){

        //查询数据源开关
        String dataSwitch = redisManager.queryObjectByKey(CommonConstant.DATA_SOURCE_SWITCH);
        if(StringUtils.isEmpty(dataSwitch)){
            throw new BusinessException(BusinessErrorCode.SYSTEM_INNER_ERROR);
        }
        if(DataSuorceEnum.MYSQL.getCode().equals(dataSwitch)){
            return true;
        }
        return false;
    }
}
