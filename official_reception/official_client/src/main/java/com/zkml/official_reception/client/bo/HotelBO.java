package com.zkml.official_reception.client.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by fanghui on 2019/4/30.
 */

@Data
public class HotelBO implements Serializable{

    private static final long serialVersionUID = -1L;

    /**
     *  酒店id
     */
    private String hotelInfoId;

    /**
     *  酒店名称
     */
    private String hotelName;

    /**
     *  酒店所在的地区区号
     */
    private String areaId;

    /**
     *  酒店详细地址
     */
    private String detailedAddress;

    /**
     *  酒店相关图片
     */
    private String attachImg;

    /**
     *  酒店简介
     */
    private String briefIntroduction;

    /**
     *  区位图经度
     */
    private String site_img_y;

    /**
     *  区位图地址纬度
     */
    private String site_img_x;

    /**
     *  酒店VR图url
     */
    private String vrImg;

}
