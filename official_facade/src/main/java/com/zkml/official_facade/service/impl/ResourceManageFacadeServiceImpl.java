package com.zkml.official_facade.service.impl;

import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.common.obj.util.ResultModelUtil;
import com.zkml.official_facade.dto.AreaDTO;
import com.zkml.official_facade.exception.OfficialException;
import com.zkml.official_facade.service.ResourceManageFacadeService;
import com.zkml.official_facade.util.BaseUtil;
import com.zkml.official_reception.client.bo.AreaBO;
import com.zkml.official_reception.client.client.HotelClient;
import com.zkml.official_reception.client.client.PointClient;
import com.zkml.official_reception.client.client.SysAreaClient;
import com.zkml.official_reception.client.query.ReceptionQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2019/7/18.
 */
@Service
@Slf4j
public class ResourceManageFacadeServiceImpl implements ResourceManageFacadeService {
    @Autowired
    HotelClient hotelClient;

    @Autowired
    PointClient pointClient;

    @Autowired
    SysAreaClient sysAreaClient;

    @Override
    public ResultModelDTO findCountByAreaId(String areaId, String resourceType) {
        try {
            if ("HOTEL".equals(resourceType)) {
                ResultModelDTO hotelDTO = hotelClient.hotelCountByAreaId(areaId);
                return hotelDTO;
            } else if ("POINT".equals(resourceType)) {
                ResultModelDTO pointlDTO = pointClient.pointCountByAreaId(areaId);
                return pointlDTO;
            }
            return null;
        } catch (OfficialException officialException) {
            return ResultModelUtil.failResult(officialException);
        }
    }



    @Override
    public List<Map> findTotalGroupByAreaId(String areaId) {
        List<Map> mapList = new ArrayList<>();
        ResultModelDTO<List<AreaBO>>  listResultModelBO = sysAreaClient.findAreaById(areaId); //查询到某省份下所有地级市
        List<AreaDTO> listResultModelDTO = BaseUtil.mapList(listResultModelBO.getModel(), AreaDTO.class);
        for(int i=0;i<listResultModelDTO.size();i++){
            Map map = new HashMap();
            map.put("name",listResultModelDTO.get(i).getAreaName());
            ResultModelDTO  hotelCountByAreaId = hotelClient.findByAreaId(listResultModelDTO.get(i).getAreaId());
            ResultModelDTO  pointCountByAreaId = pointClient.findByAreaId(listResultModelDTO.get(i).getAreaId());
            List<Map> mapList1 = new ArrayList<>();
            Map hotelMap = new HashMap();
            hotelMap.put("name","协议酒店");
            hotelMap.put("value",hotelCountByAreaId.getModel());
            Map pointMap = new HashMap();
            pointMap.put("name","考察点");
            pointMap.put("value",pointCountByAreaId.getModel());
            mapList1.add(hotelMap);
            mapList1.add(pointMap);
            map.put("data",mapList1);
            mapList.add(map);
        }
        return mapList;
    }


    @Override
    public ResultModelDTO findWithPage(ReceptionQuery receptionQuery, String type) {
        if("HOTEL".equals(type)){
            try {
                ResultModelDTO hotelClientWithPage = hotelClient.findWithPage(receptionQuery);
                return hotelClientWithPage;
            }catch (OfficialException officialException){
                return ResultModelUtil.failResult(officialException);
            }
        }else  if("POINT".equals(type)){
            try {
                ResultModelDTO pointClientWithPage = pointClient.findWithPage(receptionQuery);
                return pointClientWithPage;
            }catch (OfficialException officialException){
                return ResultModelUtil.failResult(officialException);
            }
        }
        return  null;
    }
}
