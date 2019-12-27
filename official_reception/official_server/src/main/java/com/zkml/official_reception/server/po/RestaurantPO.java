package com.zkml.official_reception.server.po;

import com.zkml.common.obj.enums.BooleanEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author fanghui
 * @date 2019-05-17 14:01:30
 */
@Data
public class RestaurantPO  implements Serializable {

	private static final long serialVersionUID = -1L;

    private String hotelRestaurantInfoId;

    private String hotelInfoId;

    private String hotelRestaurantName;

    private String hotelRestaurantPeople;

    private String hotelRoomDescribe;

    private String hotelRestaurantEquip;

    private String hotelRestaurantArea;

    private String attachImg;

    private Date dateCreated;

    private String lastUpdated;

	private BooleanEnum logicDelete;

}