package com.zkml.official_reception.server.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.zkml.common.obj.dto.PageDTO;
import com.zkml.common.obj.dto.ResultCode;
import com.zkml.common.obj.enums.BooleanEnum;
import com.zkml.common.obj.enums.DefaultResultCodeEnum;
import com.zkml.common.util.MyUtil;
import com.zkml.official_reception.client.bo.*;
import com.zkml.official_reception.client.query.ReceptionQuery;
import com.zkml.official_reception.server.dao.*;
import com.zkml.official_reception.server.exception.OfficialException;
import com.zkml.official_reception.server.po.*;
import com.zkml.official_reception.server.service.TripPlanService;
import com.zkml.official_reception.server.util.BaseUtil;
import com.zkml.official_reception.server.util.TreeUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fanghui on 2019/5/21.
 */
@Service
public class TripPlanServiceImpl implements TripPlanService{


    @Autowired
    ReceptionLetterDAO receptionLetterDAO;

    @Autowired
    HotelDAO hotelDAO;

    @Autowired
    PointDAO pointDAO;

    @Autowired
    TripPlanDAO tripPlanDAO;

    @Autowired
    SysAreaDAO sysAreaDAO;

    @Override
    @Transactional
    public ResultCode createTrip(ReceptionLetterPO receptionLetterPO, TripVoPO tripVoPO) {
        try {
            receptionLetterDAO.create(receptionLetterPO);
            List<TripPlanPO> tripPlanPOList = JSONArray.parseArray(tripVoPO.getTripPlanDTOList(), TripPlanPO.class);
            for (TripPlanPO tripPlanPO:tripPlanPOList) {
                tripPlanDAO.create(tripPlanPO);
            }
            return  DefaultResultCodeEnum.ADD_SUCCESS;

        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.ADD_ERROR);
        }

    }

    @Override
    public ResultCode updateTrip( ReceptionLetterPO receptionLetterPO, TripVoPO tripVoPO) {
        try {
            receptionLetterDAO.update(receptionLetterPO);
            List<TripPlanPO> tripPlanPOList = JSONArray.parseArray(tripVoPO.getTripPlanDTOList(), TripPlanPO.class);
            for (TripPlanPO tripPlanPO : tripPlanPOList) {
                tripPlanDAO.update(tripPlanPO);
            }
            return DefaultResultCodeEnum.UPDATE_SUCCESS;
        } catch (Exception e) {
            throw new OfficialException(DefaultResultCodeEnum.UPDATE_ERROR);
        }
    }

    @Override
    public List<AreaTreePO> areaTree() {
        List<AreaPO> areaPOList = sysAreaDAO.findAreaById("0100");
        List<AreaTreePO> mapList = new ArrayList<>();
        for(int i=0;i<areaPOList.size();i++){
            AreaTreePO areaTreePO = new AreaTreePO();
            List<AreaTreePO> areaTreePOList = new ArrayList<>();
            areaTreePO.setAreaId(areaPOList.get(i).getAreaId());
            areaTreePO.setAreaName(areaPOList.get(i).getAreaName());
            List<AreaPO> areaPOS = sysAreaDAO.findAreaById(areaPOList.get(i).getAreaId());
            for(int j= 0;j<areaPOS.size();j++){
                AreaTreePO areaTree = new AreaTreePO();
                areaTree.setAreaId(areaPOS.get(j).getAreaId());
                areaTree.setAreaName(areaPOS.get(j).getAreaName());
                if(MyUtil.isNotBlank(sysAreaDAO.findAreaById(areaPOS.get(j).getAreaId()))){
                    areaTree.setChildren(sysAreaDAO.findAreaById(areaPOS.get(j).getAreaId()));
                }else {
                    areaTree.setChildren(null);
                }
                areaTreePOList.add(areaTree);
            }
            areaTreePO.setChildren(areaTreePOList);
            mapList.add(areaTreePO);
        }
        return mapList;
    }

    @Override
    public  List<Object> menuTree() {
        List<AreaPO> areaPOList = sysAreaDAO.findAllAreaById();
        List<TreePO> treePOList = new ArrayList<>();
        for(int i=0;i<areaPOList.size();i++){
            TreePO treePO = new TreePO();
            treePO.setId(areaPOList.get(i).getAreaId());
            treePO.setName(areaPOList.get(i).getAreaName());
            treePO.setPId(areaPOList.get(i).getParentId());
            treePOList.add(treePO);
        }
        TreeUtil menuTree = new TreeUtil();
        List<Object> menuList = menuTree.list(treePOList);
        return menuList;
    }

}
