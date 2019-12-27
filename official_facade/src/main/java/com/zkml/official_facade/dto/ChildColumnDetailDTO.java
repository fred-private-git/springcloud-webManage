package com.zkml.official_facade.dto;

import com.zkml.common.obj.enums.BooleanEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class ChildColumnDetailDTO implements Serializable {

    @ApiModelProperty(value = "",example = "",required = false)
    private static final long serialVersionUID = -1L;

    @ApiModelProperty(value = "子栏目内容id",example = "",required = false)
    private String childColumnDetailId;

    @ApiModelProperty(value = "子栏目内容名称",example = "",required = false)
    private String childColumnDetailName;

    @ApiModelProperty(value = "所属子栏目id",example = "",required = false)
    private String belongChildColumnId;

    @ApiModelProperty(value = "简介",example = "",required = false)
    private String briefIntroduction;

    @ApiModelProperty(value = "内容详情",example = "",required = false)
    private String childColumnDetail;

    @ApiModelProperty(value = "插图",example = "",required = false)
    private String attachImg;

    @ApiModelProperty(value = "创建时间",example = "",required = false)
    private Date dateCreated;

    @ApiModelProperty(value = "最后修改时间",example = "",required = false)
    private Date lastUpdated;

    @ApiModelProperty(value = "逻辑删除",example = "",required = false)
    private String logicDelete;
}
