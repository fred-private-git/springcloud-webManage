package com.zkml.official_reception.client.enums;

import java.util.EnumSet;

public enum ReceptionApplyStateEnum {
    UN_APPLY("未提交审核"),

    APPLY_INIT("新提交审核"),

    APPLY_ING("审批中"),

    APPLY_END("已通过"),

    APPLY_UN_DO("已撤回"),

    APPLY_REJECTED("已驳回"),

    ;


    /**
     * 枚举Set,包含本枚举的所以实例
     */
    private static EnumSet<ReceptionApplyStateEnum> enumSet = EnumSet.allOf(ReceptionApplyStateEnum.class);

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
    ReceptionApplyStateEnum(String description) {
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
    public static ReceptionApplyStateEnum getByDescription(String description){
        if(description == null){
            return null;
        }
        for (ReceptionApplyStateEnum enumObject : enumSet) {
            if (description.equals(enumObject.getDescription())) {
                return enumObject;
            }
        }
        return null;
    }
}
