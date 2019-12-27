package com.zkml.official_reception.server.service.impl;

import com.zkml.common.obj.dto.PageDTO;
import com.zkml.common.obj.enums.DefaultResultCodeEnum;
import com.zkml.official_reception.client.bo.AreaBO;
import com.zkml.official_reception.client.bo.HotelBO;
import com.zkml.official_reception.client.query.ReceptionQuery;
import com.zkml.official_reception.server.dao.HotelDAO;
import com.zkml.official_reception.server.dao.HotelRestaurantDAO;
import com.zkml.official_reception.server.dao.HotelRoomDAO;
import com.zkml.official_reception.server.dao.SysAreaDAO;
import com.zkml.official_reception.server.exception.OfficialException;
import com.zkml.official_reception.server.po.HotelPO;
import com.zkml.official_reception.server.service.HotelService;
import com.zkml.official_reception.server.util.BaseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fanghui on 2019/5/6.
 */
@Slf4j
@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    HotelDAO hotelDAO;

    @Autowired
    SysAreaDAO sysAreaDAO;

    @Autowired
    HotelRestaurantDAO hotelRestaurantDAO;

    @Autowired
    HotelRoomDAO hotelRoomDAO;

    @Override
    public int hotelCountByAreaId(String areaId) {
        try {
            int findAreaById = hotelDAO.hotelCountByAreaId(areaId);
            return findAreaById;
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    public List findTotalByAreaId(String areaId) {
        try {
            List<Map> findAreaById = hotelDAO.findTotalByAreaId(areaId);
            return findAreaById;
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    public int findByAreaId(String areaId) {
        try {
            int findAreaById = hotelDAO.findByAreaId(areaId);
            return findAreaById;
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    public PageDTO<HotelBO> findWithPage(ReceptionQuery receptionQuery, PageDTO pageDTO) {
        try {
            List<HotelPO> findWithPage = hotelDAO.findWithPage(receptionQuery,pageDTO.getOffset(),pageDTO.getMax());
            List<HotelBO> hotelBOList= BaseUtil.mapList(findWithPage,HotelBO.class);
            List<Map> hotelList = new ArrayList();
            for(int i=0;i<hotelBOList.size();i++){
                Map map = new HashMap();
                map.put("id",hotelBOList.get(i).getHotelInfoId());
                map.put("name",hotelBOList.get(i).getHotelName());
                map.put("areaId",hotelBOList.get(i).getAreaId());
                map.put("detailedAddress",hotelBOList.get(i).getDetailedAddress());
                map.put("attachImg",hotelBOList.get(i).getAttachImg());
                map.put("briefIntroduction",hotelBOList.get(i).getBriefIntroduction());
                map.put("site_img_y",hotelBOList.get(i).getSite_img_y());
                map.put("site_img_x",hotelBOList.get(i).getSite_img_x());
                map.put("vrImg",hotelBOList.get(i).getVrImg());
                hotelList.add(map);
            }
            int hotelCount = hotelDAO.findCountWithPage(receptionQuery);
            pageDTO.setPage(hotelList,hotelCount);
                return pageDTO;
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    public Map findByHotelInfoId(String hotelInfoId) {
        try {
            HotelPO findHotelById = hotelDAO.findByHotelInfoId(hotelInfoId);
            Map hotelMap = new HashMap();
            hotelMap.put("id",findHotelById.getHotelInfoId());
            hotelMap.put("name",findHotelById.getHotelName());
            hotelMap.put("areaName",sysAreaDAO.findAreaNameById(findHotelById.getAreaId()).getAreaName());
            hotelMap.put("detailedAddress",findHotelById.getDetailedAddress());
            hotelMap.put("attachImg",findHotelById.getAttachImg());
            hotelMap.put("briefIntroduction",findHotelById.getBriefIntroduction());
            hotelMap.put("site_img_y",findHotelById.getSite_img_y());
            hotelMap.put("site_img_x",findHotelById.getSite_img_x());
            hotelMap.put("vrImg",findHotelById.getVrImg());
            hotelMap.put("hotelRestaurantDetail",hotelRestaurantDAO.findByHotelInfoId(findHotelById.getHotelInfoId()));
            hotelMap.put("hotelRoomDetail",hotelRoomDAO.findByHotelInfoId(findHotelById.getHotelInfoId()));
            return hotelMap;
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    public List<HotelBO> findWithOutPage(String areaId) {
        try {
            List<HotelPO> findAreaById = hotelDAO.findWithOutPage(areaId);
            return BaseUtil.mapList(findAreaById,HotelBO.class);
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }
}
