package com.zkml.official_reception.server.dao;

import com.zkml.official_reception.server.po.AreaPO;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Created by fanghui on 2019/5/6.
 */
public interface SysAreaDAO {
    /**
     * 通过地区号查询省会下的所有地级市
     * @param areaId
     * @return
     */
    List<AreaPO> findAreaById(@Param("areaId") String areaId);

    /**
     * 根据地区号找到所在地区的名称
     * @param areaId
     * @return
     */
    AreaPO findAreaNameById(@Param("areaId") String areaId);

    List<AreaPO> findAllAreaById();

}
