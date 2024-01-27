package com.example.studyspringboot.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

/**
 * 图书用户实体
 *
 * @author weekend
 * @date 2024/01/27
 */
@Data
public class BookUserDto {

    @NotBlank(message = "用户姓名不能为空")
    private String name;

    @NotNull(message = "用户年龄不能为空")
    @Range(min = 1, max = 200, message = "用户年龄{min}-{max}之间")
    private Integer age;

    @NotBlank(message = "用户性别不能为空")
    @Length(max = 3, message = "用户性别不能超过{max}个字符")
    private String sex;

    @NotNull(message = "用户出生日期不能为空")
    @Past(message = "用户出生日期填入了还未发生的时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date birthday;

    @Valid
    @NotEmpty(message = "用户图书不能为空")
    private List<BookDto> books;
}
