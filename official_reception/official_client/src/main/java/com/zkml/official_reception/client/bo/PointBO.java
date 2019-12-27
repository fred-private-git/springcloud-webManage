package com.zkml.official_reception.client.bo;

import com.zkml.common.obj.enums.BooleanEnum;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author fanghui
 * @date 2019-05-14 09:04:54
 */

@Data
public class PointBO implements Serializable {

	private static final long serialVersionUID = -1L;
	
	/**
	 *  视察点信息ID
	 */
    private String inspectionPointInfoId;

	/**
	 *  视察点名称
	 */
    private String inspectionPointName;

	/**
	 *  地区号
	 */
    private String areaId;

	/**
	 *  视察点详细地址
	 */
    private String detailedAddress;

	/**
	 *  视察点的相关图片（[,,]）
	 */
    private String attachImg;

	/**
	 *  视察点简介
	 */
    private String briefIntroduction;

	/**
	 *  区位图经度
	 */
	private String site_img_y;

	/**
	 *  区位图地址纬度
	 */
	private String site_img_x;

	/**
	 *  视察点全景图地址
	 */
    private String vrImg;

	/**
	 * 创建时间
	 */
    private String dateCreated;

	/**
	 *  最后修改的时间
	 *
	 */
    private String lastUpdated;

	/**
	 *  逻辑删除 'YES' 'NO'
	 */
	private BooleanEnum logicDelete;

}