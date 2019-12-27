package com.zkml.official_reception.server.controller;

import com.zkml.common.obj.dto.PageDTO;
import com.zkml.common.obj.dto.ResultCode;
import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.common.obj.util.ResultModelUtil;
import com.zkml.official_reception.client.bo.AreaBO;
import com.zkml.official_reception.client.client.SysAreaClient;
import com.zkml.official_reception.server.exception.OfficialException;
import com.zkml.official_reception.server.service.SysAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by fanghui on 2019/5/6.
 */
@RestController
public class SysAreaController implements SysAreaClient {

    @Autowired
    SysAreaService sysAreaService;

    @Override
    public ResultModelDTO<List<AreaBO>> findAreaById(String areaId) {
        try {
            List<AreaBO> resultCode = sysAreaService.findAreaById(areaId);
            return ResultModelUtil.successResult(resultCode);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }
}
