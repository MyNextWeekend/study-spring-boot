package com.example.studyspringboot.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName UserDetails
 */
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

    /**
     * 自增主键，用于唯一标识每条用户详情记录
     */
    public Integer getId() {
        return id;
    }

    /**
     * 自增主键，用于唯一标识每条用户详情记录
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 外键，关联到用户表
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 外键，关联到用户表
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 用户的年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 用户的年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 用户的全名
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 用户的全名
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * 用户的邮箱地址，要求唯一
     */
    public String getEmail() {
        return email;
    }

    /**
     * 用户的邮箱地址，要求唯一
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 用户注册日期
     */
    public Date getRegistrationDate() {
        return registrationDate;
    }

    /**
     * 用户注册日期
     */
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * 用户上次登录日期
     */
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     * 用户上次登录日期
     */
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     * 用户的电话号码
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 用户的电话号码
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 用户个人简介或描述信息
     */
    public String getProfileDescription() {
        return profileDescription;
    }

    /**
     * 用户个人简介或描述信息
     */
    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    /**
     * 用户账户到期日期
     */
    public Date getAccountExpiryDate() {
        return accountExpiryDate;
    }

    /**
     * 用户账户到期日期
     */
    public void setAccountExpiryDate(Date accountExpiryDate) {
        this.accountExpiryDate = accountExpiryDate;
    }
}