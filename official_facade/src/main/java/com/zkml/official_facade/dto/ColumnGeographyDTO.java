package com.zkml.official_facade.dto;

import com.zkml.common.obj.enums.BooleanEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
public class ColumnGeographyDTO implements Serializable {

	private static final long serialVersionUID = -1L;
	
	/**
	 *  id
	 */
	@ApiModelProperty(value = "id",example = "",required = false)
    private String geographyId;

	/**
	 *  地域名称
	 */
	@ApiModelProperty(value = "地域名称",example = "",required = false)
    private String geographyName;

	/**
	 *  所属栏目id
	 */
	@ApiModelProperty(value = "所属栏目id",example = "",required = false)
    private String belongColumnId;

	/**
	 *  行政级别
	 */
	@ApiModelProperty(value = "行政级别",example = "",required = false)
    private String geographyLevel;


	/**
	 *  地域详情
	 */
	@ApiModelProperty(value = "地域详情",example = "",required = false)
    private String geographyDetail;

	/**
	 *  轮播图片
	 */
	@ApiModelProperty(value = "轮播图片",example = "",required = false)
    private List<String> geographyImg;

    /**
     * 创建时间
	 */
	@ApiModelProperty(value = "创建时间",example = "",required = false)
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