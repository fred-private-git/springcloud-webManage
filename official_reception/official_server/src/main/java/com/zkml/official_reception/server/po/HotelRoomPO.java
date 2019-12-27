package com.zkml.official_reception.server.po;

import com.zkml.common.obj.enums.BooleanEnum;
import lombok.Data;

import java.util.Date;

/**
 * Created by fanghui on 2019/5/17.
 */
@Data
public class HotelRoomPO {

    private static final long serialVersionUID = -1L;

    private String hotelRoomInfoId;

    private String hotelInfoId;

    private String hotelRoomDescribe;

    private String hotelRoomType;

    private String hotelRoomPrice;

    private String hotelRoomEquip;

    private Integer hotelRoomCount;

    private String hotelRoomTypeDescribe;

    private String attachImg;

    private Date dateCreated;

    private String lastUpdated;

    private BooleanEnum logicDelete;

}
