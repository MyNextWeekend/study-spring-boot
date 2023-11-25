package com.example.studyspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //开启定期任务
@EnableAsync // 开启异步支持
public class StudySpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudySpringBootApplication.class, args);
    }

}
