package com.example.studyspringboot.controller;

import com.example.studyspringboot.common.Result;
import com.example.studyspringboot.service.ThreadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 线程池学习
 *
 * @author weekend
 * @date 2024/03/15
 */
@Slf4j
@RestController
@RequestMapping("/thread")
public class ThreadPoolController {

    @Autowired
    @Qualifier("asyncPoolTaskExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    private ThreadService threadService;

    /**
     * 往线程池提交任务
     * submit()和execute()的区别
     * 1. submit()返回的是Future对象，可以获取任务的执行结果，可以使用get()方法获取执行结果，也可以使用isDone()方法判断任务是否执行完成
     * 2. execute()返回的是void，不能获取任务的执行结果，只能判断任务是否执行完成
     * 3. submit()和execute()都可以将任务提交到线程池，但是submit()可以提交Runnable和Callable任务，execute()只能提交Runnable任务
     */
    @PostMapping("/test01")
    public Result<String> test01() {
        long start = System.currentTimeMillis();
        log.info("start...");

        threadPoolTaskExecutor.execute(() -> {
            try {
                log.info("开始执行001");
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        threadPoolTaskExecutor.execute(() -> {
            try {
                log.info("开始执行002");
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Future<String> future = threadPoolTaskExecutor.submit(() -> {
            try {
                log.info("开始执行002");
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "hello";
        });
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                log.info("开始执行003");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, threadPoolTaskExecutor);

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            try {
                log.info("开始执行004");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, threadPoolTaskExecutor);

        try {
            // 等待两个任务结束
            CompletableFuture.allOf(future1, future2).get();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        log.info("耗时:{}", System.currentTimeMillis() - start);

        return Result.success("test");
    }

    /**
     * 没有返回值的调用异步方法
     */
    @PostMapping("/test02")
    public Result<String> test02() {
        long start = System.currentTimeMillis();
        log.info("start...");
        threadService.test01();
        threadService.test01();
        log.info("耗时:{}", System.currentTimeMillis() - start);
        return Result.success("test02");
    }

    /**
     * 有返回值的调用异步方法
     */
    @PostMapping("/test03")
    public Result<String> test03() {
        long start = System.currentTimeMillis();
        log.info("start...");
        CompletableFuture<String> future1 = threadService.test02();
        CompletableFuture<String> future2 = threadService.test02();
        CompletableFuture.allOf(future1, future2).join();
        log.info("等待结束耗时:{}", System.currentTimeMillis() - start);
        try {
            String s1 = future1.get();
            String s2 = future2.get();
            log.info("s1:{},s2:{}", s1, s2);
        } catch (InterruptedException | ExecutionException e) {
            log.error(e.getMessage(), e);
        }
        log.info("最终拿到结果耗时:{}", System.currentTimeMillis() - start);
        return Result.success("test02");
    }

}
