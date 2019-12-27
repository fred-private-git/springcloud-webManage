package com.zkml.official_reception.server.controller;

import com.zkml.common.obj.dto.PageDTO;
import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.common.obj.util.ResultModelUtil;
import com.zkml.official_reception.client.bo.HotelBO;
import com.zkml.official_reception.client.bo.PointBO;
import com.zkml.official_reception.client.client.PointClient;
import com.zkml.official_reception.client.query.ReceptionQuery;
import com.zkml.official_reception.server.exception.OfficialException;
import com.zkml.official_reception.server.po.PointPO;
import com.zkml.official_reception.server.service.PointService;
import com.zkml.official_reception.server.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by fanghui on 2019/5/14.
 */
@RestController
public class PointController implements PointClient {

    @Autowired
    PointService pointService;

    @Override
    public ResultModelDTO pointCountByAreaId(String areaId) {
        try {
            int pointCountByAreaId = pointService.pointCountByAreaId(areaId);
            return ResultModelUtil.successResult(pointCountByAreaId);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO findTotalByAreaId(String areaId) {
        try {
            List<Map> pointTotal = pointService.findTotalByAreaId(areaId);
            return ResultModelUtil.successResult(pointTotal);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO findByAreaId(String areaId) {
        try {
            int hotelCount = pointService.findByAreaId(areaId);
            return ResultModelUtil.successResult(hotelCount);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO<PageDTO> findWithPage(ReceptionQuery receptionQuery) {
        try {
            PageDTO pageDTO = new PageDTO(receptionQuery.getMax(),receptionQuery.getOffset());
            PageDTO pointBOPageDTO = pointService.findWithPage(receptionQuery,pageDTO);
            return ResultModelUtil.successResult(pointBOPageDTO);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO findByInspectionPointInfoId(String inspectionPointInfoId) {
        try {
            Map pointMap = pointService.findByInspectionPointInfoId(inspectionPointInfoId);
            return ResultModelUtil.successResult(pointMap);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO<List<PointBO>> findWithOutPage(String areaId) {
        try {
            List<PointBO> pointBOList = pointService.findWithOutPage(areaId);
            return ResultModelUtil.successResult(pointBOList);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }
}
