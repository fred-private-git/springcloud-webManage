package com.zkml.official_reception.server.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author fanghui
 * @date 2019-06-17 13:40:15
 */
@Data
public class ChildColumnPO  implements Serializable {

	private static final long serialVersionUID = -1L;
	
	/**
	 *  子栏目id
	 */
    private String childColumnId;

	/**
	 *  子栏目名称
	 */
	private String childColumnName;

	/**
	 *  所属栏目id
	 */
    private String belongColumnId;

    private Date dateCreated;

    private Date lastUpdated;

    private String logicDelete;
	
}