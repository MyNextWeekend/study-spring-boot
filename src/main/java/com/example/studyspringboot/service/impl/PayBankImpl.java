package com.example.studyspringboot.service.impl;

import com.example.studyspringboot.constant.PayEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 银行支付impl
 *
 * @author weekend
 * @date 2024/03/17
 */
@Slf4j
@Service
public class PayBankImpl extends PayTemplateImpl {
    @Override
    public Boolean equals(String payType) {
        return PayEnum.BANK.getPayType().equals(payType);
    }

    @Override
    public int queryBalance() {
        log.info("查询银行卡余额成功");
        return 20;
    }


}
