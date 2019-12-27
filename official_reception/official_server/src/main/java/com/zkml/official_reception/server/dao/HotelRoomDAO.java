package com.zkml.official_reception.server.dao;

import com.zkml.official_reception.server.po.HotelRoomPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @author zhouyang
 * @date 2019-05-17 13:59:40
 */
public interface HotelRoomDAO {
    /**
    * 新增一个记录
    *
    * @param roomPO 记录信息，没填的信息为空
    * @return 影响的行数 正常为1
    */
    int create(HotelRoomPO roomPO);

    /**
    * 根据id更新一条记录
    *
    * @param roomPO 记录信息，没填的信息不更新
    * @return 影响的行数 正常为1
    */

    int update(HotelRoomPO roomPO);
    /**
    * 根据id更新一条记录
    *
    * @param roomPO 记录信息, 为空的更新为NULL
    * @return 影响的行数 正常为1
    */
    int update4Null(HotelRoomPO roomPO);

    /**
    * 删除一条记录
    *
    * @param hotelRoomInfoId
    * @return 影响的行数 正常为1
    */
    int delete(@Param("hotelRoomInfoId") String hotelRoomInfoId);

    /**
    * 根据hotelRoomInfoId查找
    *
    * @param hotelRoomInfoId
    * @return RoomPO
    */
    HotelRoomPO findByHotelRoomInfoId(@Param("hotelRoomInfoId") String hotelRoomInfoId);

    /**
     * 根据hotelInfoId查找
     * @param hotelInfoId
     * @return
     */
    List<HotelRoomPO> findByHotelInfoId(@Param("hotelInfoId") String hotelInfoId);
}
