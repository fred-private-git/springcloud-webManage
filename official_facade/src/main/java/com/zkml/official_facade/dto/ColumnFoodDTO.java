package com.zkml.official_facade.dto;

import com.zkml.common.obj.enums.BooleanEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2019/7/5.
 */
@Data
public class ColumnFoodDTO {
    /**
     *  id
     */
    @ApiModelProperty(value = "id",example = "",required = false)
    private String columnFoodId;

    /**
     *  美食名称
     */
    @ApiModelProperty(value = "美食名称",example = "",required = false)
    private String columnFoodName;

    /**
     *  所属栏目id
     */
    @ApiModelProperty(value = "所属栏目id",example = "",required = false)
    private String belongColumnId;

    /**
     *  制作原料
     */
    @ApiModelProperty(value = "制作原料",example = "",required = false)
    private String rawMateria;

    /**
     *  美食简介
     */
    @ApiModelProperty(value = "美食简介",example = "",required = false)
    private String briefIntroduction;

    /**
     *  制作方法
     */
    @ApiModelProperty(value = "制作方法",example = "",required = false)
    private String foodMake;

    /**
     *  推荐餐厅
     */
    @ApiModelProperty(value = "推荐餐厅",example = "",required = false)
    private String foodRestaurant;

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
