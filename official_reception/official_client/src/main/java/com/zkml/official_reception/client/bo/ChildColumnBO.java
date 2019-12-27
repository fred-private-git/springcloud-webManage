package com.zkml.official_reception.client.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by admin on 2019/7/8.
 */
@Data
public class ChildColumnBO implements Serializable{
    private static final long serialVersionUID = -1L;

    /**
     *  子栏目id
     */
    private String childColumnId;

    /**
     *  子栏目名称
     */
    private String childColumnName;

    /**
     *  所属栏目id
     */
    private String belongColumnId;

    /***
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
