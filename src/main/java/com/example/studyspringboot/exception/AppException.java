package com.example.studyspringboot.exception;

import lombok.Getter;

/**
 * 自定义异常类
 */
@Getter
public class AppException extends RuntimeException {
    private final int code;
    private final String msg;

    public AppException(AppExceptionCodeMsg appExceptionCodeMsg) {
        super();
        this.code = appExceptionCodeMsg.getCode();
        this.msg = appExceptionCodeMsg.getMsg();
    }

    public AppException(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }
}
