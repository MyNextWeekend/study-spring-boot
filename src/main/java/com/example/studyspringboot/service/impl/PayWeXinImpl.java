package com.example.studyspringboot.service.impl;

import com.example.studyspringboot.constant.PayEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 微信支付impl
 *
 * @author weekend
 * @date 2024/03/17
 */
@Slf4j
@Service
public class PayWeXinImpl extends PayTemplateImpl {
    @Override
    public Boolean equals(String payType) {
        return  PayEnum.WE_XIN.getType().equals(payType);
    }

    @Override
    public int queryBalance() {
        log.info("查询微信余额成功");
        return 100;
    }

}
