package com.zkml.official_reception.server.po;

import com.zkml.common.obj.enums.BooleanEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author fanghui
 * @date 2019-06-14 16:10:12
 */
@Data
public class ColumnFoodPO  implements Serializable {

	private static final long serialVersionUID = -1L;
	
	/**
	 *  id
	 */
    private String columnFoodId;

	/**
	 *  美食名称
	 */
    private String columnFoodName;

	/**
	 *  所属栏目id
	 */
    private String belongColumnId;

	/**
	 *  制作原料
	 */
    private String rawMateria;

	/**
	 *  美食简介
	 */
    private String briefIntroduction;

	/**
	 *  制作方法
	 */
    private String foodMake;

	/**
	 *  推荐餐厅
	 */
    private String foodRestaurant;

	/**
	 *  相关图片
	 */
    private String attachImg;

    private Date dateCreated;

    private Date lastUpdated;

	private BooleanEnum logicDelete;
	
}