package com.nicehancy.work.manager.convert;

import com.nicehancy.work.dal.model.NoteDO;
import com.nicehancy.work.manager.model.NoteBO;

/**
 * 笔记BO模型转换类
 * <p>
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/10/17 11:21
 **/
public class NoteBOConvert {

    /**
     * 无参私有构造函数
     */
    private NoteBOConvert(){
    }

    /**
     * 通过BO获取DO
     * @param noteBO     BO
     * @return           DO
     */
    public static NoteDO getDOByBO(NoteBO noteBO) {

        if (noteBO == null) {
            return null;
        }

        NoteDO noteDO = new NoteDO();
        noteDO.setUserNo(noteBO.getUserNo());
        noteDO.setPrimaryDirectory(noteBO.getPrimaryDirectory());
        noteDO.setSecondaryDirectory(noteBO.getSecondaryDirectory());
        noteDO.setTertiaryDirectory(noteBO.getTertiaryDirectory());
        noteDO.setDocumentId(noteBO.getDocumentId());
        noteDO.setDocumentName(noteBO.getDocumentName());
        noteDO.setContent(noteBO.getContent());
        noteDO.setStatus(noteBO.getStatus());
        noteDO.setRemark(noteBO.getRemark());
        noteDO.setCreatedAt(noteBO.getCreatedAt());
        noteDO.setCreatedBy(noteBO.getCreatedBy());
        noteDO.setUpdatedAt(noteBO.getUpdatedAt());
        noteDO.setUpdatedBy(noteBO.getUpdatedBy());

        return noteDO;
    }

    /**
     * 通过DO获取BO
     * @param noteDO      DO
     * @return            BO
     */
    public static NoteBO getBOByDO(NoteDO noteDO) {

        if (noteDO == null) {
            return null;
        }

        NoteBO noteBO = new NoteBO();
        noteBO.setUserNo(noteDO.getUserNo());
        noteBO.setPrimaryDirectory(noteDO.getPrimaryDirectory());
        noteBO.setSecondaryDirectory(noteDO.getSecondaryDirectory());
        noteBO.setTertiaryDirectory(noteDO.getTertiaryDirectory());
        noteBO.setDocumentId(noteDO.getDocumentId());
        noteBO.setDocumentName(noteDO.getDocumentName());
        noteBO.setContent(noteDO.getContent());
        noteBO.setStatus(noteDO.getStatus());
        noteBO.setRemark(noteDO.getRemark());
        noteBO.setCreatedAt(noteDO.getCreatedAt());
        noteBO.setCreatedBy(noteDO.getCreatedBy());
        noteBO.setUpdatedAt(noteDO.getUpdatedAt());
        noteBO.setUpdatedBy(noteDO.getUpdatedBy());

        return noteBO;
    }
}
