package com.example.studyspringboot.filter;

import com.example.studyspringboot.util.TraceIdUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

/**
 * @author weekend
 * 过滤器
 */
public class TraceFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig){
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        try {
            HttpServletRequest request1 = (HttpServletRequest) request;
            String tranceId = request1.getHeader(TraceIdUtil.TRACE_ID); //获取网关传过来的traceId
            TraceIdUtil.generateTraceId(tranceId);  //生成traceId
            filterChain.doFilter(request, response);    //将请求放行
        } finally {
            TraceIdUtil.removeTraceId();
        }
    }

    @Override
    public void destroy() {
    }
}
