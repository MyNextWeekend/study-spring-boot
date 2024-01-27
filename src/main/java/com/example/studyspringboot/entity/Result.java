package com.example.studyspringboot.entity;

import com.example.studyspringboot.exception.ReturnCodeMsg;
import lombok.Getter;

/**
 * 统一的返回体
 */
@Getter
public class Result<T> {
    private final int code;
    private final String message;
    private final T data;

    private Result(int code, String message, T data) {  //私有构造方法
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 操作成功，有相应数据返回
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(0, "操作成功", data);
    }

    /**
     * 操作成功，没有相应数据返回
     */
    public static <T> Result<T> success() {
        return new Result<>(0, "操作成功", null);
    }

    /**
     * 操作失败
     */
    public static <T> Result<T> error(int code, String message) {
        return new Result<>(code, message, null);
    }


    /**
     * 操作失败
     *
     * @param returnCodeMsg 异常情况枚举
     * @return 返回固定的结构体
     */
    public static <T> Result<T> error(ReturnCodeMsg returnCodeMsg) {
        return new Result<>(returnCodeMsg.getCode(), returnCodeMsg.getMsg(), null);
    }
}
