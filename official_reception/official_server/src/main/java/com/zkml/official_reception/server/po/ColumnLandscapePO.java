package com.zkml.official_reception.server.po;

import com.zkml.common.obj.enums.BooleanEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fanghui on 2019/6/14.
 */
@Data
public class ColumnLandscapePO implements Serializable {
    /**
     *  主键id
     */
    private String columnLandscapeId;

    /**
     *  名称
     */
    private String columnLandscapeName;

    /**
     *  所属的栏目
     */
    private String belongColumnId;

    /**
     *  地区
     */
    private String areaId;

    /**
     *  详细地址
     */
    private String detailedAddress;

    /**
     *  山水风光简介
     */
    private String briefIntroduction;

    /**
     *  百度百科链接地址
     */
    private String url;

    /**
     *  区位图的经度
     */
    private String siteImgY;

    /**
     *  区位图的纬度
     */
    private String siteImgX;

    /**
     *  相关图片
     */
    private String attachImg;

    private Date dateCreated;

    private Date lastUpdated;

    private BooleanEnum logicDelete;
}
