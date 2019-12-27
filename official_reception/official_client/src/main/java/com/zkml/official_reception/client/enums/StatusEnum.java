package com.zkml.official_reception.client.enums;

import java.util.EnumSet;
import java.util.Iterator;

/**
 * Created by fanghui on 2019/4/17.
 */
public enum StatusEnum {
    TEMP("保存状态"),

    DELETE("删除状态"),

    USED("正常状态");


    /**
     * 枚举Set,包含本枚举的所以实例
     */
    private static EnumSet<StatusEnum> enumSet = EnumSet.allOf(StatusEnum.class);

    /**
     * 描述
     */
    private String description;

    /**
     * 获取文字描述
     * @return 文字描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置文字描述
     * @param description 文字描述
     */
    public void setDescription(String description) {
        this.description = description;
    }



    /**
     * 构造函数
     * @param description 描述,不可为空
     */
    StatusEnum(String description) {
        if(description == null){
            throw new IllegalArgumentException("description不可为空");
        }
        this.description = description;
    }

    /**
     * 根据描述获取枚举
     * @param description 描述
     * @return 枚举,如果description为null或者找不到匹配的枚举,返回null
     */
    public static StatusEnum getByDescription(String description){
        if(description == null){
            return null;
        }
        for (Iterator<StatusEnum> iter = enumSet.iterator(); iter.hasNext();) {
            StatusEnum enumObject = iter.next();
            if( description.equals(enumObject.getDescription())){
                return enumObject;
            }
        }
        return null;
    }
}
