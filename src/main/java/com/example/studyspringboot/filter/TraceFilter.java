package com.example.studyspringboot.filter;

import com.example.studyspringboot.util.TraceIdUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author weekend
 * 过滤器
 */
public class TraceFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            HttpServletRequest request1 = (HttpServletRequest) servletRequest;
            String tranceId = request1.getHeader(TraceIdUtil.TRACE_ID); //获取网关传过来的traceId
            TraceIdUtil.generateTraceId(tranceId);  //生成traceId
            filterChain.doFilter(servletRequest, servletResponse);    //将请求放行
        } finally {
            TraceIdUtil.removeTraceId();
        }
    }

    @Override
    public void destroy() {
    }
}
