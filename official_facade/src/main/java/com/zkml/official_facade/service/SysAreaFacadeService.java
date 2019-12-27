package com.zkml.official_facade.service;

import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.official_facade.dto.AreaDTO;

import java.util.List;

/**
 * Created by fanghui on 2019/5/6.
 */
public interface SysAreaFacadeService {
    /**
     * 查询地区信息
     * @param areaId
     * @return
     */
    ResultModelDTO<List<AreaDTO>> findAreaById(String areaId);

}
