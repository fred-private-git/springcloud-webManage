package com.zkml.official_facade.controller;

import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.common.obj.util.ResultModelUtil;
import com.zkml.official_facade.dto.TripPreviewDTO;
import com.zkml.official_facade.exception.OfficialException;
import com.zkml.official_facade.service.HotelFacadeService;
import com.zkml.official_facade.service.ReceptionFacadeService;
import com.zkml.official_reception.client.query.ReceptionQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fanghui on 2019/5/14.
 */
@RestController
@RequestMapping("/receptionFacade")
@Slf4j
@Api(tags = "公务接待相关服务")
public class ReceptionFacadeController {

    @Autowired
    ReceptionFacadeService receptionFacadeService;


    @ApiOperation("新建行程预览")
    @PostMapping("/createTrip")
    public ResultModelDTO createTrip(@RequestBody TripPreviewDTO tripPreviewDTO) {
        try{
            ResultModelDTO resultModelDTO = receptionFacadeService.createTrip(tripPreviewDTO);
            return resultModelDTO;
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

//    @ApiOperation("行程预览分页列表展示")
//    @GetMapping("/findTripWithPage")
//    public ResultModelDTO findTripWithPage(ReceptionQuery receptionQuery) {
//        try{
//            ResultModelDTO resultModelDTO = receptionFacadeService.findTripWithPage(receptionQuery);
//            return resultModelDTO;
//        }catch (OfficialException officialException){
//            return ResultModelUtil.failResult(officialException);
//        }
//    }
//
//    @ApiOperation("删除行程预览-行程安排")
//    @PostMapping("/deleteByOfficialLetterId")
//    public ResultModelDTO deleteByTripId(String officialLetterId) {
//        try{
//            ResultModelDTO resultModelDTO = receptionFacadeService.deleteByTripId(officialLetterId);
//            return resultModelDTO;
//        }catch (OfficialException officialException){
//            return ResultModelUtil.failResult(officialException);
//        }
//    }
//
//    @ApiOperation("点击修改回显数据")
//    @GetMapping("/findOfficialLetterById")
//    public ResultModelDTO findOfficialLetterById(String officialLetterId) {
//        try{
//            ResultModelDTO resultModelDTO = receptionFacadeService.findOfficialLetterById(officialLetterId);
//            return resultModelDTO;
//        }catch (OfficialException officialException){
//            return ResultModelUtil.failResult(officialException);
//        }
//    }
//
//    @ApiOperation("根据areaId查询所有的接待地点")
//    @GetMapping("/findWithOutPageByAreaId")
//    public ResultModelDTO findWithOutPageByAreaId(String areaId) {
//        try{
//            ResultModelDTO resultModelDTO = receptionFacadeService.findWithOutPage(areaId);
//            Map<String, Object> resultMap = new HashMap<String, Object>();
//            resultMap.put("list",resultModelDTO.getModel());
//            return ResultModelUtil.successResult(resultMap);
//        }catch (OfficialException officialException){
//            return ResultModelUtil.failResult(officialException);
//        }
//    }
//
    @ApiOperation("树结构的递归")
    @GetMapping("/areaTree")
    public ResultModelDTO areaTree() {
        try{
            ResultModelDTO resultModelDTO = receptionFacadeService.areaTree();
            return ResultModelUtil.successResult(resultModelDTO);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }
}
