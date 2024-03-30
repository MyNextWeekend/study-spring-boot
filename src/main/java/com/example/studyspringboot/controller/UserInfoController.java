package com.example.studyspringboot.controller;

import com.example.studyspringboot.common.AppException;
import com.example.studyspringboot.common.Result;
import com.example.studyspringboot.common.ReturnCodeMsg;
import com.example.studyspringboot.dto.UserInfoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;


/**
 * 用户信息控制器
 *
 * @author weekend
 * @date 2024/03/30
 */
@Validated // 校验参数
@RestController
@RequestMapping("/user_info")
public class UserInfoController {
    private final Logger logger = LoggerFactory.getLogger(UserInfoController.class);


    /**
     * RequestBody表示从请求体中获取数据并转换为java对象，Validated可以指定生效规则的分组名称
     */
    @PostMapping("/insert")
    public Result<?> insertUserInfo(@RequestBody @Validated(UserInfoDto.Insert.class) UserInfoDto userInfo) {
        logger.info(userInfo.toString());
        // userInfoService.insertUser(userInfo);
        return Result.success();
    }

    @PostMapping("/update")
    public Result<?> deleteById(@RequestBody @Validated(UserInfoDto.Update.class) UserInfoDto userInfo) {
        logger.info(userInfo.toString());
        // Integer i = userInfoService.updateUserById(userInfo);
        // if (i > 0) {
        //     return Result.success();
        // }
        return Result.error(1, "更新失败");
    }

    @PostMapping("/selectAll")
    public Result<?> selectAll(Integer pageNum, Integer pageSize) {
        // PageInfo<UserInfo> userInfos = userInfoService.selectAll(pageNum, pageSize);
        return Result.success(null);
    }

    @GetMapping("/hello")
    public Result<?> hello(@RequestParam @Max(value = 5L, message = "不能大于5") Integer id,
                           @RequestParam @Max(value = 15L, message = "不能大于15") Integer age) {
        logger.info("请求进来了。。。");
        System.out.println("收到的参数是：" + id + age);
        if (1 == id) {
            throw new AppException(ReturnCodeMsg.USERNAME_NOT_EXISTS);
        }
        if (2 == id) {
            int a = 1 / 0;
        }

        return Result.success();
    }
}
