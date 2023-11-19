package com.example.studyspringboot.service.impl;

import com.example.studyspringboot.dao.TeacherMapper;
import com.example.studyspringboot.entity.Teacher;
import com.example.studyspringboot.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> selectAll() {
        return teacherMapper.selectAll();
    }
}
