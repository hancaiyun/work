package com.nicehancy.work.manager.extend;

import com.nicehancy.work.manager.model.NoteBO;

/**
 * 笔记数据库管理类
 * <p>
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/10/17 10:47
 **/
public interface NoteManager {

    /**
     * 通过文档id查询笔记
     * @param documentId        文档id
     * @return                  文档BO
     */
    NoteBO queryByFileId(String documentId);

    /**
     * 保存笔记
     * @param noteBOForSave
     */
    void saveNote(NoteBO noteBOForSave);

    /**
     * 根据文档id更新文档内容
     * @param noteBO
     */
    void updateContent(NoteBO noteBO);
}
