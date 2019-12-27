package com.zkml.official_reception.client.query;

import lombok.Data;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;

/**
 * Created by fanghui on 2019/5/16.
 */
@Data
public class ReceptionQuery implements Serializable{

    /**
     * id查询项
     */
    @ApiModelProperty(value = "id查询项",example = "",required = false)
    private String id;

    /**
     * 名称查询项
     */
    @ApiModelProperty(value = "名称查询项",example = "",required = false)
    private String name;

    /**
     * 地区id查询项
     */
    @ApiModelProperty(value = "地区id查询项",example = "",required = false)
    private String areaId;

    /**
     * 申请人查询项
     */
    @ApiModelProperty(value = "申请人查询项",example = "",required = false)
    private String applyUser;

    /**
     * 方案号查询项
     */
    @ApiModelProperty(value = "方案号查询项",example = "",required = false)
    private String receptionNo;

    /**
     * 接待级别查询项
     */
    @ApiModelProperty(value = "接待级别查询项",example = "",required = false)
    private String receptionLevel;

    /**
     * 审核状态查询项
     */
    @ApiModelProperty(value = "审核状态查询项",example = "",required = false)
    private String auditStatus;

    /**
     * 分页参数
     */
    @ApiModelProperty(value = "分页参数",example = "",required = false)
    private Long max = 10L;

    /**
     * 分页参数
     */
    @ApiModelProperty(value = "分页参数",example = "",required = false)
    private Long offset = 0L;
}
