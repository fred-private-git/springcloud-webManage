package com.zkml.official_facade.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by fanghui on 2019/5/22.
 */
@Data
public class TripPreviewDTO {


    /**
     * 接待方案
     */
    @ApiModelProperty(value = "接待方案")
    private ReceptionLetterDTO receptionLetterDTO;

    /**
     * 行程安排
     */
    @ApiModelProperty(value = "行程安排")
    private TripVoDTO tripVoDTO;

    /**
     * 新增还是修改的类型选择
     */
    @ApiModelProperty(value = "新增还是修改的类型选择,ADD,UPDATE")
    private String type;
}
