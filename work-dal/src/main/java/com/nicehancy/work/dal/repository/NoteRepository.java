package com.nicehancy.work.dal.repository;

import com.nicehancy.work.dal.model.NoteDO;

/**
 * 笔记数据库操作接口
 * <p>
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/10/17 11:05
 **/
public interface NoteRepository {

    /**
     * 查询文档
     * @param documentId        文档id
     * @return                  文档信息
     */
    NoteDO queryByFileId(String documentId);

    /**
     * 保存笔记
     * @param noteDO             笔记DO
     */
    void saveNote(NoteDO noteDO);

    /**
     * 根据文档id更新文档内容
     * @param noteDO              文档
     */
    void updateContent(NoteDO noteDO);
}
