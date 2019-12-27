package com.zkml.official_reception.server.po;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by fanghui on 2019/6/14.
 */
@Data
public class TitlePO  implements Serializable {
    private static final long serialVersionUID = -1L;

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
     *  插图
     */
    private String uploadImage;

    /**
     *  轮播图片
     */
    private String attachImg;

    /**
     *  所在地区id
     */
    private String areaId;
}
