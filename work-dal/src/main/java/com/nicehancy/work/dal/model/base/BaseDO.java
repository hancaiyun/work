package com.nicehancy.work.dal.model.base;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *     数据库DO基类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/3 0:58
 **/
@Getter
@Setter
public class BaseDO {

    /**
     * 数据库id
     */
    private Long id;

    /**
     * 创建时间
     */
    private String createdAt;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 更新时间
     */
    private String updatedAt;

    /**
     * 更新人
     */
    private String updatedBy;
}
