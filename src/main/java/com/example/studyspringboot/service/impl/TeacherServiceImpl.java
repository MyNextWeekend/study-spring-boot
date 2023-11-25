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
}
