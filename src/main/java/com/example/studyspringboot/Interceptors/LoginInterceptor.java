package com.example.studyspringboot.Interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器
 */
@Component //需要被spring接管
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 此方法的作用是在请求进入到Controller进行拦截，有返回值。
     * 返回值:返回true则将请求放行进入Controller控制层，false则请求结束返回错误信息
     * 用法:登录验证（判断用户是否登录）权限验证：判断用户是否有权访问资源（校验token）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getHeaderNames());
        // 请求进来之前do_something

        //验证token
        //token续时长
        return true; //返回true表示放行
    }

    /**
     * 该方法是在Controller控制器执行完成但是还没有返回模板进行渲染拦截。没有返回值。
     * 就是Controller----->拦截------>ModelAndView。
     * 用法：因此我们可以将Controller层返回来的参数进行一些修改，它就包含在ModelAndView中，
     * 所以该方法多了一个ModelAndView参数。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //do_something
    }

    /**
     * 该方法是在ModelAndView返回给前端渲染后执行。
     * 用法：例如登录的时候，我们经常把用户信息放到ThreadLocal中，为了防止内存泄漏，就需要将其remove掉，该操作就是在这里执行的。
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // do_something

    }
}
