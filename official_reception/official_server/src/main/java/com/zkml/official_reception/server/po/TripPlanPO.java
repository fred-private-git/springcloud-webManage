package com.zkml.official_reception.server.po;

import com.zkml.common.obj.enums.BooleanEnum;
import com.zkml.official_reception.client.enums.ReceptionApplyStateEnum;
import com.zkml.official_reception.client.enums.StatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fanghui on 2019/5/17.
 */
@Data
public class TripPlanPO implements Serializable{

    /**
     *行程信息表的主键id
     */
    private String tripId;

    /**
     *接待方案号
     */
    private String receptionLetterId;

    /**
     *到访类型
     */
    private String visitingType;

    /**
     *申请人id
     */
    private String applyUserId;

    /**
     *申请人名字
     */
    private String applyUserName;

    /**
     *流程实例id
     */
    private String processInstanceId;

    /**
     *行程名称
     */
    private String tripName;

    /**
     *接待地点的纬度
     */
    private String receptionX;

    /**
     *接待地点的经度
     */
    private String receptionY;

    /**
     *接待时间
     */
    private Date receptionTime;

    /**
     *到访人数
     */
    private String visitingCount;

    /**
     *随行人员
     */
    private String visitingPerson;

    /**
     *地区号
     */
    private String areaId;

    /**
     *备注
     */
    private String remark;

    /**
     *审核状态  ‘UN_APPLY’默认待审核
     */
    private ReceptionApplyStateEnum auditStatus;

    /**
     *行程制定时间
     */
    private Date dateCreated;

    /**
     * “TEMP”,”USED”,”DELETE” 保存,删除,正常
     */
    private StatusEnum status;

    /**
     *最后一次修改的时间
     */
    private Date lastUpdated;

    /**
     *逻辑删除
     */
    private BooleanEnum logicDelete;

}
