package com.zkml.official_facade.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by fanghui on 2019/4/30.
 */

@Data
public class HotelDTO implements Serializable{

    private static final long serialVersionUID = -1L;

    /**
     *  酒店id
     */
    @ApiModelProperty(value = "酒店id",example = "",required = false)
    private String hotelInfoId;

    /**
     *  酒店名称
     */
    @ApiModelProperty(value = "酒店名称",example = "",required = false)
    private String hotelName;

    /**
     *  酒店所在的地区区号
     */
    @ApiModelProperty(value = "酒店所在的地区区号",example = "",required = false)
    private String areaId;

    /**
     *  酒店详细地址
     */
    @ApiModelProperty(value = "酒店详细地址",example = "",required = false)
    private String detailedAddress;

    /**
     *  酒店相关图片
     */
    @ApiModelProperty(value = "酒店相关图片",example = "",required = false)
    private String attachImg;

    /**
     *  酒店简介
     */
    @ApiModelProperty(value = "酒店简介",example = "",required = false)
    private String briefIntroduction;

    /**
     *  酒店区位图
     */
    @ApiModelProperty(value = "酒店区位图",example = "",required = false)
    private String siteImg;

    /**
     *  酒店VR图url
     */
    @ApiModelProperty(value = "酒店VR图url",example = "",required = false)
    private String vrImg;
}
