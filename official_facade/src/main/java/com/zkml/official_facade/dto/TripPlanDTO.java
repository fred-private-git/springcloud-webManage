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
public class TripPlanDTO implements Serializable{

    private static final long serialVersionUID = -1L;

    @ApiModelProperty(value = "行程信息表的主键id")
    private String tripId;//行程信息表的主键id

    @ApiModelProperty(value = "接待方案号")
    private String receptionLetterId;//接待方案号

    @ApiModelProperty(value = "申请人id")
    private String visitingType;//	到访类型

    @ApiModelProperty(value = "申请人id")
    private String applyUserId;//	申请人id

    @ApiModelProperty(value = "申请人名字")
    private String applyUserName;//		申请人名字

    @ApiModelProperty(value = "流程实例id")
    private String processInstanceId;//流程实例id

    @ApiModelProperty(value = "行程名称")
    private String tripName; //	行程名称

    @ApiModelProperty(value = "接待地点的纬度")
    private String receptionX;//接待地点的纬度

    @ApiModelProperty(value = "接待地点的经度")
    private String receptionY;//接待地点的经度

    @ApiModelProperty(value = "接待时间")
    private Date receptionTime;//	接待时间

    @ApiModelProperty(value = "到访人数")
    private String visitingCount; //到访人数

    @ApiModelProperty(value = "随行人员")
    private String visitingPerson;//随行人员

    @ApiModelProperty(value = "地区号")
    private String areaId;//地区号

    @ApiModelProperty(value = "备注")
    private String remark;//备注

    @ApiModelProperty(value = "审核状态")
    private ReceptionApplyStateEnum auditStatus;//审核状态  ‘UN_APPLY’默认待审核

    @ApiModelProperty(value = "行程制定时间")
    private Date dateCreated;//行程制定时间

    @ApiModelProperty(value = "保存,删除,正常")
    private StatusEnum status;// “TEMP”,”USED”,”DELETE” 保存,删除,正常

    @ApiModelProperty(value = "最后一次修改的时间")
    private Date lastUpdated;//最后一次修改的时间

    @ApiModelProperty(value = "逻辑删除")
    private BooleanEnum logicDelete;//逻辑删除
}
