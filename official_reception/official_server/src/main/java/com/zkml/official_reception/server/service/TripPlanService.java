package com.zkml.official_reception.server.service;

import com.zkml.common.obj.dto.PageDTO;
import com.zkml.common.obj.dto.ResultCode;
import com.zkml.official_reception.client.query.ReceptionQuery;
import com.zkml.official_reception.server.po.*;

import java.util.List;
import java.util.Map;

/**
 * Created by fanghui on 2019/5/21.
 */
public interface TripPlanService {

    /**
     * 1.新增行程记录
     * @param receptionLetterPO
     * @param tripVoPO
     * @return
     */
    ResultCode createTrip(ReceptionLetterPO receptionLetterPO, TripVoPO tripVoPO);

    /**
     * 2.修改行程记录
     * @param receptionLetterPO
     * @param tripVoPO
     * @return
     */
    ResultCode updateTrip(ReceptionLetterPO receptionLetterPO, TripVoPO tripVoPO);


    /**
     * 省级联动
     * @return
     */
    List<AreaTreePO> areaTree();

    List<Object> menuTree();

}
