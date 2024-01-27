package com.example.studyspringboot.controller;

import com.example.studyspringboot.entity.Result;
import com.example.studyspringboot.exception.AppException;
import com.example.studyspringboot.exception.ReturnCodeMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author weekend
 */
@Slf4j
@RestController
@RequestMapping("/excel")
public class ExcelTestController {

    @PostMapping("/upload")
    public Result<String> uploadExcel(@RequestParam("file") MultipartFile file) {
        String filename = file.getOriginalFilename();
        if (null == filename || (!filename.endsWith(".xlsx") && !filename.endsWith(".xls"))) {
            throw new AppException(ReturnCodeMsg.INVALID_FILE);
        }
        if (file.getSize() > 1024 * 1024 * 10) {
            return Result.error(10002, "文件大小超过10M");
        }
        log.info("文件名：{}", filename);
        log.info("文件大小：{}", file.getSize());


        return Result.success("success");
    }

    @PostMapping("/download")
    public Result<String> downloadExcel(HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        response.setHeader("Content-Disposition", "attachment; filename=download.txt");
        response.getWriter().write("hello world");
        response.flushBuffer();
        return Result.success("success");
    }
}
