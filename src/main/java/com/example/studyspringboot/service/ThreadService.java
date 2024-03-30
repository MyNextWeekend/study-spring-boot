package com.example.studyspringboot.service;

import java.util.concurrent.CompletableFuture;

/**
 * 线程服务
 *
 * @author weekend
 * @date 2024/03/30
 */
public interface ThreadService {
    void test01();

    CompletableFuture<String> test02();

}
