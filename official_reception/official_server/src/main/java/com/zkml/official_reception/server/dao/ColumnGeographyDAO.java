package com.zkml.official_reception.server.dao;

import com.zkml.official_reception.client.query.ReceptionQuery;
import com.zkml.official_reception.server.po.ColumnGeographyPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @author zhouyang
 * @date 2019-06-14 16:01:50
 */
public interface ColumnGeographyDAO  {
    /**
    * 新增一个记录
    *
    * @param columnGeographyPO 记录信息，没填的信息为空
    * @return 影响的行数 正常为1
    */
    int createGeography(ColumnGeographyPO columnGeographyPO);

    /**
    * 根据id更新一条记录
    *
    * @param columnGeographyPO 记录信息，没填的信息不更新
    * @return 影响的行数 正常为1
    */

    int updateGeographyById(ColumnGeographyPO columnGeographyPO);
    /**
    * 根据id更新一条记录
    *
    * @param columnGeographyPO 记录信息, 为空的更新为NULL
    * @return 影响的行数 正常为1
    */
    int update4Null(ColumnGeographyPO columnGeographyPO);

    /**
    * 删除一条记录
    *
    * @param geographyId
    * @return 影响的行数 正常为1
    */
    int deleteGeographyById(@Param("geographyId") String geographyId);

    /**
    * 根据geographyId查找
    *
    * @param geographyId
    * @return ColumnGeographyPO
    */
    ColumnGeographyPO findByColumnGeographyId(@Param("geographyId") String geographyId);


    /**
     * 自然地理分页列表
     * @param receptionQuery
     * @param offset
     * @param max
     * @return
     */
    List<ColumnGeographyPO> findWithPage(@Param("receptionQuery") ReceptionQuery receptionQuery, @Param("offset") long offset, @Param("max") long max);

    /**
     * 查询记录总数
     * @param receptionQuery
     * @return
     */
    Long findCountWithPage(@Param("receptionQuery") ReceptionQuery receptionQuery);
}
