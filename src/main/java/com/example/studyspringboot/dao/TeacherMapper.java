package com.example.studyspringboot.dao;

import com.example.studyspringboot.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 教师制图器
 *
 * @author weekend
 * @date 2024/01/27
 */
@Mapper
public interface TeacherMapper {

    Integer insertTeacher(Teacher teacher);

    List<Teacher> selectAll();

}
