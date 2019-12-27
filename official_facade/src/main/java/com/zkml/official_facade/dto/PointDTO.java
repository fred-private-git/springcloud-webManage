package com.zkml.official_facade.dto;

import com.zkml.common.obj.enums.BooleanEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author fanghui
 * @date 2019-05-14 09:04:54
 */

@Data
public class PointDTO implements Serializable {
	
	/**
	 *  视察点信息ID
	 */
	@ApiModelProperty(value = "视察点信息ID",example = "",required = false)
    private String inspectionPointInfoId;

	/**
	 *  视察点名称
	 */
	@ApiModelProperty(value = "视察点名称",example = "",required = false)
    private String inspectionPointName;

	/**
	 *  地区号
	 */
	@ApiModelProperty(value = "地区号",example = "",required = false)
    private String areaId;

	/**
	 *  视察点详细地址
	 */
	@ApiModelProperty(value = "视察点详细地址",example = "",required = false)
    private String detailedAddress;

	/**
	 *  视察点的相关图片（[,,]）
	 */
	@ApiModelProperty(value = "视察点的相关图片（[,,]）",example = "",required = false)
    private String attachImg;

	/**
	 *  视察点简介
	 */
	@ApiModelProperty(value = "视察点简介",example = "",required = false)
    private String briefIntroduction;

	/**
	 *  区位图经度
	 */
	@ApiModelProperty(value = "区位图经度",example = "",required = false)
	private String site_img_y;

	/**
	 *  区位图地址纬度
	 */
	@ApiModelProperty(value = "区位图地址纬度",example = "",required = false)
	private String site_img_x;

	/**
	 *  视察点全景图地址
	 */
	@ApiModelProperty(value = "视察点全景图地址",example = "",required = false)
    private String vrImg;

	/**
	 * 录入信息时间
	 */
	@ApiModelProperty(value = "录入信息时间",example = "",required = false)
    private String dateCreated;

	/**
	 *  最后修改的时间
	 */
	@ApiModelProperty(value = "最后修改的时间",example = "",required = false)
    private String lastUpdated;

	/**
	 *  'YES'
	 */
	@ApiModelProperty(value = "逻辑删除",example = "",required = false)
	private BooleanEnum logicDelete;

}