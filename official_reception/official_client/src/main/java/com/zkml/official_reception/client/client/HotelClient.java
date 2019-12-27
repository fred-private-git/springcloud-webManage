package com.zkml.official_reception.client.client;

import com.zkml.common.obj.dto.PageDTO;
import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.official_reception.client.bo.HotelBO;
import com.zkml.official_reception.client.query.ReceptionQuery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by fanghui on 2019/5/6.
 */

/**
 * 酒店相关服务接口
 */
@FeignClient(name = "officialServer")
@RequestMapping("/hotelClient")
public interface HotelClient {
    /**
     * 查询某个省份下所有的接待酒店总数
     * @return
     */
    @PostMapping("/hotelCountByAreaId")
    ResultModelDTO hotelCountByAreaId(@RequestBody String areaId);
    /**
     * 每个省下各个地级市的接待点统计
     * @param areaId
     * @return
     */
    @PostMapping("/findTotalByAreaId")
    ResultModelDTO findTotalByAreaId(@RequestBody String areaId);
//    /**
//     * 每个地级市 酒店、视察点、会议室的统计
//     * @param pId
//     * @return
//     */
//    @PostMapping("/findTotalGroupByAreaId")
//    List findTotalGroupByAreaId(@RequestBody String pId);
    /**
     * 根据areaId统计这个地级市的酒店数量
     * @param areaId
     * @return
     */
    @PostMapping("/findByAreaId")
    ResultModelDTO findByAreaId(@RequestBody String areaId);
    /**
     * 酒店分页列表查询
     * @param receptionQuery
     * @return
     */
    @PostMapping("/findWithPage")
    ResultModelDTO<PageDTO> findWithPage(@RequestBody ReceptionQuery receptionQuery);
    /**
     * 根据hotelInfoId查找
     * @param hotelInfoId
     * @return ResultModelDTO
     */
    @PostMapping("/findByHotelInfoId")
    ResultModelDTO findByHotelInfoId(@RequestBody  String hotelInfoId);
    /**
     * 根据hotelInfoId查找
     * @param areaId
     * @return ResultModelDTO
     */
    @PostMapping("/findWithOutPage")
    ResultModelDTO<List<HotelBO>> findWithOutPage(@RequestBody  String areaId);
}
