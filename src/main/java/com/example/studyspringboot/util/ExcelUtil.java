// package com.example.studyspringboot.util;
//
// import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
// import org.apache.poi.ss.usermodel.*;
// import org.apache.poi.xssf.usermodel.XSSFWorkbook;
// import org.springframework.web.multipart.MultipartFile;
//
// import javax.servlet.ServletOutputStream;
// import javax.servlet.http.HttpServletResponse;
// import java.io.FileInputStream;
// import java.io.FileOutputStream;
// import java.io.IOException;
// import java.lang.reflect.Field;
// import java.util.*;
//
//
// /**
//  * @author weekend
//  */
// public class ExcelUtil {
//
//     // 创建新的Workbook
//     public static Workbook createWorkbook() {
//         return new XSSFWorkbook();
//     }
//
//     // 写入数据到Excel文件
//     public static <T> void writeDataToFile(List<T> dataList, String filePath, String sheetName, Map<String, Integer> headerMap) throws IOException {
//         Workbook workbook = createWorkbook();
//         Sheet sheet = workbook.createSheet(sheetName);
//
//         // 写入表头
//         Row headerRow = sheet.createRow(0);
//         for (String header : headerMap.keySet()) {
//             int columnIndex = headerMap.get(header);
//             Cell cell = headerRow.createCell(columnIndex);
//             cell.setCellValue(header);
//         }
//
//         // 写入数据行
//         int rowIndex = 1;
//         for (T data : dataList) {
//             Row dataRow = sheet.createRow(rowIndex++);
//             // 假设data是一个Bean对象，并且我们使用反射来获取属性值
//             Class<?> clazz = data.getClass();
//             for (Map.Entry<String, Integer> entry : headerMap.entrySet()) {
//                 String fieldName = entry.getKey();
//                 int columnIndex = entry.getValue();
//                 try {
//                     Field field = clazz.getDeclaredField(fieldName);
//                     field.setAccessible(true);
//                     Object value = field.get(data);
//                     Cell cell = dataRow.createCell(columnIndex);
//                     if (value != null) {
//                         cell.setCellValue(value.toString());
//                     }
//                 } catch (NoSuchFieldException | IllegalAccessException e) {
//                     System.err.println("Failed to access field: " + fieldName);
//                 }
//             }
//         }
//
//         try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
//             workbook.write(outputStream);
//         } finally {
//             workbook.close();
//         }
//     }
//
//     // 从Excel文件中读取数据
//     public static <T> List<T> readDataFromFile(String filePath, String sheetName, Class<T> clazz, Map<Integer, String> columnToFieldMap) throws IOException, IllegalAccessException, InstantiationException, InvalidFormatException, NoSuchFieldException {
//         Workbook workbook = WorkbookFactory.create(new FileInputStream(filePath));
//         Sheet sheet = workbook.getSheet(sheetName);
//         List<T> dataList = new ArrayList<>();
//
//         for (Row row : sheet) {
//             if (row.getRowNum() == 0) { // 跳过表头行
//                 continue;
//             }
//
//             T data = clazz.newInstance();
//             for (Cell cell : row) {
//                 int columnIndex = cell.getColumnIndex();
//                 if (columnToFieldMap.containsKey(columnIndex)) {
//                     String fieldName = columnToFieldMap.get(columnIndex);
//                     Field field = clazz.getDeclaredField(fieldName);
//                     field.setAccessible(true);
//                     Object value = convertCellValue(cell);
//                     field.set(data, value);
//                 }
//             }
//             dataList.add(data);
//         }
//
//         workbook.close();
//         return dataList;
//     }
//
//     private static Object convertCellValue(Cell cell) {
//         switch (cell.getCellTypeEnum()) {
//             case STRING:
//                 return cell.getStringCellValue();
//             case NUMERIC:
//                 if (DateUtil.isCellDateFormatted(cell)) {
//                     return cell.getDateCellValue(); // 对于日期类型
//                 } else {
//                     return cell.getNumericCellValue();
//                 }
//             case BOOLEAN:
//                 return cell.getBooleanCellValue();
//             default:
//                 return null;
//         }
//     }
//
//     // 下载Excel文件的HTTP响应处理，假设response是HttpServletResponse对象
//     public static void downloadExcelFile(HttpServletResponse response, Workbook workbook, String fileName) throws IOException {
//         response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//         response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
//         try (ServletOutputStream outputStream = response.getOutputStream()) {
//             workbook.write(outputStream);
//         } finally {
//             workbook.close();
//         }
//     }
//
//     // 上传Excel文件并返回其内容，假设file是MultipartFile对象
//     public static Workbook uploadAndReadExcelFile(MultipartFile file) throws IOException, InvalidFormatException {
//         return WorkbookFactory.create(file.getInputStream());
//     }
// }
