package com.example.studyspringboot.constant;

import lombok.Getter;

/**
 * 任务
 *
 * @author weekend
 * @date 2024/03/17
 */
public class Task {

    @Getter
    public enum StateEnum {
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

        StateEnum(int code) {
            this.code = code;
        }

        private final int code;
    }

    @Getter
    public enum TypeEnum {
        AUDIO("audio"),
        VIDEO("video"),
        IMAGE("image"),
        TEXT("text"),
        OTHER("other");

        TypeEnum(String value) {
            this.value = value;
        }

        private final String value;
    }
}
