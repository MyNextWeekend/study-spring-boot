package com.example.studyspringboot.constant;

/**
 * pay枚举
 *
 * @author weekend
 * @date 2024/03/17
 */
public enum PayEnum {
    WE_XIN("WX"),
    ALIPAY("ZFB"),
    BANK("BANK");
    private final String type;

    PayEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }


}
