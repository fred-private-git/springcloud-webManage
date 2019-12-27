package com.zkml.official_reception.server.service;

import com.zkml.common.obj.dto.PageDTO;
import com.zkml.official_reception.client.bo.PointBO;
import com.zkml.official_reception.client.query.ReceptionQuery;
import com.zkml.official_reception.server.po.PointPO;

import java.util.List;
import java.util.Map;

/**
 * Created by fanghui on 2019/5/14.
 */
public interface PointService {
    /**
     * 全省下的视察点统计
     * @param areaId
     * @return
     */
    int pointCountByAreaId(String areaId);
    /**
     * 每个省下各个地级市的接待点统计
     * @param areaId
     * @return
     */
    List<Map> findTotalByAreaId(String areaId);
    /**
     * 根据areaId统计这个地级市的酒店数量
     * @param areaId
     * @return
     */
    int findByAreaId(String areaId);
    /**
     * 酒店分页列表查询
     * @param receptionQuery
     * @param pageDTO
     * @return
     */
    PageDTO findWithPage(ReceptionQuery receptionQuery, PageDTO pageDTO);
    /**
     * 根据inspectionPointInfoId查找
     * @param inspectionPointInfoId
     * @return PointPO
     */
    Map findByInspectionPointInfoId(String inspectionPointInfoId);
    /**
     * 根据地区查询接待点（不分页）
     * @param areaId
     * @return
     */
    List<PointBO> findWithOutPage(String areaId);
}
