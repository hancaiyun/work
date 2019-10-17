package com.nicehancy.work.manager.model;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

/**
 * 笔记BO模型
 * <p>
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/10/17 10:50
 **/
@Getter
@Setter
public class NoteBO {

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

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 更新时间
     */
    private Date updatedAt;

    /**
     * 更新人
     */
    private String updatedBy;

}
