package com.example.studyspringboot.controller;

import com.example.studyspringboot.dto.BookDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 流控制器
 *
 * @author weekend
 * @date 2024/03/30
 */
@Slf4j
@RestController
@RequestMapping("/stream")
public class StreamController {

    @PostMapping("/test01")
    public String test01() {
        ArrayList<BookDto> list = new ArrayList<>();
        list.add(new BookDto("test01", "test01", 1, "test01", new Date()));
        list.add(new BookDto("test02", "test02", 2, "test02", new Date()));
        list.add(new BookDto("test03", "test03", 3, "test03", new Date()));

        for (BookDto bookDto : list) {
            if("test01".equals(bookDto.getName())){
                bookDto.setDescription("test01-update");
            }
        }
        List<BookDto> collect = list.stream().filter(bookDto -> "test01".equals(bookDto.getName())).collect(Collectors.toList());
        log.info(collect.toString());
        log.info("test01");
        return "test01";
    }
}
