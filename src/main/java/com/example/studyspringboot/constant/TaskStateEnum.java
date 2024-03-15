package com.example.studyspringboot.constant;

import lombok.Getter;

/**
 * 任务状态枚举
 *
 * @author weekend
 * @date 2024/03/16
 */
@Getter
public enum TaskStateEnum {
    INIT(0),
    RUNNING(1),
    SUCCESS(2),
    FAIL(3),
    CANCEL(4),
    PAUSE(5),
    WAITING(6),
    WAITING_CONFIRM(7),
    WAITING_CONFIRM_FAIL(8),
    WAITING_CONFIRM_SUCCESS(9),
    WAITING_CONFIRM_CANCEL(10),
    WAITING_CONFIRM_PAUSE(11),
    WAITING_CONFIRM_RUNNING(12),
    WAITING_CONFIRM_WAITING(13),
    WAITING_CONFIRM_WAITING_CONFIRM(14);

    TaskStateEnum(int code) {
        this.code = code;
    }

    private final int code;
}
