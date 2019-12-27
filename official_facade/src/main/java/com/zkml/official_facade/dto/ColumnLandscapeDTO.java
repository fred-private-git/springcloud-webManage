package com.zkml.official_facade.dto;

import com.zkml.common.obj.enums.BooleanEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;

/**
 * Created by fanghui on 2019/6/14.
 */
@Data
public class ColumnLandscapeDTO implements Serializable {

    /**
     *  主键id
     */
    @ApiModelProperty(value = "主键id",example = "",required = false)
    private String columnLandscapeId;

    /**
     *  名称
     */
    @ApiModelProperty(value = "名称",example = "",required = false)
    private String columnLandscapeName;

    /**
     *  所属的栏目
     */
    @ApiModelProperty(value = "所属的栏目",example = "",required = false)
    private String belongColumnId;

    /**
     *  地区
     */
    @ApiModelProperty(value = "地区",example = "",required = false)
    private String areaId;

    /**
     *  详细地址
     */
    @ApiModelProperty(value = "详细地址",example = "",required = false)
    private String detailedAddress;

    /**
     *  山水风光简介
     */
    @ApiModelProperty(value = "山水风光简介",example = "",required = false)
    private String briefIntroduction;

    /**
     *  百度百科链接地址
     */
    @ApiModelProperty(value = "百度百科链接地址",example = "",required = false)
    private String url;

    /**
     *  区位图的经度
     */
    @ApiModelProperty(value = "区位图的经度",example = "",required = false)
    private String siteImgY;

    /**
     *  区位图的纬度
     */
    @ApiModelProperty(value = "区位图的纬度",example = "",required = false)
    private String siteImgX;

    /**
     *  相关图片
     */
    @ApiModelProperty(value = "相关图片",example = "",required = false)
    private List<String> attachImg;

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
    private BooleanEnum logicDelete;
}
