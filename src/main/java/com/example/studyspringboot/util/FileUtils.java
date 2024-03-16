package com.example.studyspringboot.util;

/**
 * utils文件
 *
 * @author weekend
 * @date 2024/03/16
 */
public class FileUtils {

    /**
     * 获取文件名。
     * 从给定的文件路径中提取文件名部分。
     *
     * @param filePath 文件的完整路径，包括文件名。
     * @return 仅包含文件名的字符串。
     */
    public static String getFileName(String filePath) {
        // 查找路径中最后一个斜杠的位置，以此分割出文件名
        int lastSlashIndex = filePath.lastIndexOf("/");
        // 从最后一个斜杠之后的位置开始，提取出文件名
        return filePath.substring(lastSlashIndex + 1);
    }

    /**
     * 从文件路径中获取不包含扩展名的文件名。
     *
     * @param filePath 文件的完整路径，包括文件名和扩展名。
     * @return 不包含扩展名的文件名。
     */
    public static String getFileNameWithoutExtension(String filePath) {
        // 查找文件路径中最后一个"."的索引，即扩展名的开始位置
        int lastDotIndex = filePath.lastIndexOf(".");
        // 截取字符串，返回不包含扩展名的文件名部分
        return filePath.substring(0, lastDotIndex);
    }

    /**
     * 获取文件的扩展名。
     *
     * @param filePath 文件的完整路径，包括文件名和扩展名。
     * @return 文件的扩展名。如果文件名中没有扩展名，则返回空字符串。
     */
    public static String getFileExtension(String filePath) {
        // 查找文件路径中最后一个"."的索引，以此确定扩展名的开始位置
        int lastDotIndex = filePath.lastIndexOf(".");
        // 从最后一个"."的下一个字符开始，提取出扩展名
        return filePath.substring(lastDotIndex + 1);
    }

    /**
     * 文件十六进制头部来识别文件类型
     */

}
