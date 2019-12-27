package com.zkml.official_reception.server.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fanghui on 2019/6/14.
 */
@Data
public class ColumnPOVO implements Serializable {

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
     * 主题的名称
     */
    private String titleName;
    /**
     *  禁用、启用
     */
    private String status;

    /**
     *  栏目图标
     */
    private  String icon;

    /**
     *  是否有删除按钮
     */
    private String mark;

    private Date dateCreated;

    private Date lastUpdated;

    private String logicDetele;
}
