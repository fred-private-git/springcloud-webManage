package com.zkml.official_reception.server.service;

import com.zkml.official_reception.client.bo.AreaBO;

import java.util.List;

/**
 * Created by fanghui on 2019/5/6.
 */
public interface SysAreaService {
    /**
     * 通过地区号查询省会下的所有地级市
     * @param areaId
     * @return
     */
    List<AreaBO> findAreaById(String areaId);

}
