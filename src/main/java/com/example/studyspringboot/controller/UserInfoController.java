package com.example.studyspringboot.controller;

import com.example.studyspringboot.entity.Result;
import com.example.studyspringboot.entity.UserInfo;
import com.example.studyspringboot.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user_info")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/insert")
    public Result insertUserInfo(@RequestBody @Validated(UserInfo.Insert.class) UserInfo userInfo) {
        //RequestBody表示从请求体中获取数据并转换为java对象，Validated可以指定生效规则的分组名称
        UserInfo u = userInfoService.selectByName(userInfo.getName());
        if (u != null) {
            return Result.fail("用户名已存在");
        }
        userInfoService.insertUser(userInfo);
        return Result.success();
    }

    @PostMapping("/update")
    public Result deleteById(@RequestBody @Validated(UserInfo.Update.class) UserInfo userInfo) {
        Integer i = userInfoService.updateUserById(userInfo);
        if (i > 0) {
            return Result.success();
        }
        return Result.fail("更新失败");
    }
}
