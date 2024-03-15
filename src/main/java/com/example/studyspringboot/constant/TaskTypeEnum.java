package com.example.studyspringboot.constant;

import lombok.Getter;

/**
 * 任务类型枚举
 *
 * @author weekend
 * @date 2024/03/16
 */
@Getter
public enum TaskTypeEnum {
    AUDIO("audio"),
    VIDEO("video"),
    IMAGE("image"),
    TEXT("text"),
    OTHER("other");

    TaskTypeEnum(String value) {
        this.value = value;
    }

    private final String value;
}
