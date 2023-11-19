package com.example.studyspringboot.utils;

public class ThreadLocalUtil {
    // 线程空间存储数据是线程安全的
    private static final ThreadLocal THREAD_LOCAL = new ThreadLocal();

    // 获取线程空间中存储的值
    public static <T> T get() {
        return (T) THREAD_LOCAL.get();
    }

    // 向线程空间存入值
    public static void set(Object o) {
        THREAD_LOCAL.set(o);
    }

    // 清除线程空间中的值（避免内存泄漏）
    public static void remove() {
        THREAD_LOCAL.remove();
    }

}
