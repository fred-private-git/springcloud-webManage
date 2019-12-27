package com.zkml.official_reception.client.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fanghui on 2019/6/14.
 */
@Data
public class ColumnBO implements Serializable {
    private static final long serialVersionUID = -1L;

    /**
     *  栏目主键id
     */
    private String columnId;

    /**
     *  栏目名称
     */
    private String columnName;

    /**
     *  属于哪个主题
     */
    private String belongTitleId;

    /**
     *  禁用、启用
     */
    private String status;

    /**
     *  栏目图标
     */
    private String icon;

    /**
     *  是否有删除按钮
     */
    private String mark;

    /**
     * 创建时间
     */
    private Date dateCreated;

    /**
     * 最后修改时间
     */
    private Date lastUpdated;

    /**
     * 逻辑删除
     */
    private String logicDetele;
}
