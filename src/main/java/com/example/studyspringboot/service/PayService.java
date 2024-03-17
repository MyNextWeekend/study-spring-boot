package com.example.studyspringboot.service;

/**
 * 付费服务
 *
 * @author weekend
 * @date 2024/03/17
 */
public interface PayService {
    /**
     * 等于
     */
    Boolean equals(String payType);

    /**
     * 支付
     */
    String pay(int money);
}
