package com.zkml.official_reception.server.po;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author zhouyang
 * @date 2019-05-06 11:06:21
 */

@Data
public class AreaPO  implements Serializable {

	private static final long serialVersionUID = -1L;
	
    private String areaId;

    private String areaName;

    private int level;

    private String parentId;

    private Integer sortNo;

}