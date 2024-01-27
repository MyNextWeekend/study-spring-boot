package com.example.studyspringboot.controller;

import com.example.studyspringboot.dto.BookUserDto;
import com.example.studyspringboot.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 校验请求参数控制器
 *
 * @author weekend
 * @date 2024/01/27
 */
@Slf4j
@RestController
@RequestMapping("/valida")
public class ValidaController {

    @PostMapping("/test")
    public Result<BookUserDto> test(@RequestBody @Validated BookUserDto bookUser) {
        log.info("bookUser:{}", bookUser);

        return Result.success(bookUser);
    }

}
