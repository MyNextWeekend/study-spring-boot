package com.example.studyspringboot.controller;

import com.example.studyspringboot.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weekend
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    private final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/hello")
    public Result<?> hello() {
        logger.info("/hello接收到请求");
        logger.info("do work 001 success");
        logger.info("do work 002 success");
        logger.info("do work 003 success");
        return Result.success();
    }
}
