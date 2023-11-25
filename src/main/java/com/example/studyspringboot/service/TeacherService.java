package com.example.studyspringboot.service;

import com.example.studyspringboot.entity.Teacher;

import java.util.List;
import java.util.concurrent.Future;

public interface TeacherService {
    List<Teacher> selectAll();

    /**
     * 异步方法练习
     */
    void helloAsync(String name) throws InterruptedException;

    /**
     * 异步方法有返回值练习
     */
    Future<String> helloAsyncAndResult(String name) throws InterruptedException;
}
