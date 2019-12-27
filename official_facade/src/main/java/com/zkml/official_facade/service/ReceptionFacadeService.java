package com.zkml.official_facade.service;

import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.official_facade.dto.TripPreviewDTO;
import com.zkml.official_reception.client.query.ReceptionQuery;

/**
 * Created by fanghui on 2019/5/14.
 */
public interface ReceptionFacadeService {

    /**
     * 每个省下各个地级市的接待点统计
     * @param areaId
     * @return
     */
    ResultModelDTO findTotalByAreaId(String areaId);

//    List<Map> findTotalGroupByAreaId(String areaId);


    /**
     * 根据inspectionPointInfoId查找
     *
     * @param inspectionPointInfoId
     * @return PointPO
     */
    ResultModelDTO findByInspectionPointInfoId(String inspectionPointInfoId);
    /**
     * 新增行程安排
     * @param tripPreviewDTO
     * @return
     */
    ResultModelDTO createTrip(TripPreviewDTO tripPreviewDTO);


    /**
     * 省级联动
     * @return
     */
    ResultModelDTO areaTree();
}
