package com.zkml.official_reception.client.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fanghui on 2019/6/14.
 */
@Data
public class TitleBO implements Serializable {
    /**
     *  主键id
     */
    private String titleId;

    /**
     *  主题名称
     */
    private String titleName;

    /**
     *  主题介绍
     */
    private String titleIntroduction;

    /**
     * 插图
     */
    private  String uploadImage;

    /**
     *  轮播图片
     */
    private List<String> attachImg;

    /**
     *  所在地区id
     */
    private String areaId;

    /**
     * 主题下的所有栏目
     */
    private List<ColumnBOVO> columnBOList;
}
