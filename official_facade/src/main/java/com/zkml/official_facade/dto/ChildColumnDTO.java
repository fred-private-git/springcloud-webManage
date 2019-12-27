package com.zkml.official_facade.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class ChildColumnDTO implements Serializable {

    @ApiModelProperty(value = "",example = "",required = false)
    private static final long serialVersionUID = -1L;

    /**
     *  子栏目id
     */
    @ApiModelProperty(value = "子栏目id",example = "",required = false)
    private String childColumnId;

    /**
     *  子栏目名称
     */
    @ApiModelProperty(value = "子栏目名称",example = "",required = false)
    private String childColumnName;

    /**
     *  所属栏目id
     */
    @ApiModelProperty(value = "所属栏目id",example = "",required = false)
    private String belongColumnId;

    @ApiModelProperty(value = "创建时间",example = "",required = false)
    private Date dateCreated;

    @ApiModelProperty(value = "最后修改时间",example = "",required = false)
    private Date lastUpdated;

    @ApiModelProperty(value = "逻辑删除",example = "",required = false)
    private String logicDelete;
}
