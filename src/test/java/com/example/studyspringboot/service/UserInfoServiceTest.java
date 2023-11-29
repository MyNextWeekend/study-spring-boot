package com.example.studyspringboot.service;

import com.example.studyspringboot.entity.UserInfo;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;


@SpringBootTest
@Transactional //使用回滚注解@Rollback，配合事务注解@Transactional，来回滚事务
public class UserInfoServiceTest {
    private final Logger logger = LoggerFactory.getLogger(UserInfoServiceTest.class);

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void selectAll() {
        PageInfo<UserInfo> userInfo = userInfoService.selectAll(2, 1);
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
