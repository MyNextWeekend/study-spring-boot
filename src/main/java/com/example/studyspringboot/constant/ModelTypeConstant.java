package com.example.studyspringboot.constant;

import lombok.Getter;

/**
 * 模型类型常数
 *
 * @author weekend
 * @date 2024/01/27
 */
public class ModelTypeConstant {
    @Getter
    public enum StateEnum {
        INIT(0, "初始化"),
        RUNNING(1, "执行中"),
        SUCCESS(2, "成功"),
        FAIL(5, "失败"),
        WAITING(6, "等待"),
        ;
        private final int code;
        private final String desc;

        StateEnum(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public static StateEnum getByCode(Integer code) {
            if (code == null) {
                return null;
            }
            for (StateEnum stateEnum : StateEnum.values()) {
                if (stateEnum.getCode() == code) {
                    return stateEnum;
                }
            }
            return null;
        }
    }
}
