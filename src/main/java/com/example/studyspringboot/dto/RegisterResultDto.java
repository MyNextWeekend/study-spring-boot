package com.example.studyspringboot.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 注册接口响应结果
 *
 * @author weekend
 * @date 2024/04/04
 */
@NoArgsConstructor
@Data
public class RegisterResultDto {

    private int code;
    private String message;
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        private String name;
        private Integer age;
        private boolean ok;
    }
}
