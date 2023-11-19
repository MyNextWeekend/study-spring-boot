package com.example.studyspringboot.service;

import com.example.studyspringboot.entity.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
@Transactional //使用回滚注解@Rollback，配合事务注解@Transactional，来回滚事务
public class UserInfoServiceTest {
    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void selectAll() {
        List<UserInfo> userInfo = userInfoService.selectAll();
        System.out.println(userInfo);
    }

    @Test
    @Rollback //可以定义在测试类上，对整个类起作用，也可以对方法单独定义
    public void insertUser() {
        UserInfo info = new UserInfo();
        info.setUser_name("wo");
        info.setName("111");
        info.setPwd("666");
        Integer num = userInfoService.insertUser(info);
        Assert.isTrue(num > 0, "失败啦");
    }
}
