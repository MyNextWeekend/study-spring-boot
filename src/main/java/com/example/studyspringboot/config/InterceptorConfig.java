package com.example.studyspringboot.config;

import com.example.studyspringboot.Interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;


/**
 * @author weekend
 * 注册自定义拦截器
 */
@Configuration //配置类
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    /**
     * 注册自定义拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        ArrayList<String> patterns = new ArrayList<>(); // 需要放行的路径放在list中，统一传递
        patterns.add("/user/login");
        patterns.add("/user/register");
        registry.addInterceptor(loginInterceptor) //添加自定义拦截器
                .excludePathPatterns(patterns);//该拦截器对如下请求路径不处理
    }
}
