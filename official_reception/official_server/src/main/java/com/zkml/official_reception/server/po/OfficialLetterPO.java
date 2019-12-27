package com.zkml.official_reception.server.po;

import com.zkml.common.obj.enums.BooleanEnum;
import com.zkml.official_reception.client.enums.ReceptionApplyStateEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fanghui on 2019/5/17.
 *
 */
@Data
public class OfficialLetterPO implements Serializable{
    private static final long serialVersionUID = -1L;

    private String officialLetterId;

    private String tripName;

    private String applyUserOrgan;

    private String applyUserName;

    private String applyUserTel;

    private String officialLetterName;

    private String dispatchedOraganId;

    private Date dateCreated;

    private String dispatchedUserTel;

    private String dispatchedUserName;

    private String dispatchedUserOrgan;

    private String visitingUserId;

    private Integer visitingContactsCount;

    private String visitingEndTime;

    private String visitingStartTime;

    private String visitingDuring;

    private String visitingReason;

    private String attach;

    private String lastUpdated;

    private BooleanEnum logicDelete;

    private ReceptionApplyStateEnum auditStatus;

}
