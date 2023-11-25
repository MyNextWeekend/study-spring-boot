package com.example.studyspringboot.exception;

import com.example.studyspringboot.controller.UserInfoController;
import com.example.studyspringboot.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ControllerAdvice 拆分开来就是Controller Advice，
 * Advice：其是用于封装一个切面所有属性的，包括切入点和需要织入的切面逻辑。
 * ControllerAdvice：用于对Controller进行“切面”环绕的，而具体的业务织入方式则是通过结合其他的注解来实现的
 * 结合方法型注解：
 * 1、结合方法型注解@ExceptionHandler，用于捕获Controller中抛出的指定类型的异常，从而达到不同类型的异常区别处理的目的
 * 2、结合方法型注解@InitBinder，用于request中自定义参数解析方式进行注册，从而达到自定义指定格式参数的目的
 * 3、结合方法型注解@ModelAttribute，表示其标注的方法将会在目标Controller方法执行之前执行
 */

// 此处使用 RestControllerAdvice = ControllerAdvice + ResponseBody
@RestControllerAdvice
public class AppExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(AppExceptionHandler.class);

    @ExceptionHandler(value = {Exception.class})  // value 可以指定处理哪种异常
    public <T> Result<T> exceptionHandler(Exception e) {
        if (e instanceof AppException exception) { // 判断是不是自定义异常
            return Result.error(exception.getCode(), exception.getMsg());
        }
        logger.error("error:", e);
        return Result.error(500, "服务器内部异常");
    }
}
