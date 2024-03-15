package com.example.studyspringboot.service;

import java.util.concurrent.CompletableFuture;

public interface ThreadService {
    void test01();

    CompletableFuture<String> test02();
}
