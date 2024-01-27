package com.example.studyspringboot.common;

import lombok.Getter;

/**
 * 自定义异常类
 *
 * @author weekend
 * @date 2024/01/26
 */
@Getter
public class AppException extends RuntimeException {
    private final int code;
    private final String msg;

    public AppException(ReturnCodeMsg returnCodeMsg) {
        super();
        this.code = returnCodeMsg.getCode();
        this.msg = returnCodeMsg.getMsg();
    }

    public AppException(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }
}
