package com.zkml.official_facade.service;

import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.official_reception.client.query.ReceptionQuery;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2019/7/18.
 */
public interface ResourceManageFacadeService {
    /**
     * 查询某个省份下(视察点|酒店|会议室)的总数
     * @param areaId
     * @param resourceType
     * @return
     */
    ResultModelDTO findCountByAreaId(String areaId, String resourceType);


    /**
     * 查询某个省份各地级市下的酒店、会议室、视察点数量
     * @param areaId
     * @return
     */
    List<Map> findTotalGroupByAreaId(String areaId);


    /**
     * 分页查询
     * @param receptionQuery
     * @param type
     * @return
     */
    ResultModelDTO findWithPage(ReceptionQuery receptionQuery, String type);
}
