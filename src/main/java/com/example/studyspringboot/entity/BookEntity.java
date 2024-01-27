package com.example.studyspringboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * 书本实体
 *
 * @author weekend
 * @date 2024/01/27
 */
@Data
public class BookEntity {
    @NotBlank(message = "书名不能为空")
    private String name;

    private String description;

    @Range(min = 1, max = 2000, message = "页数在1-2000之间")
    private Integer totalPage;

    private String language;

    @NotNull(message = "书本创建时间不能为空")
    @Past(message = "书本创建时间填入了还未发生的时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date createTime;
}
