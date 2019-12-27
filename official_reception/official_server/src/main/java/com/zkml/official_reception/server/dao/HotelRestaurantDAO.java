package com.zkml.official_reception.server.dao;

import com.zkml.official_reception.server.po.RestaurantPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @author zhouyang
 * @date 2019-05-17 14:01:30
 */
public interface HotelRestaurantDAO {
    /**
    * 新增一个记录
    *
    * @param restaurantPO 记录信息，没填的信息为空
    * @return 影响的行数 正常为1
    */
    int create(RestaurantPO restaurantPO);

    /**
    * 根据id更新一条记录
    *
    * @param restaurantPO 记录信息，没填的信息不更新
    * @return 影响的行数 正常为1
    */

    int update(RestaurantPO restaurantPO);
    /**
    * 根据id更新一条记录
    *
    * @param restaurantPO 记录信息, 为空的更新为NULL
    * @return 影响的行数 正常为1
    */
    int update4Null(RestaurantPO restaurantPO);

    /**
    * 删除一条记录
    *
    * @param hotelRestaurantInfoId
    * @return 影响的行数 正常为1
    */
    int delete(@Param("hotelRestaurantInfoId") String hotelRestaurantInfoId);

    /**
    * 根据hotelRestaurantInfoId查找
    *
    * @param hotelRestaurantInfoId
    * @return RestaurantPO
    */
    RestaurantPO findByHotelRestaurantInfoId(@Param("hotelRestaurantInfoId") String hotelRestaurantInfoId);

    /**
     * 根据hotelInfoId查找
     * @param hotelInfoId
     * @return
     */
    List<RestaurantPO> findByHotelInfoId(@Param("hotelInfoId") String hotelInfoId);
}
