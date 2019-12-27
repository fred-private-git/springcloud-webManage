package com.zkml.official_reception.client.client;

/**
 * Created by fanghui on 2019/5/6.
 */

import com.zkml.common.obj.dto.PageDTO;
import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.official_reception.client.bo.AreaBO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 查询地区号服务接口
 */
@FeignClient(name = "officialServer")
@RequestMapping("/sysAreaClient")
public interface SysAreaClient {
    /**
     * 查询地区信息
     * @param areaId
     * @return
     */
    @PostMapping("/findAreaById")
    ResultModelDTO<List<AreaBO>> findAreaById(@RequestBody String areaId);
}
