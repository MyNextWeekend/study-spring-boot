package com.example.studyspringboot.service.impl;

import com.example.studyspringboot.service.PayService;
import lombok.extern.slf4j.Slf4j;


/**
 * 支付模板impl
 *
 * @author weekend
 * @date 2024/03/17
 */
@Slf4j
public abstract class PayTemplateImpl implements PayService {

    /**
     * 查询余额
     */
    public abstract int queryBalance();

    @Override
    public String pay(int money) {
        log.info("支付金额：" + money);
        if (money > queryBalance()) {
            log.info("余额不足");
            return "余额不足";
        }
        log.info("支付成功");
        return "支付成功";
    }
}
