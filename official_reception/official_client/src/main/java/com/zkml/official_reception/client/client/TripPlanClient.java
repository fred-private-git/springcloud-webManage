package com.zkml.official_reception.client.client;

/**
 * Created by fanghui on 2019/5/21.
 */

import com.zkml.common.obj.dto.PageDTO;
import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.official_reception.client.bo.TripPreviewBO;
import com.zkml.official_reception.client.query.ReceptionQuery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 行程预览相关服务接口
 */
@FeignClient(name = "officialServer")
@RequestMapping("/tripPlanClient")
public interface TripPlanClient {

    /**
     * 行程预览的新建
     * @return
     */
    @PostMapping("/createTrip")
    ResultModelDTO createTrip(@RequestBody TripPreviewBO tripPreviewBO);

    /**
     * 行程预览的修改
     * @return
     */
    @PostMapping("/updateTrip")
    ResultModelDTO updateTrip(@RequestBody TripPreviewBO tripPreviewBO);

//    /**
//     * 行程分页列表查询
//     * @param receptionQuery
//     * @return
//     */
//    @PostMapping("/findWithPage")
//    ResultModelDTO<PageDTO> findWithPage(@RequestBody ReceptionQuery receptionQuery);
//
//    /**
//     * 行程预览的删除
//     * @return
//     */
//    @PostMapping("/deleteByTripId")
//    ResultModelDTO deleteByTripId(@RequestBody String tripId);
//
//    /**
//     * 根据公函号查询信息
//     * @param officialLetterId
//     * @return
//     */
//    @PostMapping("/findOfficialLetterById")
//    ResultModelDTO findOfficialLetterById(@RequestBody String officialLetterId);
//
    /**
     * 省级联动
     * @return
     */
    @PostMapping("/areaTree")
    ResultModelDTO areaTree();

    /**
     * 通用版的工具类关于List<Map>树结构的接口
     * @return
     */
    @PostMapping("/menuTree")
    List<Object> menuTree();
}
