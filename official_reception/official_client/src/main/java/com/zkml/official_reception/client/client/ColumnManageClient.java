package com.zkml.official_reception.client.client;

/**
 * Created by fanghui on 2019/6/17.
 */

import com.zkml.common.obj.dto.PageDTO;
import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.official_reception.client.bo.*;
import com.zkml.official_reception.client.query.ReceptionQuery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 栏目管理相关服务接口
 */
@FeignClient(name = "officialServer")
@RequestMapping("/columnManageClient")
public interface ColumnManageClient {
    /**
     * 查询所有的主题资源
     * @return
     */
    @PostMapping("/findAll")
    ResultModelDTO<List<TitleBO>> findAll();

    /**
     * 查询主题下所有栏目
     * @return
     */
    @PostMapping("/findTitleAndColumn")
    ResultModelDTO<List<TitleBO>> findTitleAndColumn();

    /**
     * 查询同一栏目下所有子栏目
     * @return
     */
    @PostMapping("/findAllByColumnId")
    ResultModelDTO findAllByColumnId(@RequestBody String columnId);

    /**
     * 新增栏目
     * @param columnBO
     * @return
     */
    @PostMapping("/create")
    ResultModelDTO create(@RequestBody ColumnBO columnBO);



    /**
     * 通过id查询主题信息
     * @param titleId
     * @return
     */
    @PostMapping("/findByTitleId")
    ResultModelDTO<TitleBO> findByTitleId(@RequestBody String titleId);

    /**
     * 根据id更新一条记录
     * @param titleBO 记录信息，没填的信息不更新
     * @return 影响的行数 正常为1
     */
    @PostMapping("/updateTitle")
    ResultModelDTO updateTitle(@RequestBody TitleBO titleBO);


    /**
     * 修改子栏目
     * @param childColumnBO
     * @return
     */
    @PostMapping("/updateChildColumnById")
    ResultModelDTO updateChildColumnById(@RequestBody ChildColumnBO childColumnBO);

    /**
     * 删除子栏目
     * @param childColumnId
     * @return
     */
    @PostMapping("/deleteChildColumnById")
    ResultModelDTO deleteChildColumnById(@RequestBody String childColumnId);

    /**
     * 新增子栏目
     * @param childColumnBO
     * @return
     */
    @PostMapping("/createChildColumn")
    ResultModelDTO createChildColumn(@RequestBody ChildColumnBO childColumnBO);

    /**
     * 修改子栏目内容
     * @param childColumnDetailBO
     * @return
     */
    @PostMapping("/updateDetailById")
    ResultModelDTO updateDetailById(@RequestBody ChildColumnDetailBO childColumnDetailBO);

    /**
     * 删除子栏目内容
     * @param childColumnDetailId
     * @return
     */
    @PostMapping("/deleteDetailById")
    ResultModelDTO deleteDetailById(@RequestBody String childColumnDetailId);

    /**
     * 删除子栏目内容
     * @param childColumnDetailBO
     * @return
     */
    @PostMapping("/createDetail")
    ResultModelDTO createDetail(@RequestBody ChildColumnDetailBO childColumnDetailBO);

    /**
     * 根据id查询子栏目内容详情
     * @param childColumnDetailId
     * @return
     */
    @PostMapping("/findByChildColumnDetailId")
    ResultModelDTO findByChildColumnDetailId(@RequestBody String childColumnDetailId);

    /**
     * 根据id更新一条记录
     *
     * @param columnBO 记录信息，没填的信息不更新
     * @return 影响的行数 正常为1
     */
    @PostMapping("/updateColumn")
    ResultModelDTO updateColumn(@RequestBody ColumnBO columnBO);

    /**
     * 山水风光分页列表
     * @param receptionQuery
     * @return
     */
    @PostMapping("/findLandScapeWithPage")
    ResultModelDTO<PageDTO<ColumnLandscapeBO>> findLandScapeWithPage(@RequestBody ReceptionQuery receptionQuery);

    /**
     * 新增山水风光
     * @param columnLandscapeBO
     * @return
     */
    @PostMapping("/createLandscape")
    ResultModelDTO createLandScape(@RequestBody ColumnLandscapeBO columnLandscapeBO);

    /**
     * 删除山水风光
     * @param columnLandscapeId
     * @return
     */
    @PostMapping("/deleteLandscapeById")
    ResultModelDTO deleteLandscapeById(@RequestBody String columnLandscapeId);

    /**
     * 查询山水风光
     * @param columnLandscapeId
     * @return
     */
    @PostMapping("/findByColumnLandscapeId")
    ResultModelDTO<ColumnLandscapeBO> findByColumnLandscapeId(@RequestBody String columnLandscapeId);

    /**
     * 根据id修改一条山水风光记录
     * @param columnLandscapeBO
     * @return
     */
    @PostMapping("/updateLandscapeById")
    ResultModelDTO updateLandscapeById(@RequestBody ColumnLandscapeBO columnLandscapeBO);


    /**
     * 风味美食分页列表
     * @param receptionQuery
     * @return
     */
    @PostMapping("/findFoodWithPage")
    ResultModelDTO findFoodWithPage(@RequestBody ReceptionQuery receptionQuery);

    /**
     * 新增风味美食
     * @param columnFoodBO
     * @return
     */
    @PostMapping("/createFood")
    ResultModelDTO createFood(@RequestBody ColumnFoodBO columnFoodBO);

    /**
     * 根据ID删除风味美食
     * @param columnFoodId
     * @return
     */
    @PostMapping("/deleteFoodById")
    ResultModelDTO deleteFoodById(@RequestBody String columnFoodId);

    /**
     * 根据ID查询风味美食
     * @param columnFoodId
     * @return
             */
    @PostMapping("/findByColumnFoodId")
    ResultModelDTO<ColumnFoodBO> findByColumnFoodId(@RequestBody String columnFoodId);

    /**
     * 修改风味美食
     * @param columnFoodBO
     * @return
     */
    @PostMapping("/updateFoodById")
    ResultModelDTO updateFoodById(@RequestBody ColumnFoodBO columnFoodBO);


    /**
     * 查询自然地理
     * @param columnGeographyId
     * @return
     */
    @PostMapping("/findByColumnGeographyId")
    ResultModelDTO<ColumnGeographyBO> findByColumnGeographyId(@RequestBody String columnGeographyId);

    /**
     * 新增自然地理
     * @param columnGeographyBO
     * @return
     */
    @PostMapping("/createGeography")
    ResultModelDTO createGeography(@RequestBody  ColumnGeographyBO columnGeographyBO);

    /**
     * 删除自然地理
     * @param columnGeographyId
     * @return
     */
    @PostMapping("/deleteGeographyById")
    ResultModelDTO deleteGeographyById(@RequestBody String columnGeographyId);

    /**
     * 修改自然地理
     * @param columnGeographyBO
     * @return
     */
    @PostMapping("/updateGeographyById")
    ResultModelDTO updateGeographyById(@RequestBody ColumnGeographyBO columnGeographyBO);

    /**
     * 自然地理分页列表
     * @param receptionQuery
     * @return
     */
    @PostMapping("/findGeographyWithPage")
    ResultModelDTO findGeographyWithPage(@RequestBody ReceptionQuery receptionQuery);


    /**
     * 根据id查询栏目
     * @param columnId
     * @return
     */
    @PostMapping("/findByColumnId")
    ResultModelDTO<ColumnBO> findByColumnId(@RequestBody String columnId);

    /**
     * 根据id查询子栏目
     * @param childColumnId
     * @return
     */
    @PostMapping("/findByChildColumnId")
    ResultModelDTO<ChildColumnBO> findByChildColumnId(@RequestBody String childColumnId);

    /**
     * 子栏目内容分页列表
     * @param receptionQuery
     * @return
     */
    @PostMapping("/findDetailWithPage")
    ResultModelDTO findDetailWithPage(@RequestBody ReceptionQuery receptionQuery);
}
