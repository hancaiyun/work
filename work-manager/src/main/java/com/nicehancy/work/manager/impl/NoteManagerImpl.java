package com.nicehancy.work.manager.impl;

import com.nicehancy.work.dal.repository.NoteRepository;
import com.nicehancy.work.manager.convert.NoteBOConvert;
import com.nicehancy.work.manager.extend.NoteManager;
import com.nicehancy.work.manager.model.NoteBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 笔记数据库接口实现类
 * <p>
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/10/17 10:58
 **/
@Component
public class NoteManagerImpl implements NoteManager {

    @Autowired
    NoteRepository noteRepository;

    /**
     * 根据文档id查询文档信息
     * @param documentId        文档id
     * @return                  文档BO
     */
    @Override
    public NoteBO queryByFileId(String documentId) {
        return NoteBOConvert.getBOByDO(noteRepository.queryByFileId(documentId));
    }

    /**
     * 保存笔记
     * @param noteBO            笔记BO
     */
    @Override
    public void saveNote(NoteBO noteBO) {
        noteRepository.saveNote(NoteBOConvert.getDOByBO(noteBO));
    }

    /**
     * 根据文档id更新文档内容
     * @param noteBO            文档
     */
    @Override
    public void updateContent(NoteBO noteBO) {
        noteRepository.updateContent(NoteBOConvert.getDOByBO(noteBO));
    }
}
