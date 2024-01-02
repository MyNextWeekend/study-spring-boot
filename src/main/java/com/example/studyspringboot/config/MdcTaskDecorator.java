package com.example.studyspringboot.config;

import com.example.studyspringboot.util.TraceIdUtil;
import org.slf4j.MDC;
import org.springframework.core.task.TaskDecorator;

import java.util.Map;

/**
 * 线程池任务装饰器
 * @author weekend
 */
public class MdcTaskDecorator implements TaskDecorator {
    @Override
    public Runnable decorate(Runnable runnable) {
        Map<String, String> copyOfContextMap = MDC.getCopyOfContextMap();
        return () -> {
            try {
                if (copyOfContextMap != null) {
                    MDC.setContextMap(copyOfContextMap);    //将父线程的MDC内容传给子线程
                } else {
                    TraceIdUtil.generateTraceId();  //父线程的MDC内容为空，则生成一个新的TraceId
                }

                runnable.run();
            } finally {
                MDC.clear();
            }
        };
    }
}
