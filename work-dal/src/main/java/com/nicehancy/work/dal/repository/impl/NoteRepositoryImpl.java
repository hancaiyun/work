package com.nicehancy.work.dal.repository.impl;

import com.mongodb.WriteResult;
import com.mongodb.client.result.UpdateResult;
import com.nicehancy.work.common.utils.UUIDUtil;
import com.nicehancy.work.dal.model.NoteDO;
import com.nicehancy.work.dal.repository.NoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Date;

/**
 * 笔记repository
 * <p>
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/10/17 12:09
 **/
@Slf4j
@Repository(value = "noteRepositoryImpl")
public class NoteRepositoryImpl implements NoteRepository{

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 根据文档id获取文档信息
     * @param documentId        文档id
     * @return                  文档信息
     */
    @Override
    public NoteDO queryByFileId(String documentId) {

        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.and("documentId").is(documentId);

        query.addCriteria(criteria);
        return mongoTemplate.findOne(query, NoteDO.class);
    }

    /**
     * 保存笔记
     * @param noteDO             笔记DO
     */
    @Override
    public void saveNote(NoteDO noteDO) {

        //字段初始化
        noteDO.setId(Long.valueOf(UUIDUtil.createNoByUUId()));
        noteDO.setCreatedAt(new Date());
        noteDO.setUpdatedAt(new Date());
        noteDO.setUpdatedBy(noteDO.getUpdatedBy());

        mongoTemplate.insert(noteDO);
    }

    /**
     * 根据文档id更新文档内容
     * @param noteDO              文档
     */
    @Override
    public void updateContent(NoteDO noteDO) {

        //查询条件
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.and("documentId").is(noteDO.getDocumentId());

        //更新内容
        Update update = new Update();
        update.set("content", noteDO.getContent());
        update.set("updatedAt", new Date());
        update.set("updatedBy", noteDO.getUpdatedBy());

        //更新操作
        mongoTemplate.updateFirst(query, update, NoteDO.class);

    }
}
