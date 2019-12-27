package com.zkml.official_facade.controller;

import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.common.obj.util.BizResultModelUtil;
import com.zkml.common.obj.util.ResultModelUtil;
import com.zkml.official_facade.dto.AreaDTO;
import com.zkml.official_facade.exception.OfficialException;
import com.zkml.official_facade.service.SysAreaFacadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by fanghui on 2019/5/6.
 */

@RestController
@RequestMapping("/sysAreaFacade")
@Slf4j
@Api(tags = "地区相关服务")
public class SysAreaFacadeController {

    @Autowired
    private SysAreaFacadeService sysAreaFacadeService;

    @GetMapping("/findAreaById")
    @ApiOperation("查询省会下所有地级市信息接口")
    public ResultModelDTO findAreaById(String areaId) {
        if(areaId == null || areaId.equals("")){
            return BizResultModelUtil.paramsBlankError();
        }
        try{
            ResultModelDTO<List<AreaDTO>> sysAreaList = sysAreaFacadeService.findAreaById(areaId);
            Map<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("list",sysAreaList.getModel());
            return ResultModelUtil.successResult(resultMap);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }
}
