package com.zkml.official_reception.client.bo;

import com.zkml.common.obj.enums.BooleanEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by admin on 2019/7/8.
 */
@Data
public class ChildColumnDetailBO implements Serializable{

    /**
     * 子栏目内容主键id
     */
    private String childColumnDetailId;

    /**
     * 子栏目内容名称
     */
    private String childColumnDetailName;

    /**
     * 所属子栏目id
     */
    private String belongChildColumnId;

    /**
     * 简介
     */
    private String briefIntroduction;

    /**
     * 子栏目内容详情
     */
    private String childColumnDetail;

    /**
     * 图片
     */
    private String attachImg;

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
    private String logicDelete;

}
