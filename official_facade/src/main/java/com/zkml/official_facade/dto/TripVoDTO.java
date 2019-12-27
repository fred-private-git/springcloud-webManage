package com.zkml.official_facade.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by fanghui on 2019/5/22.
 */
@Data
public class TripVoDTO {

    /**
     * 行程名称
     */
    @ApiModelProperty(value = "行程名称")
    private  String  tripName;

    /**
     * 行程列表
     */
    @ApiModelProperty(value = "行程列表")
    private List<TripPlanDTO> tripPlanDTOList;

}
