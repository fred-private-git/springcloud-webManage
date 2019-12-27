package com.zkml.official_facade.controller;

import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.common.obj.util.BizResultModelUtil;
import com.zkml.common.obj.util.ResultModelUtil;
import com.zkml.official_facade.dto.*;
import com.zkml.official_facade.exception.OfficialException;
import com.zkml.official_facade.service.ColumnManageFacadeService;
import com.zkml.official_reception.client.query.ReceptionQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fanghui on 2019/6/17.
 */
@RestController
@RequestMapping("/columnManageFacade")
@Slf4j
@Api(tags = "栏目管理相关服务")
public class ColumnManageFacadeController {

    @Autowired
    ColumnManageFacadeService columnManageFacadeService;


    @ApiOperation("查询所有的主题资源")
    @GetMapping("/findAll")
    public ResultModelDTO<List<TitleDTO>> findAll() {
        try{
            ResultModelDTO<List<TitleDTO>> titleDTOList = columnManageFacadeService.findAll();
            return titleDTOList;
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @ApiOperation("查询主题下的所有栏目")
    @GetMapping("/findTitleAndColumn")
    public ResultModelDTO<List<TitleDTO>> findTitleAndColumn() {
        try{
            ResultModelDTO<List<TitleDTO>> titleDTOList = columnManageFacadeService.findTitleAndColumn();
            return titleDTOList;
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @ApiOperation("修改主题资源信息")
    @PostMapping("/updateTitle")
    public ResultModelDTO updateTitle(@RequestBody TitleDTO titleDTO) {
        try{
            ResultModelDTO resultCode = columnManageFacadeService.updateTitle(titleDTO);
            return resultCode;
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @ApiOperation("查询同一栏目下所有子栏目")
    @GetMapping("/findAllByColumnId")
    public ResultModelDTO findAllByColumnId(String columnId) {
        try{
            ResultModelDTO resultModelDTO = columnManageFacadeService.findAllByColumnId(columnId);
            return resultModelDTO;
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @ApiOperation("栏目回显")
    @GetMapping("/findByColumnId")
    public ResultModelDTO<ColumnDTO> findByColumnId(String columnId) {
        if(columnId == null || columnId.equals("")){
            return BizResultModelUtil.paramsBlankError();
        }
        try{
            ResultModelDTO<ColumnDTO> resultModelDTO = columnManageFacadeService.findByColumnId(columnId);
            return resultModelDTO;
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @ApiOperation("新增栏目")
    @PostMapping("/create")
    public ResultModelDTO create(@RequestBody ColumnDTO columnDTO) {
        try{
            ResultModelDTO resultModelDTO = columnManageFacadeService.create(columnDTO);
            return resultModelDTO;
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @ApiOperation("修改栏目信息")
    @PostMapping("/updateColumn")
    public ResultModelDTO updateColumn(@RequestBody ColumnDTO columnDTO) {
        if(columnDTO.getColumnId() == null || columnDTO.getColumnId().equals("")){
            return BizResultModelUtil.paramsBlankError();
        }
        try{

            ResultModelDTO resultCode = columnManageFacadeService.updateColumn(columnDTO);
            return resultCode;
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @ApiOperation("根据id查询子栏目")
    @GetMapping("/findByChildColumnId")
    public ResultModelDTO<ChildColumnDTO> findByChildColumnId(String childColumnId) {
        if(childColumnId == null || childColumnId.equals("")){
            return BizResultModelUtil.paramsBlankError();
        }
        try{
            ResultModelDTO<ChildColumnDTO> resultModelDTO = columnManageFacadeService.findByChildColumnId(childColumnId);
            return resultModelDTO;
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @ApiOperation("新增,修改,删除子栏目")
    @PostMapping("/childColumnModify")
    public ResultModelDTO childColumnModify(@RequestBody ChildColumnDTO childColumnDTO, String flag) {
        if(flag == null || flag.equals("")){
            return BizResultModelUtil.paramsBlankError();
        }
        try{
            return columnManageFacadeService.childColumnModify(childColumnDTO, flag);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @ApiOperation("新增,修改,删除子栏目内容")
    @PostMapping("/childColumnDetailModify")
    public ResultModelDTO childColumnDetailModify(@RequestBody ChildColumnDetailDTO childColumnDetailDTO,String flag) {
        if(flag == null || flag.equals("")){
            return BizResultModelUtil.paramsBlankError();
        }
        try{
            return columnManageFacadeService.childColumnDetailModify(childColumnDetailDTO,flag);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @ApiOperation("根据id查询子栏目内容详情")
    @GetMapping("/findByChildColumnDetailId")
    public ResultModelDTO<ChildColumnDetailDTO> findByChildColumnDetailId(String childColumnDetailId) {
        if(childColumnDetailId == null || childColumnDetailId.equals("")){
            return BizResultModelUtil.paramsBlankError();
        }
        try{
            ResultModelDTO<ChildColumnDetailDTO> resultModelDTO = columnManageFacadeService.findByChildColumnDetailId(childColumnDetailId);
            return resultModelDTO;
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @ApiOperation("栏目--山水,美食,地理分页列表展示")
    @GetMapping("/findWithPage")
    public ResultModelDTO findWithPage(ReceptionQuery receptionQuery,String flag) {
        if(flag == null || flag.equals("")){
            return BizResultModelUtil.paramsBlankError();
        }
        try{
            ResultModelDTO resultModelDTO = columnManageFacadeService.findWithPage(receptionQuery,flag);
            return resultModelDTO;
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @ApiOperation("根据Id查询山水风光,风味美食,自然地理")
    @GetMapping("/findById")
    public ResultModelDTO findById(String pId,String flag) {
        if(pId == null || pId.equals("") || flag == null || flag.equals("")){
            return BizResultModelUtil.paramsBlankError();
        }
        try{
            ResultModelDTO resultModelDTO = columnManageFacadeService.findById(pId,flag);
            return resultModelDTO;
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @ApiOperation("新增,修改,删除山水风光")
    @PostMapping("/landscapeModify")
    public ResultModelDTO landscapeModify(@RequestBody ColumnLandscapeDTO columnLandscapeDTO,String flag) {
        if(flag == null || flag.equals("")){
            return BizResultModelUtil.paramsBlankError();
        }
        try{
            return columnManageFacadeService.landscapeModify(columnLandscapeDTO,flag);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }


    @ApiOperation("新增,修改,删除风味美食")
    @PostMapping("/foodModify")
    public ResultModelDTO foodModify(@RequestBody ColumnFoodDTO columnfoodDTO,String flag) {
        if(flag == null || flag.equals("")){
            return BizResultModelUtil.paramsBlankError();
        }
        try{
            return columnManageFacadeService.foodModify(columnfoodDTO,flag);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }


    @ApiOperation("新增,修改,删除自然地理")
    @PostMapping("/geographyModify")
    public ResultModelDTO geographyModify(@RequestBody ColumnGeographyDTO columnGeographyDTO,String flag) {
        if(flag == null || flag.equals("")){
            return BizResultModelUtil.paramsBlankError();
        }
        try{
            return columnManageFacadeService.geographyModify(columnGeographyDTO,flag);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }


    @ApiOperation("栏目-子栏目的分页列表查询")
    @GetMapping("/findDetailWithPage")
    public ResultModelDTO findDetailWithPage(ReceptionQuery receptionQuery) {
        try{
            ResultModelDTO resultModelDTO = columnManageFacadeService.findDetailWithPage(receptionQuery);
            return resultModelDTO;
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @ApiOperation("根据id查询主题资源")
    @GetMapping("/findByTitleId")
    public ResultModelDTO<TitleDTO> findByTitleId(String titleId) {
        if(titleId == null || titleId.equals("")){
            return BizResultModelUtil.paramsBlankError();
        }
        try{
            ResultModelDTO<TitleDTO> resultModelDTO = columnManageFacadeService.findByTitleId(titleId);
            return resultModelDTO;
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

}
