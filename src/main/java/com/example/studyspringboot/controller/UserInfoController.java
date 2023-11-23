package com.example.studyspringboot.controller;

import com.example.studyspringboot.entity.Result;
import com.example.studyspringboot.entity.UserInfo;
import com.example.studyspringboot.exception.AppException;
import com.example.studyspringboot.exception.AppExceptionCodeMsg;
import com.example.studyspringboot.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user_info")
public class UserInfoController {
    private final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoService userInfoService;

    /**
     * RequestBody表示从请求体中获取数据并转换为java对象，Validated可以指定生效规则的分组名称
     */
    @PostMapping("/insert")
    public Result<?> insertUserInfo(@RequestBody @Validated(UserInfo.Insert.class) UserInfo userInfo) {
        userInfoService.insertUser(userInfo);
        return Result.success();
    }

    @PostMapping("/update")
    public Result<?> deleteById(@RequestBody @Validated(UserInfo.Update.class) UserInfo userInfo) {
        Integer i = userInfoService.updateUserById(userInfo);
        if (i > 0) {
            return Result.success();
        }
        return Result.error(1, "更新失败");
    }

    @GetMapping("/hello")
    public Result<?> hello(String msg) {
        logger.info("请求进来了。。。");
        if ("1".equals(msg)) {
            throw new AppException(AppExceptionCodeMsg.USERNAME_NOT_EXISTS);
        }
        if ("2".equals(msg)) {
            int a = 1 / 0;
        }

        return Result.success();
    }
}
