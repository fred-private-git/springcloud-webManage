package com.zkml.official_facade.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;

/**
 * Created by fanghui on 2019/6/14.
 */
@Data
public class ColumnDTO implements Serializable {

    @ApiModelProperty(value = "",example = "",required = false)
    private static final long serialVersionUID = -1L;

    /**
     *  栏目主键id
     */
    @ApiModelProperty(value = "栏目主键id",example = "",required = false)
    private String columnId;

    /**
     *  栏目名称
     */
    @ApiModelProperty(value = "栏目名称",example = "",required = false)
    private String columnName;

    /**
     *  属于哪个主题
     */
    @ApiModelProperty(value = "属于哪个主题",example = "",required = false)
    private String belongTitleId;

    /**
     *  禁用、启用
     */
    @ApiModelProperty(value = "禁用、启用",example = "",required = false)
    private String status;

    /**
     *  栏目图标
     */
    @ApiModelProperty(value = "栏目图标",example = "",required = false)
    private String icon;

    /**
     *  是否有删除按钮
     */
    @ApiModelProperty(value = "是否有删除按钮",example = "",required = false)
    private String mark;

    /**
     * 	创建栏目时间
     */
    @ApiModelProperty(value = "创建栏目时间",example = "",required = false)
    private Date dateCreated;

    /**
     * 最后修改时间
     */
    @ApiModelProperty(value = "最后修改时间",example = "",required = false)
    private Date lastUpdated;

    /**
     * 逻辑删除
     */
    @ApiModelProperty(value = "逻辑删除",example = "",required = false)
    private String logicDetele;
}
