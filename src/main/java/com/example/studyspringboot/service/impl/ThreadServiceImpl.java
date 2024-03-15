package com.example.studyspringboot.service.impl;

import com.example.studyspringboot.service.ThreadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * 线程服务impl
 *
 * @author weekend
 * @date 2024/03/15
 */
@Slf4j
@Service
public class ThreadServiceImpl implements ThreadService {

    @Async("asyncPoolTaskExecutor")
    @Override
    public void test01() {
        try {
            log.info("异步任务开始执行");
            Thread.sleep(3000);
            log.info("异步任务执行结束");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 有返回值的异步方法
     */
    @Async("asyncPoolTaskExecutor")
    @Override
    public CompletableFuture<String> test02() {
        try {
            log.info("异步任务开始执行");
            Thread.sleep(3000);
            log.info("异步任务执行结束");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return CompletableFuture.completedFuture("async ok");
    }
}
