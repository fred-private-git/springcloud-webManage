package com.zkml.official_reception.server.dao;

import com.zkml.official_reception.client.query.ReceptionQuery;
import com.zkml.official_reception.server.po.HotelPO;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;


/**
 * Created by fanghui on 2019/4/30.
 */

public interface HotelDAO {
    /**
     * 新增一个记录
     *
     * @param PO 记录信息，没填的信息为空
     * @return 影响的行数 正常为1
     */
    int create(HotelPO PO);
    /**
     * 根据id更新一条记录
     *
     * @param PO 记录信息，没填的信息不更新
     * @return 影响的行数 正常为1
     */
    int update(HotelPO PO);
    /**
     * 根据id更新一条记录
     *
     * @param PO 记录信息, 为空的更新为NULL
     * @return 影响的行数 正常为1
     */
    int update4Null(HotelPO PO);
    /**
     * 删除一条记录
     *
     * @param hotelInfoId
     * @return 影响的行数 正常为1
     */
    int delete(@Param("hotelInfoId") String hotelInfoId);
    /**
     * 根据hotelInfoId查找
     *
     * @param hotelInfoId
     * @return HotelPO
     */
    HotelPO findByHotelInfoId(@Param("hotelInfoId") String hotelInfoId);
    /**
     * 全省内的涉及到的酒店总数
     * @param areaId
     * @return
     */
    int hotelCountByAreaId(@Param("areaId") String areaId);
    /**
     * 每个省下各个地级市的接待点统计
     * @param areaId
     * @return
     */
    List<Map> findTotalByAreaId(@Param("areaId") String areaId);
    /**
     * 根据areaId统计这个地级市的酒店数量
     * @param areaId
     * @return
     */
    int findByAreaId(@Param("areaId") String areaId);
    /**
     * 酒店列表查询
     * @param receptionQuery
     * @param offset
     * @param max
     * @return
     */
    List<HotelPO> findWithPage(@Param("receptionQuery") ReceptionQuery receptionQuery, @Param("offset") long offset, @Param("max") long max);
    /**
     * 根据条件查询酒店分页总数
     * @param receptionQuery
     * @return
     */
    int findCountWithPage(@Param("receptionQuery") ReceptionQuery receptionQuery);
    /**
     * 根据地区查询接待点（不分页）
     * @param areaId
     * @return
     */
    List<HotelPO> findWithOutPage(@Param("areaId") String areaId);
}
