package com.zkml.official_reception.server.controller;

import com.zkml.common.obj.dto.PageDTO;
import com.zkml.common.obj.dto.ResultCode;
import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.common.obj.util.ResultModelUtil;
import com.zkml.official_reception.client.bo.ReceptionLetterBO;
import com.zkml.official_reception.client.bo.TripPreviewBO;
import com.zkml.official_reception.client.bo.TripVoBO;
import com.zkml.official_reception.client.client.TripPlanClient;
import com.zkml.official_reception.server.exception.OfficialException;
import com.zkml.official_reception.server.po.AreaTreePO;
import com.zkml.official_reception.server.po.ReceptionLetterPO;
import com.zkml.official_reception.server.po.TripVoPO;
import com.zkml.official_reception.server.service.TripPlanService;
import com.zkml.official_reception.server.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by fanghui on 2019/5/21.
 */
@RestController
public class TripPlanController implements TripPlanClient{

    @Autowired
    TripPlanService tripPlanService;

    @Override
    public ResultModelDTO createTrip(TripPreviewBO tripPreviewBO) {
        try {
            ReceptionLetterBO receptionLetterBO = tripPreviewBO.getReceptionLetterBO();
            TripVoBO tripVoBO = tripPreviewBO.getTripVoBO();
            ReceptionLetterPO receptionLetterPO = BaseUtil.map(receptionLetterBO, ReceptionLetterPO.class);
            TripVoPO tripVoPO = BaseUtil.map(tripVoBO, TripVoPO.class);
            ResultCode resultCode = tripPlanService.createTrip(receptionLetterPO,tripVoPO);
            return ResultModelUtil.successResult(resultCode);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO updateTrip(TripPreviewBO tripPreviewBO) {
        try {
            ReceptionLetterBO receptionLetterBO = tripPreviewBO.getReceptionLetterBO();
            TripVoBO tripVoBO = tripPreviewBO.getTripVoBO();
            ReceptionLetterPO receptionLetterPO = BaseUtil.map(receptionLetterBO, ReceptionLetterPO.class);
            TripVoPO tripVoPO = BaseUtil.map(tripVoBO, TripVoPO.class);
            ResultCode resultCode = tripPlanService.updateTrip(receptionLetterPO,tripVoPO);
            return ResultModelUtil.successResult(resultCode);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }



    @Override
    public ResultModelDTO areaTree() {
        try {
            List<AreaTreePO> areaTreePOList = tripPlanService.areaTree();
            return ResultModelUtil.successResult(areaTreePOList);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public List<Object> menuTree() {
        List<Object> areaTreePOList = tripPlanService.menuTree();
        return areaTreePOList;
    }
}
