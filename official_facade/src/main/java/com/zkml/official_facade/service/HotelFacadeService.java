package com.zkml.official_facade.service;

import com.zkml.common.obj.dto.ResultModelDTO;

import java.util.List;
import java.util.Map;

/**
 * Created by fanghui on 2019/5/6.
 */
public interface HotelFacadeService {


    /**
     * 每个省下各个地级市的接待点统计
     * @param areaId
     * @return
     */
    ResultModelDTO findTotalByAreaId(String areaId);


    /**
     * 根据hotelInfoId查询
     * @param hotelInfoId
     * @return
     */
    ResultModelDTO findByHotelInfoId(String hotelInfoId);

}
