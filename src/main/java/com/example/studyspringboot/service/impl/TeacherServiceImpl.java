package com.example.studyspringboot.service.impl;

import com.example.studyspringboot.dao.TeacherMapper;
import com.example.studyspringboot.entity.Teacher;
import com.example.studyspringboot.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.List;
import java.util.concurrent.Future;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final Logger logger = LoggerFactory.getLogger(TeacherServiceImpl.class);

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> selectAll() {
        return teacherMapper.selectAll();
    }

    @Async // 交由线程池执行的异步方法
    @Override
    public void helloAsync(String name) throws InterruptedException {
        logger.info("func helloAsync start ..." + name);
        Thread.sleep(1 * 1000);
        int a = 1 / 0;
        logger.info("func helloAsync end !!!" + name);
    }

    @Async
    @Override
    public Future<String> helloAsyncAndResult(String name) throws InterruptedException {
        logger.info("func helloAsyncAndResult start ..." + name);
        Thread.sleep(1 * 1000);
        int a = 1 / 0;
        logger.info("func helloAsyncAndResult end !!!" + name);
        return new AsyncResult<>(name);
    }


    /**
     * 在Spring框架的某些版本中，org.springframework.scheduling.annotation.AsyncResult
     * 类确实可能已经被标记为过时或不推荐使用。从Spring 5.2版本开始，
     * 建议直接使用Java原生的java.util.concurrent.CompletableFuture或者
     * 返回ListenableFuture（来自Spring的org.springframework.util.concurrent.ListenableFuture）
     * 来表示异步操作的结果。
     * 如果你发现AsyncResult已经过时，可以按照以下方式更新代码：
     */
    @Async
    public CompletableFuture<String> helloAsyncNew(String name) {
        logger.info("func helloAsync start ..." + name);
        // 这里执行你的异步任务逻辑
        String result = "Hello, " + name;
        // 模拟异步处理后返回结果
        return CompletableFuture.completedFuture(result);
    }

}
