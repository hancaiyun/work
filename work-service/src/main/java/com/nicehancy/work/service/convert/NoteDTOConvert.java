package com.nicehancy.work.service.convert;


import com.nicehancy.work.manager.model.NoteBO;
import com.nicehancy.work.service.api.extend.NoteDTO;

/**
 *  笔记DTO转换类
 * <p>
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/10/17 12:23
 **/
public class NoteDTOConvert {

    /**
     * 笔记转换类
     */
    private NoteDTOConvert(){
    }

    /**
     * 根据BO获取DTO
     * @param noteBO        BO
     * @return              DTO
     */
    public static NoteDTO getDTOByBO(NoteBO noteBO) {

        if (noteBO == null) {
            return null;
        }

        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setUserNo(noteBO.getUserNo());
        noteDTO.setPrimaryDirectory(noteBO.getPrimaryDirectory());
        noteDTO.setSecondaryDirectory(noteBO.getSecondaryDirectory());
        noteDTO.setTertiaryDirectory(noteBO.getTertiaryDirectory());
        noteDTO.setDocumentId(noteBO.getDocumentId());
        noteDTO.setDocumentName(noteBO.getDocumentName());
        noteDTO.setContent(noteBO.getContent());
        noteDTO.setStatus(noteBO.getStatus());
        noteDTO.setRemark(noteBO.getRemark());
        noteDTO.setCreatedAt(noteBO.getCreatedAt());
        noteDTO.setCreatedBy(noteBO.getCreatedBy());
        noteDTO.setUpdatedAt(noteBO.getUpdatedAt());
        noteDTO.setUpdatedBy(noteBO.getUpdatedBy());

        return noteDTO;
    }

}
