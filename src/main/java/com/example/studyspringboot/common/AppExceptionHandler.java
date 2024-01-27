package com.example.studyspringboot.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * 应用程序异常处理程序
 * ControllerAdvice 拆分开来就是Controller Advice，
 * Advice：其是用于封装一个切面所有属性的，包括切入点和需要织入的切面逻辑。
 * ControllerAdvice：用于对Controller进行“切面”环绕的，而具体的业务织入方式则是通过结合其他的注解来实现的
 * 结合方法型注解：
 * 1、结合方法型注解@ExceptionHandler，用于捕获Controller中抛出的指定类型的异常，从而达到不同类型的异常区别处理的目的
 * 2、结合方法型注解@InitBinder，用于request中自定义参数解析方式进行注册，从而达到自定义指定格式参数的目的
 * 3、结合方法型注解@ModelAttribute，表示其标注的方法将会在目标Controller方法执行之前执行
 *
 * @author weekend
 * @date 2024/01/27
 */

// 此处使用 RestControllerAdvice = ControllerAdvice + ResponseBody
@RestControllerAdvice
public class AppExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(AppExceptionHandler.class);

    /**
     * 应用程序异常处理程序
     */
    @ExceptionHandler(value = {AppException.class})
    public <T> Result<T> appExceptionHandler(AppException e) {
        return Result.error(e.getCode(), e.getMsg());
    }

    /**
     * 处理未知异常
     */
    @ExceptionHandler(value = {Exception.class})  // value 可以指定处理哪种异常
    public <T> Result<T> exceptionHandler(Exception e) {
        logger.error(e.getMessage(), e);
        return Result.error(ReturnCodeMsg.RC500);
    }

    /**
     * 处理 GET请求参数 缺失
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public <T> Result<T> handleRequestParameterException(MissingServletRequestParameterException e) {
        return Result.error(HttpStatus.BAD_REQUEST.value(), "缺失字段:" + e.getParameterName());
    }

    /**
     * 处理 GET 参数类型不匹配异常
     */
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public <T> Result<T> handMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return Result.error(HttpStatus.BAD_REQUEST.value(), "字段类型转换异常:" + e.getName());
    }

    /**
     * 处理 GET单个参数 验证异常
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public <T> Result<T> handleValidationException(ConstraintViolationException e) {
        String errorMassage = e.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining("; "));
        return Result.error(HttpStatus.BAD_REQUEST.value(), errorMassage);
    }

    /**
     * 处理 json请求体参数 异常
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public <T> Result<T> handleValidationBodyException(MethodArgumentNotValidException e) {
        String errorMassage = e.getBindingResult().getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining("; "));
        return Result.error(HttpStatus.BAD_REQUEST.value(), errorMassage);
    }


    /**
     * 处理 From实体类 异常
     */
    @ExceptionHandler(value = BindException.class)
    public <T> Result<T> handleValidationBeanException(BindException e) {
        String errorMassage = e.getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining("; "));
        return Result.error(HttpStatus.BAD_REQUEST.value(), errorMassage);
    }
}
