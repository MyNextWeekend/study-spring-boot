package com.example.studyspringboot;

import com.example.studyspringboot.constant.PayEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EnumTest {
    @Test
    public void test() {
        try {
            PayEnum payType = PayEnum.valueOf("WE_XIN1");
            System.out.println(payType.getPayType());
            System.out.println(payType.getDesc());
        }catch (IllegalArgumentException e){
            System.out.println("枚举不存在");
        }catch (Exception e){
            System.out.println("其他异常");
        }
    }
}

