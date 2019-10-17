package com.nicehancy.work.biz.extend;

import com.nicehancy.work.manager.extend.NoteManager;
import com.nicehancy.work.manager.model.NoteBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 笔记管理biz
 * <p>
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/10/16 15:24
 **/
@Component
public class NoteBiz {

    @Autowired
    private NoteManager noteManager;

    /**
     * 根据id查询笔记
     * @param documentId    documentId
     * @return              笔记内容
     */
    public NoteBO queryById(String documentId) {

        return noteManager.queryByFileId(documentId);
    }

    /**
     * 笔记保存
     * 已存在-更新，不存在-新增
     * @param documentId    documentId
     * @param content       笔记内容
     * @return
     */
    public boolean save(String documentId, String content) {

        //查询笔记是否存在
        NoteBO noteBO = noteManager.queryByFileId(documentId);
        if(null != noteBO){
            //更新
            NoteBO noteBOForUpdate = new NoteBO();
            noteBOForUpdate.setDocumentId(documentId);
            noteBOForUpdate.setContent(content);
            noteBOForUpdate.setUpdatedBy("king");
            noteManager.updateContent(noteBOForUpdate);
        }else{
            //新增
            NoteBO noteBOForSave = new NoteBO();
            noteBOForSave.setDocumentId(documentId);
            noteBOForSave.setContent(content);
            noteBOForSave.setCreatedBy("king");
            noteBOForSave.setUpdatedBy("king");
            noteManager.saveNote(noteBOForSave);
        }
        return true;
    }
}
