package com.example.studyspringboot;

import org.junit.jupiter.api.Test;

public class ThreadLocalTest {
    /**
     * 线程空间测试
     */
    @Test
    public void testThreadLocalGetAndSet() {
        // 开启线程空间
        ThreadLocal<String> local = new ThreadLocal<>();

        new Thread(() -> {
            local.set("甲");//每个线程设置值是隔离，独享的

            System.out.println(Thread.currentThread().getName() + ":" + local.get());
            System.out.println(Thread.currentThread().getName() + ":" + local.get());
            System.out.println(Thread.currentThread().getName() + ":" + local.get());
        }, "线程甲").start();

        new Thread(() -> {
            local.set("乙");//每个线程设置值是隔离，独享的

            System.out.println(Thread.currentThread().getName() + ":" + local.get());
            System.out.println(Thread.currentThread().getName() + ":" + local.get());
            System.out.println(Thread.currentThread().getName() + ":" + local.get());
        }, "线程乙").start();

    }
}
