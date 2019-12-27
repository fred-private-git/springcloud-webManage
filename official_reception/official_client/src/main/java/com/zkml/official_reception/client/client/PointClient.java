package com.zkml.official_reception.client.client;

/**
 * Created by fanghui on 2019/5/14.
 */

import com.zkml.common.obj.dto.PageDTO;
import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.official_reception.client.bo.HotelBO;
import com.zkml.official_reception.client.bo.PointBO;
import com.zkml.official_reception.client.query.ReceptionQuery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 视察点相关服务接口
 */
@FeignClient(name = "officialServer")
@RequestMapping("/pointClient")
public interface PointClient {
    /**
     * 查询某个省份下所有的视察点统计
     * @return
     */
    @PostMapping("/pointCountByAreaId")
    ResultModelDTO pointCountByAreaId(@RequestBody String areaId);
    /**
     * 每个省下各个地级市的接待点统计
     * @param areaId
     * @return
     */
    @PostMapping("/findTotalByAreaId")
    ResultModelDTO findTotalByAreaId(@RequestBody String areaId);
    /**
     * 根据areaId统计这个地级市的酒店数量
     * @param areaId
     * @return
     */
    @PostMapping("/findByAreaId")
    ResultModelDTO findByAreaId(@RequestBody String areaId);
    /**
     * 视察点分页列表查询
     * @param receptionQuery
     * @return
     */
    @PostMapping("/findWithPage")
    ResultModelDTO<PageDTO> findWithPage(@RequestBody ReceptionQuery receptionQuery);
    /**
     * 根据inspectionPointInfoId查找
     * @param inspectionPointInfoId
     * @return PointPO
     */
    @PostMapping("/findByInspectionPointInfoId")
    ResultModelDTO findByInspectionPointInfoId(@RequestBody  String inspectionPointInfoId);
    /**
     * 根据hotelInfoId查找
     * @param areaId
     * @return ResultModelDTO
     */
    @PostMapping("/findWithOutPage")
    ResultModelDTO<List<PointBO>> findWithOutPage(@RequestBody  String areaId);
}
