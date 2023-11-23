package com.example.studyspringboot.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 自定义异常枚举
 */
@Getter
@AllArgsConstructor
public enum AppExceptionCodeMsg {
    INVALID_CODE(1000, "验证码无效"),
    USERNAME_ALREADY_EXISTS(10001, "用户名已经存在"),
    USERNAME_NOT_EXISTS(10002, "用户名不存在");


    private final int code;
    private final String msg;

}
