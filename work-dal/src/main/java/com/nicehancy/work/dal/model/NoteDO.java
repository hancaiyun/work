package com.nicehancy.work.dal.model;

import com.nicehancy.work.dal.model.base.BaseDO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 笔记DO模型
 * <p>
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/10/17 10:50
 **/
@Getter
@Setter
@Document("c_note_info")
public class NoteDO extends BaseDO {

    /**
     * 用户编号
     */
    private String userNo;

    /**
     * 一级目录
     */
    private String primaryDirectory;

    /**
     * 二级目录
     */
    private String secondaryDirectory;

    /**
     * 三级目录
     */
    private String tertiaryDirectory;

    /**
     * 文档id
     */
    private String documentId;

    /**
     * 文档名
     */
    private String documentName;

    /**
     * 文档内容
     */
    private String content;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

}