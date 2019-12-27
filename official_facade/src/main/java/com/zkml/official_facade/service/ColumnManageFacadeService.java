package com.zkml.official_facade.service;

import com.zkml.common.obj.dto.PageDTO;
import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.official_facade.dto.*;
import com.zkml.official_reception.client.bo.ColumnLandscapeBO;
import com.zkml.official_reception.client.query.ReceptionQuery;

import java.util.List;

/**
 * Created by fanghui on 2019/6/17.
 */
public interface ColumnManageFacadeService {

    /**
     * 查询所有的主题
     * @return ResultModelDTO
     */
    ResultModelDTO<List<TitleDTO>> findAll();

    /**
     * 查询主题下所有的栏目
     * @return
     */
    ResultModelDTO<List<TitleDTO>> findTitleAndColumn();

    /**
     * 查询同一栏目下所有子栏目
     * @return
     */
    ResultModelDTO findAllByColumnId(String columnId);
    /**
     * 新增栏目
     * @param columnDTO
     * @return
     */
    ResultModelDTO create(ColumnDTO columnDTO);



    /**
     * 通过id查询主题信息
     * @param titleId
     * @return
     */
    ResultModelDTO<TitleDTO> findByTitleId(String titleId);
    /**
     * 根据id更新一条记录
     * @param titleDTO 记录信息，没填的信息不更新
     * @return 影响的行数 正常为1
     */
    ResultModelDTO updateTitle(TitleDTO titleDTO);
    /**
     * 根据id更新一条记录
     *
     * @param columnDTO 记录信息，没填的信息不更新
     * @return 影响的行数 正常为1
     */
    ResultModelDTO updateColumn(ColumnDTO columnDTO);


    /**
     * 子栏目的新增，修改，删除
     * @param childColumnDTO
     * @param flag
     * @return
     */
    ResultModelDTO childColumnModify(ChildColumnDTO childColumnDTO,String flag);

    /**
     * 子栏目内容的新增，修改，删除
     * @param childColumnDetailDTO
     * @param flag
     * @return
     */
    ResultModelDTO childColumnDetailModify(ChildColumnDetailDTO childColumnDetailDTO,String flag);

    /**
     * 根据id查询子栏目内容详情
     * @param childColumnDetailId
     * @return
     */
    ResultModelDTO<ChildColumnDetailDTO> findByChildColumnDetailId(String childColumnDetailId);

    /**
     * 栏目--山水,美食,地理分页列表展示
     * @param receptionQuery
     * @return
     */
    ResultModelDTO findWithPage(ReceptionQuery receptionQuery,String flag);

    /**
     * 新增,修改,删除山水风光
     * @param columnLandscapeDTO
     * @return
     */
    ResultModelDTO landscapeModify(ColumnLandscapeDTO columnLandscapeDTO,String flag);



    /**
     * 根据Id查询山水风光,风味美食,自然地理
     * @param pId
     * @return
     */
    ResultModelDTO findById(String pId,String flag);


    /**
     * 新增,修改,删除风味美食
     * @param columnFoodDTO
     * @return
     */
    ResultModelDTO foodModify(ColumnFoodDTO columnFoodDTO,String flag);


    /**
     * 新增,修改,删除自然地理
     * @param columnGeographyDTO
     * @return
     */
    ResultModelDTO geographyModify(ColumnGeographyDTO columnGeographyDTO,String flag);


    /**
     * 栏目回显
     * @param columnId
     * @return
     */
    ResultModelDTO<ColumnDTO> findByColumnId(String columnId);


    /**
     * 根据id查询子栏目
     * @param childColumnId
     * @return
     */
    ResultModelDTO<ChildColumnDTO> findByChildColumnId(String childColumnId);

    /**
     * 子栏目内容分页列表
     * @param receptionQuery
     * @return
     */
    ResultModelDTO findDetailWithPage(ReceptionQuery receptionQuery);
}
