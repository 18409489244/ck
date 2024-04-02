package com.lyf.enums;

/**
 * @program: codepractice
 * @description: 告警等级枚举类
 * @author: 刘耀福
 * @create: 2024-04-02 09:50
 **/
public enum AlarmLevelEnum {
    general("general"),
    serious("serious");
    public String type;

    AlarmLevelEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
