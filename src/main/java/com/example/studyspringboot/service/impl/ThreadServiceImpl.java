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
     * 在Spring框架的某些版本中，org.springframework.scheduling.annotation.AsyncResult
     * 类确实可能已经被标记为过时或不推荐使用。从Spring 5.2版本开始，
     * 建议直接使用Java原生的java.util.concurrent.CompletableFuture或者
     * 返回ListenableFuture（来自Spring的org.springframework.util.concurrent.ListenableFuture）
     * 来表示异步操作的结果。
     * 如果你发现AsyncResult已经过时，可以按照以下方式更新代码：
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
