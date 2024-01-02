package com.example.studyspringboot.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * @author weekend
 */
public class TraceIdUtil {
    public static final String TRACE_ID = "TraceId";

    /**
     * 生成一个新的traceId
     */
    public static void generateTraceId() {
        String traceId = UUID.randomUUID().toString().replace("-", "");
        MDC.put(TRACE_ID, traceId);
    }

    /**
     * 传入traceId，如果为空，则生成一个新的traceId
     */
    public static void generateTraceId(String traceId) {
        if (StringUtils.isBlank(traceId)) {
            generateTraceId();
            return;
        }
        MDC.put(TRACE_ID, traceId);
    }

    /**
     * 获取traceId
     */
    public static String getTraceId() {
        return MDC.get(TRACE_ID);
    }

    /**
     * 清除traceId
     */
    public static void removeTraceId() {
        MDC.remove(TRACE_ID);
    }
}
