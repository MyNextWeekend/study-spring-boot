package com.example.studyspringboot.service;

import com.example.studyspringboot.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class TeacherServiceTest {

    @Autowired
    private TeacherService teacherService;

    @Test
    public void selectAllTest() {
        List<Teacher> teachers = teacherService.selectAll();
        System.out.println(teachers);
    }
}