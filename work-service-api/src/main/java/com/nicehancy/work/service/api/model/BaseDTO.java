package com.nicehancy.work.service.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 *     DTO父类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/2 16:29
 **/
@Getter
@Setter
@ToString
public class BaseDTO {

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
