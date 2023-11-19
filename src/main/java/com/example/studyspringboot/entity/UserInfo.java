package com.example.studyspringboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.groups.Default;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserInfo {
    private int id;

    @NotBlank(message = "账号不能为空", groups = Insert.class) //指定规则对某一个分组生效
    @Length(message = "账号不能超过{max}个字符", max = 10)
    private String user_name;

    private String name;

    @NotBlank(message = "密码不能为空", groups = {Insert.class, Update.class}) // 指定规则对多个分组生效
    @Length(message = "密码不能超过{max}个字符", max = 10)
    private String pwd;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private String create_time;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private String update_time;

    private Integer teacher_id;

    public interface Insert extends Default { //声明分组标识 继承【Default】 没有分组标识的走Default
    }

    public interface Update extends Default { //声明分组标识 继承【Default】 没有分组标识的走Default
    }
}
