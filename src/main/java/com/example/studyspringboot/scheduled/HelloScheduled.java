package com.example.studyspringboot.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/***
 * 定时任务
 * @author weekend
 */
@Component //交由springboot管理
public class HelloScheduled {
    private final Logger logger = LoggerFactory.getLogger(HelloScheduled.class);

    @Async(value = "scheduleTaskExecutor")
    @Scheduled(cron = "0/30 * * * * *") //每30秒启动一次
//    @Scheduled(fixedRate = 2 * 1000)
    public void haha() {
        logger.info("schedule work 001 success:" + System.currentTimeMillis());
        logger.info("schedule work 002 success:" + System.currentTimeMillis());
        logger.info("schedule work 003 success:" + System.currentTimeMillis());
        logger.info("schedule work 004 success:" + System.currentTimeMillis());
    }

}
