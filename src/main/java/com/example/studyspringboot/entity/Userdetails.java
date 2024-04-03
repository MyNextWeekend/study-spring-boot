package com.example.studyspringboot.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName UserDetails
 */
@Data
public class Userdetails implements Serializable {
    /**
     * 自增主键，用于唯一标识每条用户详情记录
     */
    private Integer id;

    /**
     * 外键，关联到用户表
     */
    private Integer userId;

    /**
     * 用户的年龄
     */
    private Integer age;

    /**
     * 用户的全名
     */
    private String fullName;

    /**
     * 用户的邮箱地址，要求唯一
     */
    private String email;

    /**
     * 用户注册日期
     */
    private Date registrationDate;

    /**
     * 用户上次登录日期
     */
    private Date lastLoginDate;

    /**
     * 用户的电话号码
     */
    private String phoneNumber;

    /**
     * 用户个人简介或描述信息
     */
    private String profileDescription;

    /**
     * 用户账户到期日期
     */
    private Date accountExpiryDate;

    private static final long serialVersionUID = 1L;
}