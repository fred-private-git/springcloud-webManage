package com.zkml.official_reception.server.controller;

import com.zkml.common.obj.dto.PageDTO;
import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.common.obj.util.ResultModelUtil;
import com.zkml.official_reception.client.bo.HotelBO;
import com.zkml.official_reception.client.client.HotelClient;
import com.zkml.official_reception.client.query.ReceptionQuery;
import com.zkml.official_reception.server.exception.OfficialException;
import com.zkml.official_reception.server.service.HotelService;
import com.zkml.official_reception.server.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fanghui on 2019/5/6.
 */
@RestController
public class HotelController implements HotelClient {

    @Autowired
    HotelService hotelService;

    @Autowired
    PointService pointService;

    @Override
    public ResultModelDTO hotelCountByAreaId(String areaId) {
        try {
          int hotelCount = hotelService.hotelCountByAreaId(areaId);
            return ResultModelUtil.successResult(hotelCount);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO findTotalByAreaId(String areaId) {
        try {
            List<Map> hotelCount = hotelService.findTotalByAreaId(areaId);
            return ResultModelUtil.successResult(hotelCount);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

//    @Override
//    public List findTotalGroupByAreaId(String pId) {
//            List<Map> resultList = new ArrayList();
//            List<Map> hotelList = hotelService.findTotalByAreaId(pId);
//            List<Map> pointList = pointService.findTotalByAreaId(pId);
//
//            for (int i=0;i<hotelList.size();i++){
//                for(int j=0;j<hotelList.size();j++){
//                    if(hotelList.get(i).get("areaName").equals(resultList.get(j).get("areaName"))){
//
//                    }
//                    List<Map> total = new ArrayList<>();
//                    Map resultMap = new HashMap();
//                    Map map = new HashMap();
//                    map.put("name","协议酒店");
//                    map.put("value",hotelList.get(i).get("total"));
//                    total.add(map);
//                    resultMap.put("name",hotelList.get(i).get("areaName"));
//                    resultMap.put("data",total);
//                    resultList.add(resultMap);
//                }
//
//            }
//            for(int i=0;i<pointList.size();i++){
//                List<Map> total = new ArrayList<>();
//                Map resultMap = new HashMap();
//                Map map = new HashMap();
//                map.put("name","考察接待点");
//                map.put("value",pointList.get(i).get("total"));
//                total.add(map);
//                resultMap.put("name",pointList.get(i).get("areaName"));
//                resultMap.put("data",total);
//                resultList.add(resultMap);
//            }
//            return resultList;
//    }

    @Override
    public ResultModelDTO findByAreaId(String areaId) {
        try {
            int hotelCount = hotelService.findByAreaId(areaId);
            return ResultModelUtil.successResult(hotelCount);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO findWithPage(ReceptionQuery receptionQuery) {
        try {
            PageDTO pageDTO = new PageDTO(receptionQuery.getMax(),receptionQuery.getOffset());
            PageDTO hotelPageDTO = hotelService.findWithPage(receptionQuery,pageDTO);
            return ResultModelUtil.successResult(hotelPageDTO);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO findByHotelInfoId(String hotelInfoId) {
        try {
            Map hotelMap = hotelService.findByHotelInfoId(hotelInfoId);
            return ResultModelUtil.successResult(hotelMap);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO<List<HotelBO>> findWithOutPage(String areaId) {
        try {
            List<HotelBO> hotelBOList = hotelService.findWithOutPage(areaId);
            return ResultModelUtil.successResult(hotelBOList);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }
}
