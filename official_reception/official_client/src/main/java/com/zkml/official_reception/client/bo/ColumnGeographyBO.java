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
public class ColumnGeographyBO implements Serializable {


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
    private List<String> geographyImg;

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
