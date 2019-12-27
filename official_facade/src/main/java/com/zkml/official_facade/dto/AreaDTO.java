package com.zkml.official_facade.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author zhouyang
 * @date 2019-05-06 11:06:21
 */

@Data
public class AreaDTO implements Serializable {

    @ApiModelProperty(value = "",example = "",required = false)
	private static final long serialVersionUID = -1L;

    /**
     *  地区主键id
     */
    @ApiModelProperty(value = "地区主键id",example = "",required = false)
    private String areaId;

    /**
     *  地区名称
     */
    @ApiModelProperty(value = "地区名称",example = "",required = false)
    private String areaName;

    /**
     *  级别：0国家 1省 2市 3县
     */
    @ApiModelProperty(value = "级别：0国家 1省 2市 3县",example = "",required = false)
    private int level;

    /**
     *  父节点
     */
    @ApiModelProperty(value = "父节点",example = "",required = false)
    private String parentId;

    /**
     * 	排序
     */
    @ApiModelProperty(value = "排序",example = "",required = false)
    private Integer sortNo;

}