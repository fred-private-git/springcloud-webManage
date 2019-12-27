package com.zkml.official_reception.client.bo;

import com.zkml.common.obj.enums.BooleanEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by fanghui on 2019/6/14.
 */
@Data
public class ColumnFoodBO implements Serializable {

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
    private List<String> attachImg;

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
