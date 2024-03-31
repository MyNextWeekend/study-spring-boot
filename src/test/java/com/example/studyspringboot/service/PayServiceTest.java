package com.example.studyspringboot.service;

import com.example.studyspringboot.constant.PayEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PayServiceTest {

    @Autowired
    private List<PayService> payService;

    @Test
    void pay() {
        String PayType = PayEnum.BANK.getPayType();
        for (PayService payService1 : payService) {
            if (payService1.equals(PayType)) {
                payService1.pay(100);
            }
        }
    }
}