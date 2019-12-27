package com.zkml.official_facade.controller;

import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.common.obj.util.BizResultModelUtil;
import com.zkml.common.obj.util.ResultModelUtil;
import com.zkml.official_facade.dto.TitleDTO;
import com.zkml.official_facade.exception.OfficialException;
import com.zkml.official_facade.service.HotelFacadeService;
import com.zkml.official_facade.service.ReceptionFacadeService;
import com.zkml.official_facade.service.ResourceManageFacadeService;
import com.zkml.official_reception.client.query.ReceptionQuery;
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
 * Created by admin on 2019/7/16.
 */

@RestController
@RequestMapping("/resourceManageFacade")
@Slf4j
@Api(tags = "资源管理相关服务")
public class ResourceManageFacadeController {

    @Autowired
    ResourceManageFacadeService resourceManageFacadeService;
    @Autowired
    ReceptionFacadeService receptionFacadeService;
    @Autowired
    HotelFacadeService hotelFacadeService;

    @ApiOperation("查询某个省份下(视察点|酒店|会议室)的总数")
    @GetMapping("/findCountByAreaId")
    public ResultModelDTO findCountByAreaId(String areaId,String resourceType) {
        if(areaId == null || areaId.equals("")||resourceType == null||resourceType.equals("")){

            return BizResultModelUtil.paramsBlankError();
        }
        try{
            ResultModelDTO countByAreaId = resourceManageFacadeService.findCountByAreaId(areaId,resourceType);
            Map resultMap = new HashMap<>();
            resultMap.put("total", countByAreaId.getModel());
            return ResultModelUtil.successResult(resultMap);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @ApiOperation("各个地级市下(视察点|酒店|会议室)的数量")
    @GetMapping("/findTotalByAreaId")
    public ResultModelDTO findTotalByAreaId(String areaId,String type) {
        if(areaId == null || areaId.equals("") ||type == null || type.equals("")){
            return BizResultModelUtil.paramsBlankError();
        }
        if("HOTEL".equals(type)){
            try{
                ResultModelDTO findTotalByAreaId = hotelFacadeService.findTotalByAreaId(areaId);
                Map<String, Object> resultMap = new HashMap<String, Object>();
                resultMap.put("list", findTotalByAreaId.getModel());
                return ResultModelUtil.successResult(resultMap);
            }catch (OfficialException officialException){
                return ResultModelUtil.failResult(officialException);
            }
        }else  if("POINT".equals(type)){
            try{
                ResultModelDTO findTotalByAreaId = receptionFacadeService.findTotalByAreaId(areaId);
                Map<String, Object> resultMap = new HashMap<String, Object>();
                resultMap.put("list", findTotalByAreaId.getModel());
                return ResultModelUtil.successResult(resultMap);
            }catch (OfficialException officialException){
                return ResultModelUtil.failResult(officialException);

            }
        }
        return  null;
    }

    @ApiOperation("查询某个省份各地级市下的(酒店&会议室&视察点)数量")
    @GetMapping("/findTotalGroupByAreaId")
    public ResultModelDTO findTotalGroupByAreaId(String areaId) {
        if(areaId == null || areaId.equals("")){

            return BizResultModelUtil.paramsBlankError();
        }
        try{
            List<Map> countByAreaId = resourceManageFacadeService.findTotalGroupByAreaId(areaId);
            return ResultModelUtil.successResult(countByAreaId);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @ApiOperation("资源信息-酒店、视察点具体详情分页展示")
    @GetMapping("/findWithPage")
    public ResultModelDTO findWithPage(ReceptionQuery receptionQuery, String type) {
        if(type == null || type.equals("")){
            return BizResultModelUtil.paramsBlankError();
        }
        try{
            ResultModelDTO resultModelDTO = resourceManageFacadeService.findWithPage(receptionQuery,type);
            return resultModelDTO;
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @ApiOperation("查询酒店、会议室、视察点详情页")
    @GetMapping("/findByDetailInfoId")
    public ResultModelDTO findByDetailInfoId(String detailId, String type) {
        if(type == null || type.equals("") || detailId == null || detailId.equals("")){
            return BizResultModelUtil.paramsBlankError();
        }
        if ("POINT".equals(type)){
            try{
                ResultModelDTO resultModelDTO = receptionFacadeService.findByInspectionPointInfoId(detailId);
                Map<String, Object> resultMap = new HashMap<String, Object>();
                resultMap.put("detail",resultModelDTO.getModel());
                return ResultModelUtil.successResult(resultMap);
            }catch (OfficialException officialException){
                return ResultModelUtil.failResult(officialException);
            }
        }else if("HOTEL".equals(type)){
            try{
                ResultModelDTO resultModelDTO = hotelFacadeService.findByHotelInfoId(detailId);
                Map<String, Object> resultMap = new HashMap<String, Object>();
                resultMap.put("detail",resultModelDTO.getModel());
                return ResultModelUtil.successResult(resultMap);
            }catch (OfficialException officialException){
                return ResultModelUtil.failResult(officialException);
            }
        }
        return  null;
    }
}
