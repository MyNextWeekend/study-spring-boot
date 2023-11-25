package com.example.studyspringboot.service;

import com.example.studyspringboot.controller.UserInfoController;
import com.example.studyspringboot.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


@SpringBootTest
class TeacherServiceTest {
    private final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private TeacherService teacherService;

    @Test
    public void selectAllTest() {
        List<Teacher> teachers = teacherService.selectAll();
        System.out.println(teachers);
    }

    @Test
    public void hello() throws InterruptedException {
        logger.info("start");
        teacherService.helloAsync("张三");
        Thread.sleep(3 * 1000);
        logger.info("end");
    }

    @Test
    void helloAsyncAndResult() throws InterruptedException{
        logger.info("start");
        Future<String> job1 = teacherService.helloAsyncAndResult("张三");
        Future<String> job2 = teacherService.helloAsyncAndResult("莉丝");
        Future<String> job3 = teacherService.helloAsyncAndResult("王五");
        try {
            while (true) {
                if (job1.isDone() && job2.isDone() && job3.isDone()) {
                    logger.info("job1的返回值：{}", job1.get()); //子线程异常的时候，取子线程的结果会导致主线程异常
                    logger.info("job2的返回值：{}", job2.get());
                    logger.info("job3的返回值：{}", job3.get());
                    break;
                } else {
                    Thread.sleep(500);
                }
            }
        } catch (Exception e) {
            logger.error("异常消息：",e);
        }
        logger.info("end");
    }
}