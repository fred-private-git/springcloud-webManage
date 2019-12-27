package com.zkml.official_facade.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by fanghui on 2019/6/14.
 */
@Data
public class TitleDTO implements Serializable {

    /**
     *  主键id
     */
    @ApiModelProperty(value = "主键id",example = "",required = false)
    private String titleId;

    /**
     *  主题名称
     */
    @ApiModelProperty(value = "主题名称",example = "",required = false)
    private String titleName;

    /**
     *  主题介绍
     */
    @ApiModelProperty(value = "主题介绍",example = "",required = false)
    private String titleIntroduction;

    /**
     *  插图
     */
    @ApiModelProperty(value = "插图",example = "",required = false)
    private String uploadImage;

    /**
     *  轮播图片
     */
    @ApiModelProperty(value = "轮播图片",example = "",required = false)
    private List<String> attachImg;

    /**
     *  所在地区id
     */
    @ApiModelProperty(value = "所在地区id",example = "",required = false)
    private String areaId;

    /**
     * 主题下的所有栏目
     */
    @ApiModelProperty(value = "主题下的所有栏目",example = "",required = false)
    private List<ColumnDTOVO> columnBOList;
}
