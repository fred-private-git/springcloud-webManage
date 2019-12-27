package com.zkml.official_reception.server.dao;

import com.zkml.official_reception.client.query.ReceptionQuery;
import com.zkml.official_reception.server.po.ColumnFoodPO;
import com.zkml.official_reception.server.po.ColumnGeographyPO;
import com.zkml.official_reception.server.po.ColumnLandscapePO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ColumnFoodDAO  {
    /**
    * 新增一个记录
    *
    * @param columnFoodPO 记录信息，没填的信息为空
    * @return 影响的行数 正常为1
    */
    int createFood(ColumnFoodPO columnFoodPO);

    /**
    * 根据id更新一条记录
    *
    * @param columnFoodPO 记录信息，没填的信息不更新
    * @return 影响的行数 正常为1
    */

    int updateFoodById(ColumnFoodPO columnFoodPO);
    /**
    * 根据id更新一条记录
    *
    * @param columnFoodPO 记录信息, 为空的更新为NULL
    * @return 影响的行数 正常为1
    */
    int update4Null(ColumnFoodPO columnFoodPO);

    /**
    * 删除一条记录
    *
    * @param columnFoodId
    * @return 影响的行数 正常为1
    */
    int deleteFoodById(@Param("columnFoodId") String columnFoodId);

    /**
    * 根据columnFoodId查找
    *
    * @param columnFoodId
    * @return ColumnFoodPO
    */
    ColumnFoodPO findByColumnFoodId(@Param("columnFoodId") String columnFoodId);


    /**
     * 美食风味分页列表
     * @param receptionQuery
     * @param offset
     * @param max
     * @return
     */
    List<ColumnFoodPO> findWithPage(@Param("receptionQuery") ReceptionQuery receptionQuery, @Param("offset") long offset, @Param("max") long max);
    /**
     * 美食风味记录总数
     * @param receptionQuery
     * @return
     */
    Long findCountWithPage(@Param("receptionQuery") ReceptionQuery receptionQuery);


}
