package com.example.studyspringboot.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * pay枚举
 *
 * @author weekend
 * @date 2024/03/30
 */
@Getter
@AllArgsConstructor
public enum PayEnum {
    WE_XIN("WX", "微信支付"),
    ALIPAY("ZFB", "支付宝支付"),
    BANK("BANK", "银行卡支付"),
    ;
    private final String payType;
    private final String desc;
}
