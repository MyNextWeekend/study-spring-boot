package com.example.studyspringboot.dao;

import com.example.studyspringboot.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {

    Integer insertTeacher(Teacher teacher);


    List<Teacher> selectAll();

}
