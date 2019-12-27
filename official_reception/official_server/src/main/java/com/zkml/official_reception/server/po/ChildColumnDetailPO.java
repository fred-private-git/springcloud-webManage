package com.zkml.official_reception.server.po;

import com.zkml.common.obj.enums.BooleanEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author fanghui
 * @date 2019-06-17 13:46:36
 */
@Data
public class ChildColumnDetailPO  implements Serializable {

	private static final long serialVersionUID = -1L;
	
    private String childColumnDetailId;

    private String childColumnDetailName;

    private String belongChildColumnId;

    private String briefIntroduction;

    private String childColumnDetail;

    private String attachImg;

    private Date dateCreated;

    private Date lastUpdated;

	private String logicDelete;
}