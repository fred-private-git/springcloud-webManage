package com.zkml.official_reception.client.enums;

import com.zkml.common.obj.dto.ResultCode;

/**
 * Created by fanghui on 2019/4/23.
 */
public enum CustResultCodeEnum implements ResultCode {

    //定义用户服务code数值段为10000-19999

    IMAGE_SUCCESS(10001L,"图片上传成功！"),

    START_ERROR(10002L,"启用失败！"),

    START_SUCCESS(10003L,"启用成功！"),

    BAN_SUCCESS(10004L,"禁用成功！"),

    BAN_ERROR(10005L, "禁用失败！"),

    IMAGE_ERROR(10006L,"图片上传失败！"),

    ALLOT_DEPARTMENT_ERROR(10007L,"分配部门失败！"),

    GET_TOKEN_ERROR(10008L,"获取七牛云上传凭证错误！"),

    GET_TOKEN_SUCCESS(10009L,"获取七牛云上传凭证成功！");

    //public final static String PRE_CODE = "ORDER_";

    private long code;

    private  String message;

    CustResultCodeEnum(long code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return 0;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
