package com.zkml.official_reception.server.dao;

import com.zkml.official_reception.server.po.TripPlanPO;
import org.apache.ibatis.annotations.Param;

public interface TripPlanDAO {

    /**
     * 新增一个记录
     *
     * @param tripPlanPO 记录信息，没填的信息为空
     * @return 影响的行数 正常为1
     */
    int create(TripPlanPO tripPlanPO);


    /**
     * 根据id更新一条记录
     * @return 影响的行数 正常为1
     */
    int update(@Param("tripPlanPO") TripPlanPO tripPlanPO);

}
