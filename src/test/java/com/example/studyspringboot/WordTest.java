package com.example.studyspringboot;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@SpringBootTest
@Slf4j
public class WordTest {

    @Test
    public void test01() throws IOException {
        // 解析doc
        String readFilePath = "/Users/weekend/Downloads/111.doc";
        File file = new File(readFilePath);
        if(!file.exists()){
            log.error("文件不存在");
        }
        FileInputStream inputStream = new FileInputStream(readFilePath);

        HWPFDocument document = new HWPFDocument(inputStream);
        Range range = document.getRange();
        for (int i = 0; i < range.numParagraphs(); i++) {
            Paragraph paragraph = range.getParagraph(i);
            log.info("段落内容：{}",paragraph.text());
        }

        log.info("===========================================");
        // 解析docx
        String docxFilePath = "/Users/weekend/Downloads/111.docx";
        File docxFile = new File(docxFilePath);
        if(!docxFile.exists()){
            log.error("docx 文件不存在");
        }
        FileInputStream docxInputStream = new FileInputStream(docxFilePath);

        XWPFDocument docxDocument = new XWPFDocument(docxInputStream);
        List<XWPFParagraph> docxParagraphs = docxDocument.getParagraphs();
        for (XWPFParagraph paragraph : docxParagraphs) {
            log.info("段落内容：{}",paragraph.getText());
        }


    }
}
