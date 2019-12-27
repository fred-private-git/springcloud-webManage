package com.zkml.official_reception.server.service;

import com.zkml.common.obj.dto.PageDTO;
import com.zkml.official_reception.client.bo.*;
import com.zkml.official_reception.client.query.ReceptionQuery;

import java.util.List;
import java.util.Map;

/**
 * Created by fanghui on 2019/6/17.
 */
public interface ColumnManageService {
    /**
     * 查询所有的主题
     * @return TitlePO
     */
    List<TitleBO> findAll();

    /**
     * 查询主题下所有栏目
     * @return
     */
    List<TitleBO> findTitleAndColumn();

    /**
     * 查询同一栏目下所有子栏目
     * @return
     */
    Map findAllByColumnId(String columnId);

    /**
     * 新增栏目
     * @param columnBO
     * @return
     */
    int create(ColumnBO columnBO);

    /**
     * 通过id查询主题信息
     * @param titleId
     * @return
     */
    TitleBO findByTitleId(String titleId);

    /**
     * 根据id更新一条记录
     * @param titleBO 记录信息，没填的信息不更新
     * @return 影响的行数 正常为1
     */
    int updateTitle(TitleBO titleBO);

    /**
     * 修改子栏目
     * @param childColumnPO
     * @return
     */
    int updateChildColumnById(ChildColumnBO childColumnPO);

    /**
     * 删除子栏目
     * @param childColumnId
     * @return
     */
    int deleteChildColumnById(String childColumnId);

    /**
     * 新增子栏目
     * @param childColumnBO
     * @return
     */
    int createChildColumn(ChildColumnBO childColumnBO);

    /**
     * 新增子栏目内容
     * @param childColumnDetailBO
     * @return
     */
    int createDetail(ChildColumnDetailBO childColumnDetailBO);

    /**
     * 修改子栏目内容
     * @param childColumnDetailBO
     * @return
     */
    int updateDetailById(ChildColumnDetailBO childColumnDetailBO);

    /**
     * 删除子栏目内容
     * @param childColumnDetailId
     * @return
     */
    int deleteDetailById(String childColumnDetailId);

    /**
     * 查询子栏目内容
     * @param childColumnDetailId
     * @return
     */

    ChildColumnDetailBO findByChildColumnDetailId(String childColumnDetailId);
    /**
     * 根据id更新一条记录
     * @param columnBO 记录信息，没填的信息不更新
     * @return 影响的行数 正常为1
     */
    int updateColumn(ColumnBO columnBO);


    /**
     * 山水风光分页列表
     * @param receptionQuery
     * @return
     */
    PageDTO<ColumnLandscapeBO> findLandScapeWithPage(ReceptionQuery receptionQuery, PageDTO pageDTO);


    /**
     * 新增山水风光
     * @param columnLandscapeBO
     * @return
     */
    int createLandscape(ColumnLandscapeBO columnLandscapeBO);


    /**
     * 删除山水风光
     * @param columnLandscapeId
     * @return
     */
     int deleteLandscapeById(String columnLandscapeId);

    /**
     * 查询山水风光
     * @param columnLandscapeId
     * @return
     */
    ColumnLandscapeBO findByColumnLandscapeId(String columnLandscapeId);

    /**
     * 根据id修改一条山水风光记录
     * @param columnLandscapeBO
     * @return
     */
    int updateLandscapeById(ColumnLandscapeBO columnLandscapeBO);



    /**
     * 风味美食分页列表
     * @param receptionQuery
     * @return
     */
    PageDTO<ColumnFoodBO> findFoodWithPage(ReceptionQuery receptionQuery, PageDTO pageDTO);


    /**
     * 新增风味美食
     * @param columnLandscapeBO
     * @return
     */
    int createFood(ColumnFoodBO columnLandscapeBO);


    /**
     * 删除一条风味美食记录
     * @param columnFoodId
     * @return
     */
    int deleteFoodById(String columnFoodId);

    /**
     * 查询风味美食
     * @param columnFoodId
     * @return
     */
    ColumnFoodBO findByColumnFoodId(String columnFoodId);

    /**
     * 根据id修改一条风味美食记录
     * @param columnFoodBO
     * @return
     */
    int updateFoodById(ColumnFoodBO columnFoodBO);



    /**
     * 查询自然地理
     * @param columnGeographyId
     * @return
     */
    ColumnGeographyBO findByColumnGeographyId(String columnGeographyId);

    /**
     * 新增自然地理
     * @param columnGeographyBO
     * @return
     */
    int createGeography(ColumnGeographyBO columnGeographyBO);

    /**
     * 删除自然地理
     * @param columnGeographyId
     * @return
     */
    int deleteGeographyById(String columnGeographyId);

    /**
     * 修改自然地理
     * @param columnGeographyBO
     * @return
     */
    int updateGeographyById(ColumnGeographyBO columnGeographyBO);

    /**
     * 查询自然地理
     * @param receptionQuery
     * @param pageDTO
     * @return
     */
    PageDTO<ColumnGeographyBO> findGeographyWithPage(ReceptionQuery receptionQuery, PageDTO pageDTO);

    /**
     * 查询栏目
     * @param columnId
     * @return
     */
    ColumnBO findByColumnId(String columnId);

    /**
     * 查询子栏目
     * @param childColumnId
     * @return
     */
    ChildColumnBO findByChildColumnId(String childColumnId);

    /**
     * 子栏目内容分页列表
     * @param receptionQuery
     * @param pageDTO
     * @return
     */
    PageDTO<ChildColumnDetailBO> findDetailWithPage(ReceptionQuery receptionQuery, PageDTO pageDTO);
}
