package com.zkml.official_reception.server.dao;

import com.zkml.official_reception.client.query.ReceptionQuery;
import com.zkml.official_reception.server.po.PointPO;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fanghui
 * @date 2019-05-14 09:04:54
 */
public interface PointDAO  {
    /**
    * 新增一个记录
    *
    * @param pointPO 记录信息，没填的信息为空
    * @return 影响的行数 正常为1
    */
    int create(PointPO pointPO);

    /**
    * 根据id更新一条记录
    *
    * @param pointPO 记录信息，没填的信息不更新
    * @return 影响的行数 正常为1
    */

    int update(PointPO pointPO);
    /**
    * 根据id更新一条记录
    *
    * @param pointPO 记录信息, 为空的更新为NULL
    * @return 影响的行数 正常为1
    */
    int update4Null(PointPO pointPO);

    /**
    * 删除一条记录
    *
    * @param inspectionPointInfoId
    * @return 影响的行数 正常为1
    */
    int delete(@Param("inspectionPointInfoId") String inspectionPointInfoId);

    /**
    * 根据inspectionPointInfoId查找
    *
    * @param inspectionPointInfoId
    * @return PointPO
    */
    PointPO findByInspectionPointInfoId(@Param("inspectionPointInfoId") String inspectionPointInfoId);

    /**
     * 全省下的视察点统计
     * @param areaId
     * @return
     */
    int pointCountByAreaId(@Param("areaId") String areaId);

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
     * 视察点列表查询
     * @param receptionQuery
     * @param offset
     * @param max
     * @return
     */
    List<PointPO> findWithPage(@Param("receptionQuery") ReceptionQuery receptionQuery, @Param("offset") long offset, @Param("max") long max);

    /**
     * 根据条件查询视察点分页总数
     * @param receptionQuery
     * @return
     */
    int findCountWithPage(@Param("receptionQuery") ReceptionQuery receptionQuery);
    /**
     * 根据地区查询接待视察点（不分页）
     * @param areaId
     * @return
     */
    List<PointPO> findWithOutPage(@Param("areaId") String areaId);
}
