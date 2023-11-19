package com.example.studyspringboot.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/***
 * 定时任务
 */
@Component //交由springboot管理
public class Hello {
    private final Logger logger = LoggerFactory.getLogger(Hello.class);

    @Scheduled(cron = "0/30 * * * * *") //每30秒启动一次
//    @Scheduled(fixedRate = 2 * 1000)
    public void haha() {
        logger.info("哈哈:" + System.currentTimeMillis());
    }

}
