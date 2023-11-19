package com.example.studyspringboot.entity;

import lombok.Data;

import java.util.List;

@Data
public class Teacher {
    private int id;
    private String name;
    private String sex;
    private Integer age;
    private String create_time;
    private String update_time;

    private List<UserInfo> student;
}
