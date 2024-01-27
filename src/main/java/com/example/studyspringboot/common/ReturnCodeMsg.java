package com.example.studyspringboot.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 自定义异常枚举
 * @author weekend
 */
@Getter
@AllArgsConstructor
public enum ReturnCodeMsg {
    /**操作成功**/
    RC100(100,"操作成功"),
    /**操作失败**/
    RC999(999,"操作失败"),
    /**服务限流**/
    RC200(200,"服务开启限流保护,请稍后再试!"),
    /**服务降级**/
    RC201(201,"服务开启降级保护,请稍后再试!"),
    /**热点参数限流**/
    RC202(202,"热点参数限流,请稍后再试!"),
    /**系统规则不满足**/
    RC203(203,"系统规则不满足要求,请稍后再试!"),
    /**授权规则不通过**/
    RC204(204,"授权规则不通过,请稍后再试!"),
    /**access_denied**/
    RC403(403,"无访问权限,请联系管理员授予权限"),
    /**access_denied**/
    RC401(401,"匿名用户访问无权限资源时的异常"),
    /**服务异常**/
    RC500(500,"系统异常，请稍后重试"),

    CLIENT_AUTHENTICATION_FAILED(1001,"客户端认证失败"),
    USERNAME_OR_PASSWORD_ERROR(1002,"用户名或密码错误"),
    UNSUPPORTED_GRANT_TYPE(1003, "不支持的认证模式"),
    INVALID_CLIENT(1004, "无效的客户端"),
    INVALID_GRANT(1005, "无效的授权"),
    INVALID_SCOPE(1006, "无效的scope"),
    INVALID_REQUEST(1007, "无效的请求"),


    INVALID_TOKEN(2001,"访问令牌不合法"),
    INVALID_TOKEN_TYPE(2002,"无效的令牌类型"),
    ACCESS_DENIED(2003,"没有权限访问该资源"),
    INVALID_CLIENT_CREDENTIALS(2004,"无效的客户端凭证"),
    INVALID_CODE(2005,"验证码无效"),
    USERNAME_ALREADY_EXISTS(2006,"用户名已经存在"),
    USERNAME_NOT_EXISTS(2007,"用户名不存在"),
    INVALID_FILE(2008,"无效的文件");

    /**自定义状态码**/
    private final int code;
    /**自定义描述**/
    private final String msg;

}
