package com.zkml.official_reception.server.po;

import lombok.Data;

import java.util.List;

/**
 * Created by fanghui on 2019/5/31.
 */
@Data
public class AreaTreePO {

    private String areaId;

    private String areaName;

    private List children;
}
