package com.zkml.official_facade.dto;

import com.zkml.common.obj.enums.BooleanEnum;
import com.zkml.official_reception.client.enums.ReceptionApplyStateEnum;
import com.zkml.official_reception.client.enums.StatusEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fanghui on 2019/5/17.
 */
@Data
public class ReceptionLetterDTO implements Serializable{

    private static final long serialVersionUID = -1L;

    @ApiModelProperty(value = "接待方案号")
    private String receptionLetterId;//接待方案号

    @ApiModelProperty(value = "接待方案名称")
    private String receptionLetterName;//接待方案名称

    @ApiModelProperty(value = "派出单位")
    private String dispatchedOrgan;//派出单位

    @ApiModelProperty(value = "申请人id")
    private String applyUserId;//申请人id

    @ApiModelProperty(value = "申请人名字")
    private String applyUserName;//申请人名字

    @ApiModelProperty(value = "流程实例id")
    private String processInstanceId;//流程实例id

    @ApiModelProperty(value = "来访类型")
    private String visitingType;//来访类型

    @ApiModelProperty(value = "派出单位联系人名字")
    private String dispatchedOrganLinkmanName;//派出单位联系人名字

    @ApiModelProperty(value = "派出单位联系人的职务")
    private String dispatchedOrganLinkmanDuty;//派出单位联系人的职务

    @ApiModelProperty(value = "派出单位联系人电话")
    private String dispatchedOrganLinkmanTel;//派出单位联系人电话

    @ApiModelProperty(value = "来访开始时间")
    private Date visitingStartTime;//来访开始时间

    @ApiModelProperty(value = "来访结束时间")
    private Date visitingEndTime;//来访结束时间

    @ApiModelProperty(value = "来访人数")
    private String visitingCount;//来访人数

    @ApiModelProperty(value = "来访时长")
    private String visitingDuring;//来访时长

    @ApiModelProperty(value = "接待单位联系人姓名")
    private String receptionOrganLinkmanName;//接待单位联系人姓名

    @ApiModelProperty(value = "单位联系人电话")
    private String receptionOrganLinkmanTel;//单位联系人电话

    @ApiModelProperty(value = "接待单位联系人的职务")
    private String receptionOrganLinkmanDuty;//接待单位联系人的职务

    @ApiModelProperty(value = "接待级别")
    private String receptionLevel;//接待级别

    @ApiModelProperty(value = "是否涉密")
    private String booleanSecret;//	是否涉密

    @ApiModelProperty(value = "上传公函附件URL")
    private String attachmentURL;//上传公函附件URL

    @ApiModelProperty(value = "公函文件号(自动生成)")
    private String officialLetterId;//公函文件号(自动生成)

    @ApiModelProperty(value = "备注")
    private String remark;//备注

    @ApiModelProperty(value = "审核状态  ‘UN_APPLY’")
    private ReceptionApplyStateEnum auditStatus;//审核状态  ‘UN_APPLY’

    @ApiModelProperty(value = "保存,删除,正常")
    private StatusEnum status;// “TEMP”,”USED”,”DELETE” 保存,删除,正常

    @ApiModelProperty(value = "接待方案制作时间")
    private Date dateCreated;//	接待方案制作时间

    @ApiModelProperty(value = "最后一次修改的时间")
    private Date lastUpdated;//	最后一次修改的时间

    @ApiModelProperty(value = "逻辑删除")
    private BooleanEnum logicDelete;//逻辑删除
}
