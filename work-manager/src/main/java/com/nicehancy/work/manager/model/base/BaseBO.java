package com.nicehancy.work.manager.model.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * <p>
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/3 0:37
 **/
@Getter
@Setter
@ToString
public class BaseBO {

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
