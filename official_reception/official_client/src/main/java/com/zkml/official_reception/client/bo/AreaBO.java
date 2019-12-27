package com.zkml.official_reception.client.bo;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author zhouyang
 * @date 2019-05-06 11:06:21
 */

@Data
public class AreaBO implements Serializable {

    /**
     * 地区主键id
     */
    private String areaId;

    /**
     * 地区名称
     */
    private String areaName;

    /**
     * 地区行政级别
     */
    private int level;

    /**
     * 所属上级地区id
     */
    private String parentId;

    /**
     * 排序
     */
    private Integer sortNo;

}