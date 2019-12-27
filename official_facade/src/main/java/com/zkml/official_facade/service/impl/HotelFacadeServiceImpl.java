package com.zkml.official_facade.service.impl;

import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.common.obj.util.ResultModelUtil;
import com.zkml.official_facade.exception.OfficialException;
import com.zkml.official_facade.service.HotelFacadeService;
import com.zkml.official_reception.client.client.HotelClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by fanghui on 2019/5/6.
 */
@Service
@Slf4j
public class HotelFacadeServiceImpl implements HotelFacadeService{

    @Autowired
    HotelClient hotelClient;



    @Override
    public ResultModelDTO findTotalByAreaId(String areaId) {
        try {
            ResultModelDTO hotelDTO = hotelClient.findTotalByAreaId(areaId);
            return hotelDTO;
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }


    @Override
    public ResultModelDTO findByHotelInfoId(String hotelInfoId) {
        try {
            ResultModelDTO hotelDetail = hotelClient.findByHotelInfoId(hotelInfoId);
            return hotelDetail;
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }
}
