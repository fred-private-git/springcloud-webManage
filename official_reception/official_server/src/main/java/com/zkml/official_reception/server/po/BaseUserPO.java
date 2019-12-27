package com.zkml.official_reception.server.po;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by fanghui on 2019/5/21.
 */
@Data
public class BaseUserPO implements Serializable{

    private  String officialLetterId;

    private  String userId;

    private  String userName;

    private  String userSex;

    private  String userJob;

    private  String userTel;

    private  String organName;
}
