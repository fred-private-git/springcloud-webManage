package com.zkml.official_facade.service.impl;

import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.common.obj.util.ResultModelUtil;
import com.zkml.official_facade.dto.AreaDTO;
import com.zkml.official_facade.exception.OfficialException;
import com.zkml.official_facade.service.SysAreaFacadeService;
import com.zkml.official_facade.util.BaseUtil;
import com.zkml.official_reception.client.bo.AreaBO;
import com.zkml.official_reception.client.client.SysAreaClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fanghui on 2019/5/6.
 */

@Service
@Slf4j
public class SysAreaFacadeServiceImpl implements SysAreaFacadeService{

    @Autowired
   private SysAreaClient sysAreaClient;

    @Override
    public ResultModelDTO<List<AreaDTO>> findAreaById(String areaId) {
        try {
            ResultModelDTO<List<AreaBO>> sysAreaList = sysAreaClient.findAreaById(areaId);
            List<AreaDTO> areaDTOList = BaseUtil.mapList(sysAreaList.getModel(),AreaDTO.class);
            return ResultModelUtil.successResult(areaDTOList);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }
}
