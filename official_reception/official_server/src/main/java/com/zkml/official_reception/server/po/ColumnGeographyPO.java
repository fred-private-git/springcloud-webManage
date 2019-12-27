package com.zkml.official_reception.server.po;

import com.zkml.common.obj.enums.BooleanEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class ColumnGeographyPO  implements Serializable {

	private static final long serialVersionUID = -1L;
	
	/**
	 *  id
	 */
    private String geographyId;

	/**
	 *  地域名称
	 */
    private String geographyName;

	/**
	 *  所属栏目id
	 */
    private String belongColumnId;

	/**
	 *  行政级别
	 */
    private String geographyLevel;


	/**
	 *  地域详情
	 */
    private String geographyDetail;

	/**
	 *  轮播图片
	 */
    private String geographyImg;

	/**
	 * 创建时间
	 */
	private Date dateCreated;

	/**
	 * 最后修改时间
	 */
    private Date lastUpdated;

	/**
	 * 逻辑删除
	 */
	private BooleanEnum logicDelete;
	
}