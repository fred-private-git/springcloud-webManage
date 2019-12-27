package com.zkml.official_reception.server.service.impl;

import com.zkml.common.obj.dto.PageDTO;
import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.common.obj.enums.DefaultResultCodeEnum;
import com.zkml.common.obj.util.ResultModelUtil;
import com.zkml.official_reception.client.bo.*;
import com.zkml.official_reception.client.client.ColumnManageClient;
import com.zkml.official_reception.client.query.ReceptionQuery;
import com.zkml.official_reception.server.dao.*;
import com.zkml.official_reception.server.exception.OfficialException;
import com.zkml.official_reception.server.po.*;
import com.zkml.official_reception.server.service.ColumnManageService;
import com.zkml.official_reception.server.util.BaseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Pattern;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by fanghui on 2019/6/17.
 */
@Slf4j
@Service
public class ColumnManageServiceImpl implements ColumnManageService{

    @Autowired
    TitleDAO titleDAO;

    @Autowired
    ColumnDAO columnDAO;

    @Autowired
    ColumnLandscapeDAO columnLandscapeDAO;

    @Autowired
    ColumnFoodDAO columnFoodDAO;

    @Autowired
    ColumnGeographyDAO columnGeographyDAO;

    @Autowired
    ChildColumnDetailDAO childColumnDetailDAO;

    @Autowired
    ChildColumnDAO childColumnDAO;
    @Override
    public List<TitleBO> findAll() {
        List<TitlePO> titlePO = titleDAO.findAll();
        List<TitleBO> titlePOList1 = titlePO.stream().map(item -> {
            List<String> list = Arrays.asList(item.getAttachImg().split(","));
            TitleBO titleBO = new TitleBO();
            titleBO.setTitleIntroduction(item.getTitleIntroduction());
            titleBO.setTitleName(item.getTitleName());
            titleBO.setAreaId(item.getAreaId());
            titleBO.setTitleId(item.getTitleId());
            titleBO.setAttachImg(list);
            titleBO.setUploadImage(item.getUploadImage());
            return  titleBO;
        }).collect(Collectors.toList());
/*        List<TitleBO> titlePOList = new ArrayList<>();
        for(TitlePO item:titlePO){
            List<String> list = Arrays.asList(item.getAttachImg().split(","));
            TitleBO titleBO = new TitleBO();
            titleBO.setTitleIntroduction(item.getTitleIntroduction());
            titleBO.setTitleName(item.getTitleName());
            titleBO.setAreaId(item.getAreaId());
            titleBO.setTitleId(item.getTitleId());
            titleBO.setAttachImg(list);
            titlePOList.add(titleBO);
        }*/
        return titlePOList1;
    }

    @Override
    public List<TitleBO> findTitleAndColumn() {
        List<TitlePO> titlePO = titleDAO.findAll();
        List<TitleBO> titlePOList = new ArrayList<>();
        for(TitlePO item:titlePO){
            List<String> list = Arrays.asList(item.getAttachImg().split(","));
            TitleBO titleBO = new TitleBO();
            titleBO.setTitleIntroduction(item.getTitleIntroduction());
            titleBO.setTitleName(item.getTitleName());
            titleBO.setAreaId(item.getAreaId());
            titleBO.setTitleId(item.getTitleId());
            titleBO.setUploadImage(item.getUploadImage());
            titleBO.setAttachImg(list);
            titlePOList.add(titleBO);
        }
        List<TitleBO> titleBOS = new ArrayList<>();
        for(TitleBO item:titlePOList){
            TitleBO titleBO = new TitleBO();
            List<ColumnPOVO> columnPOList = columnDAO.findByTitleId(item.getTitleId());
            titleBO.setColumnBOList(BaseUtil.mapList(columnPOList, ColumnBOVO.class));
            titleBO.setAreaId(item.getAreaId());
            titleBO.setUploadImage(item.getUploadImage());
            titleBO.setAttachImg(item.getAttachImg());
            titleBO.setTitleId(item.getTitleId());
            titleBO.setTitleName(item.getTitleName());
            titleBO.setTitleIntroduction(item.getTitleIntroduction());
            titleBOS.add(titleBO);
        }
        return titleBOS;
    }

    @Override
    public Map findAllByColumnId(String columnId) {
        try {
            ColumnPO columnPO = columnDAO.findByColumnId(columnId);
            List<ChildColumnPO> childColumnPOList = childColumnDAO.findChildByColumnId(columnId);
            Map resultMap = new HashMap();
            resultMap.put("columnId",columnPO.getColumnId());
            resultMap.put("belongTitleId",columnPO.getBelongTitleId());
            resultMap.put("columnName",columnPO.getColumnName());
            resultMap.put("icon",columnPO.getIcon());
            resultMap.put("mark",columnPO.getMark());
            resultMap.put("status",columnPO.getStatus());
            resultMap.put("dateCreated",columnPO.getDateCreated());
            resultMap.put("lastUpdated",columnPO.getLastUpdated());
            resultMap.put("logicDetele",columnPO.getLogicDetele());
            resultMap.put("childColumnList",childColumnPOList);

            return resultMap;
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }


    @Override
    @Transactional
    public int create(ColumnBO columnBO) {
        int resultCode= columnDAO.create(BaseUtil.map(columnBO,ColumnPO.class));
        return resultCode;
    }



    @Override
    public TitleBO findByTitleId(String titleId) {
        TitlePO titlePO = titleDAO.findByTitleId(titleId);
        List<String> list = Arrays.asList(titlePO.getAttachImg().split(","));
        TitleBO titleBO = new TitleBO();
        titleBO.setTitleIntroduction(titlePO.getTitleIntroduction());
        titleBO.setTitleName(titlePO.getTitleName());
        titleBO.setAreaId(titlePO.getAreaId());
        titleBO.setTitleId(titlePO.getTitleId());
        titleBO.setUploadImage(titlePO.getUploadImage());
        titleBO.setAttachImg(list);
        return titleBO;
    }

    @Override
    @Transactional
    public int updateTitle(TitleBO titleBO) {
        TitlePO titlePO = new TitlePO();
        titlePO.setAreaId(titleBO.getAreaId());
        titlePO.setTitleId(titleBO.getTitleId());
        titlePO.setTitleName(titleBO.getTitleName());
        titlePO.setTitleIntroduction(titleBO.getTitleIntroduction());
        titlePO.setUploadImage(titleBO.getUploadImage());
        titlePO.setAttachImg(StringUtils.join(titleBO.getAttachImg(),","));
        return titleDAO.updateTitle(titlePO);
    }

    @Override
    @Transactional
    public int createChildColumn(ChildColumnBO childColumnBO) {
        return childColumnDAO.createChildColumn(BaseUtil.map(childColumnBO, ChildColumnPO.class));

    }
    @Override
    @Transactional
    public int updateChildColumnById(ChildColumnBO childColumnBO) {
        return childColumnDAO.updateChildColumnById(BaseUtil.map(childColumnBO,ChildColumnPO.class));
    }

    @Override
    @Transactional
    public int deleteChildColumnById(String childColumnId) {
        try {
            int deleteChildColumnById = childColumnDAO.deleteChildColumnById(childColumnId);
            return deleteChildColumnById;
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    @Transactional
    public int createDetail(ChildColumnDetailBO childColumnDetailBO) {
        int resultCode = childColumnDetailDAO.createDetail(BaseUtil.map(childColumnDetailBO,ChildColumnDetailPO.class));
        return resultCode;
    }

    @Override
    @Transactional
    public int updateDetailById(ChildColumnDetailBO childColumnDetailBO) {
        return childColumnDetailDAO.updateDetailById(BaseUtil.map(childColumnDetailBO,ChildColumnDetailPO.class));
    }

    @Override
    @Transactional
    public int deleteDetailById(String childColumnDetailId) {
        try {
            int deleteDetailById = childColumnDetailDAO.deleteDetailById(childColumnDetailId);
            return deleteDetailById;
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    public ChildColumnDetailBO findByChildColumnDetailId(String childColumnDetailId) {
        try {
            ChildColumnDetailPO childColumnDetailPO = childColumnDetailDAO.findByChildColumnDetailId(childColumnDetailId);
            return BaseUtil.map(childColumnDetailPO,ChildColumnDetailBO.class);
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    @Transactional
    public int updateColumn(ColumnBO columnBO) {
        return columnDAO.updateColumn(BaseUtil.map(columnBO,ColumnPO.class));
    }


    @Override
    public PageDTO<ColumnLandscapeBO> findLandScapeWithPage(ReceptionQuery receptionQuery, PageDTO pageDTO) {
        try {
            List<ColumnLandscapePO> columnLandscapePOList = columnLandscapeDAO.findWithPage(receptionQuery, pageDTO.getOffset(), pageDTO.getMax());
            ArrayList<ColumnLandscapeBO> columnLandscapeBOList = new ArrayList<>();
            List<String> list = null;
            for (ColumnLandscapePO columnLandscapePO : columnLandscapePOList) {
                if (StringUtils.isNotBlank(columnLandscapePO.getAttachImg())){
                    list = Arrays.asList(columnLandscapePO.getAttachImg().split(","));
                }else {
                }
                ColumnLandscapeBO columnLandscapeBO = new ColumnLandscapeBO();
                columnLandscapeBO.setBelongColumnId(columnLandscapePO.getBelongColumnId());
                columnLandscapeBO.setDateCreated(columnLandscapePO.getDateCreated());
                columnLandscapeBO.setLastUpdated(columnLandscapePO.getLastUpdated());
                columnLandscapeBO.setLogicDelete(columnLandscapePO.getLogicDelete());
                columnLandscapeBO.setBriefIntroduction(columnLandscapePO.getBriefIntroduction());
                columnLandscapeBO.setColumnLandscapeId(columnLandscapePO.getColumnLandscapeId());
                columnLandscapeBO.setColumnLandscapeName(columnLandscapePO.getColumnLandscapeName());
                columnLandscapeBO.setUrl(columnLandscapePO.getUrl());
                columnLandscapeBO.setSiteImgX(columnLandscapePO.getSiteImgX());
                columnLandscapeBO.setSiteImgY(columnLandscapePO.getSiteImgY());
                columnLandscapeBO.setDetailedAddress(columnLandscapePO.getDetailedAddress());
                columnLandscapeBO.setAreaId(columnLandscapePO.getAreaId());
                columnLandscapeBO.setAttachImg(list);
                columnLandscapeBOList.add(columnLandscapeBO);
            }
            Long totalCount = columnLandscapeDAO.findCountWithPage(receptionQuery);
            pageDTO.setPage(columnLandscapeBOList, totalCount);
            return pageDTO;
        } catch (Exception e) {
            throw new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    @Transactional
    public int createLandscape(ColumnLandscapeBO columnLandscapeBO) {
        ColumnLandscapePO columnLandscapePO = new ColumnLandscapePO();
        columnLandscapePO.setBelongColumnId(columnLandscapeBO.getBelongColumnId());
        columnLandscapePO.setDateCreated(columnLandscapeBO.getDateCreated());
        columnLandscapePO.setLastUpdated(columnLandscapeBO.getLastUpdated());
        columnLandscapePO.setLogicDelete(columnLandscapeBO.getLogicDelete());
        columnLandscapePO.setBriefIntroduction(columnLandscapeBO.getBriefIntroduction());
        columnLandscapePO.setColumnLandscapeId(columnLandscapeBO.getColumnLandscapeId());
        columnLandscapePO.setColumnLandscapeName(columnLandscapeBO.getColumnLandscapeName());
        columnLandscapePO.setUrl(columnLandscapeBO.getUrl());
        columnLandscapePO.setSiteImgX(columnLandscapeBO.getSiteImgX());
        columnLandscapePO.setSiteImgY(columnLandscapeBO.getSiteImgY());
        columnLandscapePO.setDetailedAddress(columnLandscapeBO.getDetailedAddress());
        columnLandscapePO.setAreaId(columnLandscapeBO.getAreaId());
        columnLandscapePO.setAttachImg(StringUtils.join(columnLandscapeBO.getAttachImg(), ","));
        return columnLandscapeDAO.createLandscape(columnLandscapePO);
        }

    @Override
    @Transactional
    public int deleteLandscapeById(String columnLandscapeId) {
        try {
            int deleteLandscapeById = columnLandscapeDAO.deleteLandscapeById(columnLandscapeId);
            return deleteLandscapeById;
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    public ColumnLandscapeBO findByColumnLandscapeId(String columnLandscapeId) {
        try {
            ColumnLandscapePO columnLandscapePO = columnLandscapeDAO.findByColumnLandscapeId(columnLandscapeId);
            List<String> list = Arrays.asList(columnLandscapePO.getAttachImg().split(","));
            ColumnLandscapeBO columnLandscapeBO = new ColumnLandscapeBO();
            columnLandscapeBO.setBelongColumnId(columnLandscapePO.getBelongColumnId());
            columnLandscapeBO.setDateCreated(columnLandscapePO.getDateCreated());
            columnLandscapeBO.setLastUpdated(columnLandscapePO.getLastUpdated());
            columnLandscapeBO.setLogicDelete(columnLandscapePO.getLogicDelete());
            columnLandscapeBO.setBriefIntroduction(columnLandscapePO.getBriefIntroduction());
            columnLandscapeBO.setColumnLandscapeId(columnLandscapePO.getColumnLandscapeId());
            columnLandscapeBO.setColumnLandscapeName(columnLandscapePO.getColumnLandscapeName());
            columnLandscapeBO.setUrl(columnLandscapePO.getUrl());
            columnLandscapeBO.setSiteImgX(columnLandscapePO.getSiteImgX());
            columnLandscapeBO.setSiteImgY(columnLandscapePO.getSiteImgY());
            columnLandscapeBO.setDetailedAddress(columnLandscapePO.getDetailedAddress());
            columnLandscapeBO.setAreaId(columnLandscapePO.getAreaId());
            columnLandscapeBO.setAttachImg(list);
            return columnLandscapeBO;
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    @Transactional
    public int updateLandscapeById(ColumnLandscapeBO columnLandscapeBO) {
        ColumnLandscapePO columnLandscapePO = new ColumnLandscapePO();
        columnLandscapePO.setBelongColumnId(columnLandscapeBO.getBelongColumnId());
        columnLandscapePO.setDateCreated(columnLandscapeBO.getDateCreated());
        columnLandscapePO.setLastUpdated(columnLandscapeBO.getLastUpdated());
        columnLandscapePO.setLogicDelete(columnLandscapeBO.getLogicDelete());
        columnLandscapePO.setBriefIntroduction(columnLandscapeBO.getBriefIntroduction());
        columnLandscapePO.setColumnLandscapeId(columnLandscapeBO.getColumnLandscapeId());
        columnLandscapePO.setColumnLandscapeName(columnLandscapeBO.getColumnLandscapeName());
        columnLandscapePO.setUrl(columnLandscapeBO.getUrl());
        columnLandscapePO.setSiteImgX(columnLandscapeBO.getSiteImgX());
        columnLandscapePO.setSiteImgY(columnLandscapeBO.getSiteImgY());
        columnLandscapePO.setDetailedAddress(columnLandscapeBO.getDetailedAddress());
        columnLandscapePO.setAreaId(columnLandscapeBO.getAreaId());
        columnLandscapePO.setAttachImg(StringUtils.join(columnLandscapeBO.getAttachImg(), ","));
        return columnLandscapeDAO.updateLandscapeById(columnLandscapePO);
    }



    @Override
    public PageDTO<ColumnFoodBO> findFoodWithPage(ReceptionQuery receptionQuery, PageDTO pageDTO) {
        try {
            List<ColumnFoodPO> columnFoodPOList = columnFoodDAO.findWithPage(receptionQuery, pageDTO.getOffset(), pageDTO.getMax());
            ArrayList<ColumnFoodBO> columnFoodBOList = new ArrayList<>();
            List<String> list = null;
            for (ColumnFoodPO columnFoodPO : columnFoodPOList) {
                if (StringUtils.isNotBlank(columnFoodPO.getAttachImg())){
                    list = Arrays.asList(columnFoodPO.getAttachImg().split(","));
                }else {
                }
                ColumnFoodBO columnFoodBO = new ColumnFoodBO();
                columnFoodBO.setBelongColumnId(columnFoodPO.getBelongColumnId());
                columnFoodBO.setDateCreated(columnFoodPO.getDateCreated());
                columnFoodBO.setLastUpdated(columnFoodPO.getLastUpdated());
                columnFoodBO.setLogicDelete(columnFoodPO.getLogicDelete());
                columnFoodBO.setBriefIntroduction(columnFoodPO.getBriefIntroduction());
                columnFoodBO.setColumnFoodId(columnFoodPO.getColumnFoodId());
                columnFoodBO.setFoodMake(columnFoodPO.getFoodMake());
                columnFoodBO.setColumnFoodName(columnFoodPO.getColumnFoodName());
                columnFoodBO.setFoodRestaurant(columnFoodPO.getFoodRestaurant());
                columnFoodBO.setAttachImg(list);
                columnFoodBO.setRawMateria(columnFoodPO.getRawMateria());
                columnFoodBOList.add(columnFoodBO);
            }
            Long totalCount = columnFoodDAO.findCountWithPage(receptionQuery);
            pageDTO.setPage(columnFoodBOList, totalCount);
            return pageDTO;
        } catch (Exception e) {
            throw new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    @Transactional
    public int createFood(ColumnFoodBO columnFoodBO) {
        try {
            ColumnFoodPO columnFoodPO = new ColumnFoodPO();
            columnFoodPO.setBelongColumnId(columnFoodBO.getBelongColumnId());
            columnFoodPO.setBriefIntroduction(columnFoodBO.getBriefIntroduction());
            columnFoodPO.setColumnFoodId(columnFoodBO.getColumnFoodId());
            columnFoodPO.setColumnFoodName(columnFoodBO.getColumnFoodName());
            columnFoodPO.setDateCreated(columnFoodBO.getDateCreated());
            columnFoodPO.setLastUpdated(columnFoodBO.getLastUpdated());
            columnFoodPO.setFoodMake(columnFoodBO.getFoodMake());
            columnFoodPO.setFoodRestaurant(columnFoodBO.getFoodRestaurant());
            columnFoodPO.setRawMateria(columnFoodBO.getRawMateria());
            columnFoodPO.setLogicDelete(columnFoodBO.getLogicDelete());
            columnFoodPO.setAttachImg(StringUtils.join(columnFoodBO.getAttachImg(), ","));
            return columnFoodDAO.createFood(columnFoodPO);
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    @Transactional
    public int deleteFoodById(String columnFoodId) {
        try {
            int deleteFoodById = columnFoodDAO.deleteFoodById(columnFoodId);
            return deleteFoodById;
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    public ColumnFoodBO findByColumnFoodId(String columnFoodId) {
        try {
            ColumnFoodPO columnFoodPO = columnFoodDAO.findByColumnFoodId(columnFoodId);
            List<String> list = Arrays.asList(columnFoodPO.getAttachImg().split(","));
            ColumnFoodBO columnFoodBO = new ColumnFoodBO();
            columnFoodBO.setBelongColumnId(columnFoodPO.getBelongColumnId());
            columnFoodBO.setDateCreated(columnFoodPO.getDateCreated());
            columnFoodBO.setLastUpdated(columnFoodPO.getLastUpdated());
            columnFoodBO.setLogicDelete(columnFoodPO.getLogicDelete());
            columnFoodBO.setBriefIntroduction(columnFoodPO.getBriefIntroduction());
            columnFoodBO.setColumnFoodId(columnFoodPO.getColumnFoodId());
            columnFoodBO.setFoodMake(columnFoodPO.getFoodMake());
            columnFoodBO.setColumnFoodName(columnFoodPO.getColumnFoodName());
            columnFoodBO.setFoodRestaurant(columnFoodPO.getFoodRestaurant());
            columnFoodBO.setAttachImg(list);
            columnFoodBO.setRawMateria(columnFoodPO.getRawMateria());
            return columnFoodBO;
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    @Transactional
    public int updateFoodById(ColumnFoodBO columnFoodBO) {
        try {
            ColumnFoodPO columnFoodPO = new ColumnFoodPO();
            columnFoodPO.setBelongColumnId(columnFoodBO.getBelongColumnId());
            columnFoodPO.setBriefIntroduction(columnFoodBO.getBriefIntroduction());
            columnFoodPO.setColumnFoodId(columnFoodBO.getColumnFoodId());
            columnFoodPO.setColumnFoodName(columnFoodBO.getColumnFoodName());
            columnFoodPO.setDateCreated(columnFoodBO.getDateCreated());
            columnFoodPO.setLastUpdated(columnFoodBO.getLastUpdated());
            columnFoodPO.setFoodMake(columnFoodBO.getFoodMake());
            columnFoodPO.setFoodRestaurant(columnFoodBO.getFoodRestaurant());
            columnFoodPO.setRawMateria(columnFoodBO.getRawMateria());
            columnFoodPO.setLogicDelete(columnFoodBO.getLogicDelete());
            columnFoodPO.setAttachImg(StringUtils.join(columnFoodBO.getAttachImg(),","));
            return columnFoodDAO.updateFoodById(columnFoodPO);
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }


    @Override
    public ColumnGeographyBO findByColumnGeographyId(String columnGeographyId) {
        try {
            ColumnGeographyPO columnGeographyPO = columnGeographyDAO.findByColumnGeographyId(columnGeographyId);
            List<String> list = Arrays.asList(columnGeographyPO.getGeographyImg().split(","));
            ColumnGeographyBO columnGeographyBO = new ColumnGeographyBO();
            columnGeographyBO.setBelongColumnId(columnGeographyPO.getBelongColumnId());
            columnGeographyBO.setDateCreated(columnGeographyPO.getDateCreated());
            columnGeographyBO.setGeographyDetail(columnGeographyPO.getGeographyLevel());
            columnGeographyBO.setGeographyId(columnGeographyPO.getGeographyId());
            columnGeographyBO.setGeographyName(columnGeographyPO.getGeographyName());
            columnGeographyBO.setLastUpdated(columnGeographyPO.getLastUpdated());
            columnGeographyBO.setGeographyLevel(columnGeographyPO.getGeographyLevel());
            columnGeographyBO.setLogicDelete(columnGeographyPO.getLogicDelete());
            columnGeographyBO.setGeographyImg(list);
            return columnGeographyBO;
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    @Transactional
    public int createGeography(ColumnGeographyBO columnGeographyBO) {
        try {
            ColumnGeographyPO columnGeographyPO = new ColumnGeographyPO();
            columnGeographyPO.setBelongColumnId(columnGeographyBO.getBelongColumnId());
            columnGeographyPO.setDateCreated(columnGeographyBO.getDateCreated());
            columnGeographyPO.setGeographyDetail(columnGeographyBO.getGeographyLevel());
            columnGeographyPO.setGeographyId(columnGeographyBO.getGeographyId());
            columnGeographyPO.setGeographyName(columnGeographyBO.getGeographyName());
            columnGeographyPO.setLastUpdated(columnGeographyBO.getLastUpdated());
            columnGeographyPO.setGeographyLevel(columnGeographyBO.getGeographyLevel());
            columnGeographyPO.setLogicDelete(columnGeographyBO.getLogicDelete());
            columnGeographyPO.setGeographyImg(StringUtils.join(columnGeographyBO.getGeographyImg(),","));
            return columnGeographyDAO.createGeography(columnGeographyPO);
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    @Transactional
    public int deleteGeographyById(String columnGeographyId) {
        try {
            int deleteGeographyById = columnGeographyDAO.deleteGeographyById(columnGeographyId);
            return deleteGeographyById;
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    @Transactional
    public int updateGeographyById(ColumnGeographyBO columnGeographyBO) {
        try {
            ColumnGeographyPO columnGeographyPO = new ColumnGeographyPO();
            columnGeographyPO.setBelongColumnId(columnGeographyBO.getBelongColumnId());
            columnGeographyPO.setDateCreated(columnGeographyBO.getDateCreated());
            columnGeographyPO.setGeographyDetail(columnGeographyBO.getGeographyLevel());
            columnGeographyPO.setGeographyId(columnGeographyBO.getGeographyId());
            columnGeographyPO.setGeographyName(columnGeographyBO.getGeographyName());
            columnGeographyPO.setLastUpdated(columnGeographyBO.getLastUpdated());
            columnGeographyPO.setGeographyLevel(columnGeographyBO.getGeographyLevel());
            columnGeographyPO.setLogicDelete(columnGeographyBO.getLogicDelete());
            columnGeographyPO.setGeographyImg(StringUtils.join(columnGeographyBO.getGeographyImg(), ","));
            return columnGeographyDAO.updateGeographyById(columnGeographyPO);
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    public PageDTO<ColumnGeographyBO> findGeographyWithPage(ReceptionQuery receptionQuery, PageDTO pageDTO) {
        try {
            List<ColumnGeographyPO> columnGeographyPOList = columnGeographyDAO.findWithPage(receptionQuery, pageDTO.getOffset(), pageDTO.getMax());
            ArrayList<ColumnGeographyBO> columnGeographyBOList = new ArrayList<>();
            List<String> list = null;
            for (ColumnGeographyPO columnGeographyPO : columnGeographyPOList) {
                if (StringUtils.isNotBlank(columnGeographyPO.getGeographyImg())){
                    list = Arrays.asList(columnGeographyPO.getGeographyImg().split(","));
                }else {

                }
                ColumnGeographyBO columnGeographyBO = new ColumnGeographyBO();
                columnGeographyBO.setBelongColumnId(columnGeographyPO.getBelongColumnId());
                columnGeographyBO.setDateCreated(columnGeographyPO.getDateCreated());
                columnGeographyBO.setGeographyDetail(columnGeographyPO.getGeographyLevel());
                columnGeographyBO.setGeographyId(columnGeographyPO.getGeographyId());
                columnGeographyBO.setGeographyName(columnGeographyPO.getGeographyName());
                columnGeographyBO.setLastUpdated(columnGeographyPO.getLastUpdated());
                columnGeographyBO.setGeographyLevel(columnGeographyPO.getGeographyLevel());
                columnGeographyBO.setLogicDelete(columnGeographyPO.getLogicDelete());
                columnGeographyBO.setGeographyImg(list);
                columnGeographyBOList.add(columnGeographyBO);
            }
            Long totalCount = columnGeographyDAO.findCountWithPage(receptionQuery);
            pageDTO.setPage(columnGeographyBOList, totalCount);
            return pageDTO;
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    public ColumnBO findByColumnId(String columnId) {
        try {
            ColumnPO columnPO = columnDAO.findByColumnId(columnId);
            return BaseUtil.map(columnPO,ColumnBO.class);
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    public ChildColumnBO findByChildColumnId(String childColumnId) {
        try {
            ChildColumnPO childColumnPO = childColumnDAO.findByChildColumnId(childColumnId);
            return BaseUtil.map(childColumnPO,ChildColumnBO.class);
        }catch (Exception e){
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }
    }

    @Override
    public PageDTO<ChildColumnDetailBO> findDetailWithPage(ReceptionQuery receptionQuery, PageDTO pageDTO) {
        List<ChildColumnDetailPO> childColumnDetailPO = childColumnDetailDAO.findWithPage(receptionQuery,pageDTO.getOffset(),pageDTO.getMax());
        List<ChildColumnDetailBO> childColumnDetailBOList = BaseUtil.mapList(childColumnDetailPO,ChildColumnDetailBO.class);
        Long totalCount = childColumnDetailDAO.findCountWithPage(receptionQuery);
        pageDTO.setPage(childColumnDetailBOList,totalCount);
        return pageDTO;
    }


}



