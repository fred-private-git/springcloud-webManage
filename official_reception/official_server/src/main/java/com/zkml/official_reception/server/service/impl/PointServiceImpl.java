package com.zkml.official_reception.server.service.impl;

import com.zkml.common.obj.dto.PageDTO;
import com.zkml.common.obj.enums.DefaultResultCodeEnum;
import com.zkml.official_reception.client.bo.HotelBO;
import com.zkml.official_reception.client.bo.PointBO;
import com.zkml.official_reception.client.query.ReceptionQuery;
import com.zkml.official_reception.server.dao.PointDAO;
import com.zkml.official_reception.server.dao.SysAreaDAO;
import com.zkml.official_reception.server.exception.OfficialException;
import com.zkml.official_reception.server.po.PointPO;
import com.zkml.official_reception.server.service.PointService;
import com.zkml.official_reception.server.util.BaseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fanghui on 2019/5/14.
 */
@Slf4j
@Service
public class PointServiceImpl implements PointService{

    @Autowired
    PointDAO pointDAO;

    @Autowired
    SysAreaDAO sysAreaDAO;

    @Override
    public int pointCountByAreaId(String areaId) {
        try {
            int findPointById = pointDAO.pointCountByAreaId(areaId);
            return findPointById;
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    public List<Map> findTotalByAreaId(String areaId) {
        try {
            List<Map> pointDAOTotalByAreaId = pointDAO.findTotalByAreaId(areaId);
            return pointDAOTotalByAreaId;
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    public int findByAreaId(String areaId) {
        try {
            int findAreaById = pointDAO.findByAreaId(areaId);
            return findAreaById;
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    public PageDTO findWithPage(ReceptionQuery receptionQuery, PageDTO pageDTO) {
        try {
            List<PointPO> findWithPage = pointDAO.findWithPage(receptionQuery,pageDTO.getOffset(),pageDTO.getMax());
            List<PointBO> pointBOList= BaseUtil.mapList(findWithPage,PointBO.class);
            List<Map> pointList = new ArrayList();
            for(int i=0;i<pointBOList.size();i++){
                Map map = new HashMap();
                map.put("id",pointBOList.get(i).getInspectionPointInfoId());
                map.put("name",pointBOList.get(i).getInspectionPointName());
                map.put("areaId",pointBOList.get(i).getAreaId());
                map.put("detailedAddress",pointBOList.get(i).getDetailedAddress());
                map.put("attachImg",pointBOList.get(i).getAttachImg());
                map.put("briefIntroduction",pointBOList.get(i).getBriefIntroduction());
                map.put("site_img_y",pointBOList.get(i).getSite_img_y());
                map.put("site_img_x",pointBOList.get(i).getSite_img_x());
                map.put("vrImg",pointBOList.get(i).getVrImg());
                map.put("dateCreated",pointBOList.get(i).getDateCreated());
                pointList.add(map);
            }
            int hotelCount = pointDAO.findCountWithPage(receptionQuery);
            pageDTO.setPage(pointList,hotelCount);
            return pageDTO;
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    public Map findByInspectionPointInfoId(String inspectionPointInfoId) {
        try {
            PointPO findAreaById = pointDAO.findByInspectionPointInfoId(inspectionPointInfoId);
            Map pointMap = new HashMap();
            pointMap.put("id",findAreaById.getInspectionPointInfoId());
            pointMap.put("name",findAreaById.getInspectionPointName());
            pointMap.put("areaName",sysAreaDAO.findAreaNameById(findAreaById.getAreaId()).getAreaName());
            pointMap.put("detailedAddress",findAreaById.getDetailedAddress());
            pointMap.put("attachImg",findAreaById.getAttachImg());
            pointMap.put("briefIntroduction",findAreaById.getBriefIntroduction());
            pointMap.put("site_img_y",findAreaById.getSite_img_y());
            pointMap.put("site_img_x",findAreaById.getSite_img_x());
            pointMap.put("vrImg",findAreaById.getVrImg());
            pointMap.put("dateCreated",findAreaById.getDateCreated());
            return pointMap;
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    public List<PointBO> findWithOutPage(String areaId) {
        try {
            List<PointPO> findAreaById = pointDAO.findWithOutPage(areaId);
            return BaseUtil.mapList(findAreaById,PointBO.class);
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }
}
