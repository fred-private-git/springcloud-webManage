package com.zkml.official_reception.client.bo;

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
public class ReceptionLetterBO implements Serializable{

    /**
     * 接待方案号
     */
    private String receptionLetterId;

    /**
     * 接待方案名称
     */
    private String receptionLetterName;

    /**
     * 派出单位
     */
    private String dispatchedOrgan;

    /**
     * 申请人id
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
     *来访类型
     */
    private String visitingType;

    /**
     *派出单位联系人名字
     */
    private String dispatchedOrganLinkmanName;

    /**
     *派出单位联系人的职务
     */
    private String dispatchedOrganLinkmanDuty;

    /**
     *派出单位联系人电话
     */
    private String dispatchedOrganLinkmanTel;

    /**
     *来访开始时间
     */
    private Date visitingStartTime;

    /**
     *来访结束时间
     */
    private Date visitingEndTime;

    /**
     *来访人数
     */
    private String visitingCount;

    /**
     *来访时长
     */
    private String visitingDuring;

    /**
     *接待单位联系人姓名
     */
    private String receptionOrganLinkmanName;

    /**
     *单位联系人电话
     */
    private String receptionOrganLinkmanTel;

    /**
     *接待单位联系人的职务
     */
    private String receptionOrganLinkmanDuty;

    /**
     *接待级别
     */
    private String receptionLevel;

    /**
     *是否涉密
     */
    private String booleanSecret;

    /**
     *上传公函附件URL
     */
    private String attachmentURL;

    /**
     *公函文件号(自动生成)
     */
    private String officialLetterId;

    /**
     *备注
     */
    private String remark;

    /**
     *审核状态  ‘UN_APPLY’
     */
    private ReceptionApplyStateEnum auditStatus;

    /**
     *“TEMP”,”USED”,”DELETE” 保存,删除,正常
     */
    private StatusEnum status;

    /**
     *接待方案制作时间
     */
    private Date dateCreated;

    /**
     *最后一次修改的时间
     */
    private Date lastUpdated;

    /**
     *逻辑删除
     */
    private BooleanEnum logicDelete;}
