package com.zkml.official_facade.service.impl;

import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.common.obj.enums.DefaultResultCodeEnum;
import com.zkml.common.obj.util.ResultModelUtil;
import com.zkml.official_facade.dto.*;
import com.zkml.official_facade.exception.OfficialException;
import com.zkml.official_facade.service.ReceptionFacadeService;
import com.zkml.official_facade.util.BaseUtil;
import com.zkml.official_reception.client.bo.*;
import com.zkml.official_reception.client.client.HotelClient;
import com.zkml.official_reception.client.client.PointClient;
import com.zkml.official_reception.client.client.SysAreaClient;
import com.zkml.official_reception.client.client.TripPlanClient;
import com.zkml.official_reception.client.query.ReceptionQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fanghui on 2019/5/14.
 */
@Service
@Slf4j
public class ReceptionFacadeServiceImpl implements ReceptionFacadeService {

    @Autowired
    PointClient pointClient;

    @Autowired
    HotelClient hotelClient;

    @Autowired
    SysAreaClient sysAreaClient;

    @Autowired
    TripPlanClient tripPlanClient;




    @Override
    public ResultModelDTO findTotalByAreaId(String areaId) {
        try {
            ResultModelDTO pointTotal = pointClient.findTotalByAreaId(areaId);
            return pointTotal;
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }





    @Override
    public ResultModelDTO findByInspectionPointInfoId(String inspectionPointInfoId) {
        try {
            ResultModelDTO pointDetail = pointClient.findByInspectionPointInfoId(inspectionPointInfoId);
            return pointDetail;
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO createTrip(@RequestBody TripPreviewDTO tripPreviewDTO) {
        try {
            ReceptionLetterDTO receptionLetterDTO = tripPreviewDTO.getReceptionLetterDTO();
            TripVoDTO tripVoDTO = tripPreviewDTO.getTripVoDTO();
            ReceptionLetterBO receptionLetterBO = BaseUtil.map(receptionLetterDTO, ReceptionLetterBO.class);
            TripVoBO tripVoBO = BaseUtil.map(tripVoDTO, TripVoBO.class);
            TripPreviewBO tripPreviewBO = new TripPreviewBO();
            tripPreviewBO.setReceptionLetterBO(receptionLetterBO);
            tripPreviewBO.setTripVoBO(tripVoBO);
            ResultModelDTO remoteResult;
            if("ADD".equals(tripPreviewDTO.getType())){
                 remoteResult = tripPlanClient.createTrip(tripPreviewBO);
            }else if ("UPDATE".equals(tripPreviewDTO.getType())){

                remoteResult = tripPlanClient.updateTrip(tripPreviewBO);
            } else{
                return null;
            }
            //如果处理失败，抛出异常
            if (remoteResult != null && !remoteResult.successResult()) {
                return ResultModelUtil.failResult(DefaultResultCodeEnum.ADD_ERROR);
                //获取服务返回的数据，可以进一步做处理
            } else {
                return ResultModelUtil.successResult();
            }
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }




    @Override
    public ResultModelDTO areaTree() {
        try {
            ResultModelDTO resultModelDTO = tripPlanClient.areaTree();
            return resultModelDTO;
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }
}
