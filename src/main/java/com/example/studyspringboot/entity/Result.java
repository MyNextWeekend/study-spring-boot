package com.example.studyspringboot.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;


    /**
     * 操作成功，有相应数据返回
     *
     * @param data 需要返回的数据
     * @param <E>  范型
     * @return 返回固定的结构体
     */
    public static <E> Result<E> success(E data) {
        return new Result<>(0, "操作成功", data);
    }

    /**
     * 操作成功，没有相应数据返回
     *
     * @return 返回固定的结构体
     */
    public static Result success() {
        return new Result(0, "操作成功", null);
    }

    /**
     * 操作失败
     * @param message 失败的原因
     * @return
     */
    public static Result fail(String message) {
        return new Result(-1, message, null);
    }
}
