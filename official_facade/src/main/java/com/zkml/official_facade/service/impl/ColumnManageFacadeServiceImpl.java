package com.zkml.official_facade.service.impl;

import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.common.obj.util.ResultModelUtil;
import com.zkml.official_facade.dto.*;
import com.zkml.official_facade.exception.OfficialException;
import com.zkml.official_facade.service.ColumnManageFacadeService;
import com.zkml.official_facade.util.BaseUtil;
import com.zkml.official_reception.client.bo.*;
import com.zkml.official_reception.client.client.ColumnManageClient;
import com.zkml.official_reception.client.query.ReceptionQuery;
import jdk.nashorn.internal.ir.CatchNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fanghui on 2019/6/17.
 */
@Service
@Slf4j
public class ColumnManageFacadeServiceImpl implements ColumnManageFacadeService{

    @Autowired
    ColumnManageClient columnManageClient;

    @Override
    public ResultModelDTO<List<TitleDTO>>  findAll() {
        try {
            ResultModelDTO<List<TitleBO>> resultModelDTO = columnManageClient.findAll();
            List<TitleDTO> listResultModelDTO = BaseUtil.mapList(resultModelDTO.getModel(), TitleDTO.class);
            return ResultModelUtil.successResult(listResultModelDTO);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO<List<TitleDTO>> findTitleAndColumn() {
        try {
            ResultModelDTO<List<TitleBO>> resultModelDTO = columnManageClient.findTitleAndColumn();
            List<TitleDTO> listResultModelDTO = BaseUtil.mapList(resultModelDTO.getModel(), TitleDTO.class);
            return ResultModelUtil.successResult(listResultModelDTO);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO findAllByColumnId(String columnId) {
        try {
            ResultModelDTO resultModelDTO = columnManageClient.findAllByColumnId(columnId);
            return ResultModelUtil.successResult(resultModelDTO);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO create(ColumnDTO columnDTO) {
        try {
            ResultModelDTO resultModelDTO = columnManageClient.create(BaseUtil.map(columnDTO, ColumnBO.class));
            return ResultModelUtil.successResult(resultModelDTO);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }



    @Override
    public ResultModelDTO<TitleDTO> findByTitleId(String titleId) {
        try {
            ResultModelDTO<TitleBO> titleBO = columnManageClient.findByTitleId(titleId);
            return ResultModelUtil.successResult(BaseUtil.map(titleBO.getModel(),TitleDTO.class));
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO updateTitle(TitleDTO titleDTO) {
        try {
            ResultModelDTO resultCode = columnManageClient.updateTitle(BaseUtil.map(titleDTO,TitleBO.class));
            return resultCode;
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO updateColumn(ColumnDTO columnDTO) {
        try {
            ResultModelDTO resultCode = columnManageClient.updateColumn(BaseUtil.map(columnDTO,ColumnBO.class));
            return resultCode;
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO childColumnModify(ChildColumnDTO childColumnDTO,String flag) {
        if ("CREATE".equals(flag)) {
            try {
                ResultModelDTO resultModelDTO = columnManageClient.createChildColumn(BaseUtil.map(childColumnDTO, ChildColumnBO.class));
                return ResultModelUtil.successResult(resultModelDTO);
            } catch (OfficialException officialException) {
                return ResultModelUtil.failResult(officialException);
            }
        } else if ("UPDATE".equals(flag)) {
            try {
                ResultModelDTO resultModelDTO = columnManageClient.updateChildColumnById(BaseUtil.map(childColumnDTO, ChildColumnBO.class));
                return ResultModelUtil.successResult(resultModelDTO);
            } catch (OfficialException officialException) {
                return ResultModelUtil.failResult(officialException);
            }
        } else if ("DELETE".equals(flag)) {
            try {
                return columnManageClient.deleteChildColumnById(childColumnDTO.getChildColumnId());
            } catch (OfficialException officialException) {
                return ResultModelUtil.failResult(officialException);
            }
        }
             return null;
    }

    @Override
    public ResultModelDTO childColumnDetailModify(ChildColumnDetailDTO childColumnDetailDTO,String flag) {
        if ("CREATE".equals(flag)) {
            try {
                ResultModelDTO resultModelDTO = columnManageClient.createDetail(BaseUtil.map(childColumnDetailDTO, ChildColumnDetailBO.class));
                return ResultModelUtil.successResult(resultModelDTO);
            } catch (OfficialException officialException) {
                return ResultModelUtil.failResult(officialException);
            }
        } else if ("UPDATE".equals(flag)) {
            try {
                ResultModelDTO resultModelDTO = columnManageClient.updateDetailById(BaseUtil.map(childColumnDetailDTO,ChildColumnDetailBO.class));
                return ResultModelUtil.successResult(resultModelDTO);
            } catch (OfficialException officialException) {
                return ResultModelUtil.failResult(officialException);
            }
        } else if ("DELETE".equals(flag)) {
            try {
                return columnManageClient.deleteDetailById(childColumnDetailDTO.getChildColumnDetailId());
            } catch (OfficialException officialException) {
                return ResultModelUtil.failResult(officialException);
            }
        }
             return null;
    }



    @Override
    public ResultModelDTO<ChildColumnDetailDTO> findByChildColumnDetailId(String childColumnDetailId) {
        try {
            ResultModelDTO<ChildColumnDetailBO> childColumnDetailBO = columnManageClient.findByChildColumnDetailId(childColumnDetailId);
            return ResultModelUtil.successResult(BaseUtil.map(childColumnDetailBO.getModel(),ChildColumnDetailDTO.class));
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO findWithPage(ReceptionQuery receptionQuery,String flag) {
        try {
            if("山水风光".equals(flag)){
                return columnManageClient.findLandScapeWithPage(receptionQuery);
            }else if ("风味美食".equals(flag)){
                return columnManageClient.findFoodWithPage(receptionQuery);
            }else if ("自然地理".equals(flag)){
                return columnManageClient.findGeographyWithPage(receptionQuery);
            }
                return null;
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO landscapeModify(ColumnLandscapeDTO columnLandscapeDTO,String flag) {
        try {
            if("CREATE".equals(flag)){
                return columnManageClient.createLandScape(BaseUtil.map(columnLandscapeDTO, ColumnLandscapeBO.class));
            }else if ("UPDATE".equals(flag)){
                return columnManageClient.updateLandscapeById(BaseUtil.map(columnLandscapeDTO,ColumnLandscapeBO.class));
            }else if ("DELETE".equals(flag)){
                return columnManageClient.deleteLandscapeById(columnLandscapeDTO.getColumnLandscapeId());
            }
            return null;
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }



    @Override
    public ResultModelDTO findById(String pId,String flag) {
        try {
            if("山水风光".equals(flag)){
                ResultModelDTO columnLandscapeBO = columnManageClient.findByColumnLandscapeId(pId);
                return ResultModelUtil.successResult(BaseUtil.map(columnLandscapeBO.getModel(),ColumnLandscapeDTO.class));
            }else if ("风味美食".equals(flag)){
                ResultModelDTO columnFoodBO = columnManageClient.findByColumnFoodId(pId);
                return ResultModelUtil.successResult(BaseUtil.map(columnFoodBO.getModel(),ColumnFoodDTO.class));
            }else if ("自然地理".equals(flag)){
                ResultModelDTO columnGeographyBO = columnManageClient.findByColumnGeographyId(pId);
                return ResultModelUtil.successResult(BaseUtil.map(columnGeographyBO.getModel(),ColumnGeographyDTO.class));
            }
            return null;

        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }



    @Override
    public ResultModelDTO foodModify(ColumnFoodDTO columnFoodDTO,String flag) {
        try {
            if("CREATE".equals(flag)){
                return columnManageClient.createFood(BaseUtil.map(columnFoodDTO, ColumnFoodBO.class));
            }else if ("UPDATE".equals(flag)){
                return columnManageClient.updateFoodById(BaseUtil.map(columnFoodDTO,ColumnFoodBO.class));
            }else if ("DELETE".equals(flag)){
                return columnManageClient.deleteFoodById(columnFoodDTO.getColumnFoodId());
            }
            return null;
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }



    @Override
    public ResultModelDTO geographyModify(ColumnGeographyDTO columnGeographyDTO,String flag) {
            try {
                if("CREATE".equals(flag)){
                    return columnManageClient.createGeography(BaseUtil.map(columnGeographyDTO, ColumnGeographyBO.class));
                }else if ("UPDATE".equals(flag)){
                    return columnManageClient.updateGeographyById(BaseUtil.map(columnGeographyDTO,ColumnGeographyBO.class));
                }else if ("DELETE".equals(flag)){
                    return columnManageClient.deleteGeographyById(columnGeographyDTO.getGeographyId());
                }
                return null;
            }catch (OfficialException officialException){
                return ResultModelUtil.failResult(officialException);
            }
    }

    @Override
    public ResultModelDTO<ColumnDTO> findByColumnId(String columnId) {
        try {
            ResultModelDTO<ColumnBO> columnBO = columnManageClient.findByColumnId(columnId);
            return ResultModelUtil.successResult(BaseUtil.map(columnBO.getModel(),ColumnDTO.class));
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO<ChildColumnDTO> findByChildColumnId(String childColumnId) {
        try {
            ResultModelDTO<ChildColumnBO> childColumnBO = columnManageClient.findByChildColumnId(childColumnId);
            return ResultModelUtil.successResult(BaseUtil.map(childColumnBO.getModel(),ChildColumnDTO.class));
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    @Override
    public ResultModelDTO findDetailWithPage(ReceptionQuery receptionQuery) {
        try {
            return columnManageClient.findDetailWithPage(receptionQuery);

        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }


}
