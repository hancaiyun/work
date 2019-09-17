package com.nicehancy.work.dal.repository.impl;

import com.nicehancy.work.dal.model.UserInfoDO;
import com.nicehancy.work.dal.repository.UserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * <p>
 *     用户信息表操作接口实现
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/9/17 9:17
 **/
@Slf4j
@Repository(value = "userInfoRepositoryImpl")
public class UserInfoRepositoryImpl implements UserInfoRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 通过用户编号查询用户信息
     * @param userNo                用户登录号
     * @return                      用户信息
     */
    @Override
    public UserInfoDO queryUserInfo(String userNo) {

        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.and("userNo").is(userNo);

        query.addCriteria(criteria);
        return mongoTemplate.findOne(query, UserInfoDO.class);
    }

    /**
     * 新增用户信息
     * @param userInfoDO            用户信息
     */
    @Override
    public void insert(UserInfoDO userInfoDO) {

        //字段初始化
        userInfoDO.setCreatedAt(new Date());
        userInfoDO.setUpdatedAt(new Date());

        mongoTemplate.insert(userInfoDO);
    }
}
