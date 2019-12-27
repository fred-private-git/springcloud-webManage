package com.zkml.official_reception.server.controller;

import com.zkml.common.obj.dto.PageDTO;
import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.common.obj.util.ResultModelUtil;
import com.zkml.official_reception.client.bo.*;
import com.zkml.official_reception.client.client.ColumnManageClient;
import com.zkml.official_reception.client.query.ReceptionQuery;
import com.zkml.official_reception.server.exception.OfficialException;
import com.zkml.official_reception.server.service.ColumnManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by fanghui on 2019/6/17.
 */
@RestController
public class ColumnManageController implements ColumnManageClient {

    @Autowired
    ColumnManageService columnManageService;

    @Override
    public ResultModelDTO<List<TitleBO>> findAll() {
        try {
            List<TitleBO> titleBO = columnManageService.findAll();
            return ResultModelUtil.successResult(titleBO);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO<List<TitleBO>> findTitleAndColumn() {
        try {
            List<TitleBO> titleAndColumn = columnManageService.findTitleAndColumn();
            return ResultModelUtil.successResult(titleAndColumn);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO findAllByColumnId(String columnId) {
        try {
            Map result = columnManageService.findAllByColumnId(columnId);
            return ResultModelUtil.successResult(result);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO create(ColumnBO columnBO) {
        try {
            int resultCode = columnManageService.create(columnBO);
            return ResultModelUtil.successResult(resultCode);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO createChildColumn(ChildColumnBO childColumnBO) {
        try {
            int resultCode = columnManageService.createChildColumn(childColumnBO);
            return ResultModelUtil.successResult(resultCode);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }
    @Override
    public ResultModelDTO updateChildColumnById(ChildColumnBO childColumnBO) {
        try {
            int resultCode = columnManageService.updateChildColumnById(childColumnBO);
            return ResultModelUtil.successResult(resultCode);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }
    @Override
    public ResultModelDTO deleteChildColumnById(String childColumnId) {
        try {
            int deleteChildColumnById = columnManageService.deleteChildColumnById(childColumnId);
            return ResultModelUtil.successResult(deleteChildColumnById);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }
    @Override
    public ResultModelDTO findByTitleId(String titleId) {
        try {
            TitleBO titleBO = columnManageService.findByTitleId(titleId);
            return ResultModelUtil.successResult(titleBO);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO updateTitle(TitleBO titleBO) {
        try {
            int resultCode = columnManageService.updateTitle(titleBO);
            return ResultModelUtil.successResult(resultCode);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }



    @Override
    public ResultModelDTO updateDetailById(ChildColumnDetailBO childColumnDetailBO) {
        try {
            int resultCode = columnManageService.updateDetailById(childColumnDetailBO);
            return ResultModelUtil.successResult(resultCode);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO deleteDetailById(String childColumnDetailId) {
        try {
            int deleteDetailById = columnManageService.deleteDetailById(childColumnDetailId);
            return ResultModelUtil.successResult(deleteDetailById);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO createDetail(ChildColumnDetailBO childColumnDetailBO) {
        try {
            int resultCode = columnManageService.createDetail(childColumnDetailBO);
            return ResultModelUtil.successResult(resultCode);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO findByChildColumnDetailId(String childColumnDetailId) {
        try {
            ChildColumnDetailBO childColumnDetailBO = columnManageService.findByChildColumnDetailId(childColumnDetailId);
            return ResultModelUtil.successResult(childColumnDetailBO);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO updateColumn(ColumnBO columnBO) {
        try {
            int resultCode = columnManageService.updateColumn(columnBO);
            return ResultModelUtil.successResult(resultCode);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    /**
     * 新增山水风光
     * @param columnLandscapeBO
     * @return
     */

    @Override
    public ResultModelDTO createLandScape(ColumnLandscapeBO columnLandscapeBO) {
        try {
            int resultCode = columnManageService.createLandscape(columnLandscapeBO);
            return ResultModelUtil.successResult(resultCode);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO<PageDTO<ColumnLandscapeBO>> findLandScapeWithPage(ReceptionQuery receptionQuery) {
        try {
            PageDTO pageDTO = new PageDTO(receptionQuery.getMax(),receptionQuery.getOffset());
            PageDTO findWithPage = columnManageService.findLandScapeWithPage(receptionQuery,pageDTO);
            return ResultModelUtil.successResult(findWithPage);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO deleteLandscapeById(String columnLandscapeId) {
        try {
            int deleteLandscapeById = columnManageService.deleteLandscapeById(columnLandscapeId);
            return ResultModelUtil.successResult(deleteLandscapeById);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO<ColumnLandscapeBO> findByColumnLandscapeId(String columnLandscapeId) {
        try {
            ColumnLandscapeBO columnLandscapeBO = columnManageService.findByColumnLandscapeId(columnLandscapeId);
            return ResultModelUtil.successResult(columnLandscapeBO );
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO updateLandscapeById(ColumnLandscapeBO columnLandscapeBO) {
        try {
            int resultCode = columnManageService.updateLandscapeById(columnLandscapeBO);
            return ResultModelUtil.successResult(resultCode);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO findFoodWithPage(ReceptionQuery receptionQuery) {
        try {
            PageDTO pageDTO = new PageDTO(receptionQuery.getMax(),receptionQuery.getOffset());
            PageDTO findWithPage = columnManageService.findFoodWithPage(receptionQuery,pageDTO);
            return ResultModelUtil.successResult(findWithPage);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO createFood(ColumnFoodBO columnFoodBO) {
        try {
            int resultCode = columnManageService.createFood(columnFoodBO);
            return ResultModelUtil.successResult(resultCode);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO deleteFoodById(String columnFoodId) {
        try {
            int deleteFoodById = columnManageService.deleteFoodById(columnFoodId);
            return ResultModelUtil.successResult(deleteFoodById);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO<ColumnFoodBO> findByColumnFoodId(String columnFoodId) {
        try {
            ColumnFoodBO columnFoodBO = columnManageService.findByColumnFoodId(columnFoodId);
            return ResultModelUtil.successResult(columnFoodBO );
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO updateFoodById(ColumnFoodBO columnFoodBO) {
        try {
            int resultCode = columnManageService.updateFoodById(columnFoodBO);
            return ResultModelUtil.successResult(resultCode);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO<ColumnGeographyBO> findByColumnGeographyId(String columnGeographyId) {
        try {
            ColumnGeographyBO columnGeographyBO = columnManageService.findByColumnGeographyId(columnGeographyId);
            return ResultModelUtil.successResult(columnGeographyBO );
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO createGeography(ColumnGeographyBO columnGeographyBO) {
        try {
            int resultCode = columnManageService.createGeography(columnGeographyBO);
            return ResultModelUtil.successResult(resultCode);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO deleteGeographyById(String columnGeographyId) {
        try {
            int deleteGeographyById = columnManageService.deleteGeographyById(columnGeographyId);
            return ResultModelUtil.successResult(deleteGeographyById);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO updateGeographyById(ColumnGeographyBO columnGeographyBO) {
        try {
            int resultCode = columnManageService.updateGeographyById(columnGeographyBO);
            return ResultModelUtil.successResult(resultCode);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO findGeographyWithPage(ReceptionQuery receptionQuery) {
        try {
            PageDTO pageDTO = new PageDTO(receptionQuery.getMax(),receptionQuery.getOffset());
            PageDTO findWithPage = columnManageService.findGeographyWithPage(receptionQuery,pageDTO);
            return ResultModelUtil.successResult(findWithPage);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO<ColumnBO> findByColumnId(String columnId) {
        try {
            ColumnBO columnBO = columnManageService.findByColumnId(columnId);
            return ResultModelUtil.successResult(columnBO);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO<ChildColumnBO> findByChildColumnId(String childColumnId) {
        try {
            ChildColumnBO childColumnBO = columnManageService.findByChildColumnId(childColumnId);
            return ResultModelUtil.successResult(childColumnBO);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO findDetailWithPage(ReceptionQuery receptionQuery) {
        try {
            PageDTO pageDTO = new PageDTO(receptionQuery.getMax(),receptionQuery.getOffset());
            PageDTO<ChildColumnDetailBO> detailWithPage = columnManageService.findDetailWithPage(receptionQuery, pageDTO);
            return ResultModelUtil.successResult(detailWithPage);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

}
