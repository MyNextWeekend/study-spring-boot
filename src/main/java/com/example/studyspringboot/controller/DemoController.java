package com.example.studyspringboot.controller;

import com.example.studyspringboot.common.Result;
import com.example.studyspringboot.constant.ModelTypeConstant;
import com.example.studyspringboot.constant.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weekend
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    private final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/hello")
    public Result<?> hello(@RequestParam Integer code) {
        ModelTypeConstant.StateEnum byCode = ModelTypeConstant.StateEnum.getByCode(code);
        if (byCode == null) {
            logger.info("error");
            return Result.error(1, "error");
        }
        switch (byCode) {
            case SUCCESS:
            case FAIL:// 匹配多个分支
                logger.info("FAIL");
                break;
            case WAITING:
                logger.info("WAITING");
                break;
            default:
                logger.info("default");
        }

        logger.info("/hello接收到请求");
        logger.info("do work 001 success");
        logger.info("do work 002 success");
        logger.info("do work 003 success");
        logger.info("任务的类型是：" + Task.TypeEnum.AUDIO.getValue());
        logger.info("任务的状态是：" + Task.StateEnum.SUCCESS.getCode());
        return Result.success();
    }
}
