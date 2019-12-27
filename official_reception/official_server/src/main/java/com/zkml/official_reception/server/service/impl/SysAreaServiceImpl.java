package com.zkml.official_reception.server.service.impl;

import com.zkml.common.obj.enums.DefaultResultCodeEnum;
import com.zkml.official_reception.client.bo.AreaBO;
import com.zkml.official_reception.server.dao.SysAreaDAO;
import com.zkml.official_reception.server.exception.OfficialException;
import com.zkml.official_reception.server.po.AreaPO;
import com.zkml.official_reception.server.service.SysAreaService;
import com.zkml.official_reception.server.util.BaseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fanghui on 2019/5/6.
 */
@Slf4j
@Service
public class SysAreaServiceImpl implements SysAreaService {

    @Autowired
    SysAreaDAO sysAreaDAO;

    @Override
    public List<AreaBO> findAreaById(String areaId) {

        try {
            List<AreaPO> findAreaById = sysAreaDAO.findAreaById(areaId);
            List<AreaBO> areaBOList = BaseUtil.mapList(findAreaById,AreaBO.class);
            return areaBOList;
        }catch (Exception e){
            log.error("【查询地区】查询地区失败",e);
            throw  new OfficialException(DefaultResultCodeEnum.FAIL);
        }

    }
}
