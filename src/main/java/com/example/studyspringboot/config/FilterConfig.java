package com.example.studyspringboot.config;

import com.example.studyspringboot.filter.TraceFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author weekend
 * 注册过滤器
 */
@Configuration
public class FilterConfig {

    @Bean
    @ConditionalOnMissingBean(TraceFilter.class)
    @Order(Ordered.HIGHEST_PRECEDENCE + 100)// 多个过滤器之间设置优先级，数字越小优先级越高
    public FilterRegistrationBean<TraceFilter> traceFilterBean() {
        FilterRegistrationBean<TraceFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new TraceFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }

}