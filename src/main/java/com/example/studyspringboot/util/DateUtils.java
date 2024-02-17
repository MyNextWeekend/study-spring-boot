package com.example.studyspringboot.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author weekend
 */
public class DateUtils {
    /**
     * 生成指定日期范围内的每日午夜时刻列表
     *
     * @param startDate 起始日期
     * @param endDate   结束日期
     * @return 每日午夜时刻列表
     */
    public static List<Date> generateDailyMidnights(Date startDate, Date endDate) {
        // 将起始日期和结束日期转换为LocalDate对象
        LocalDate startLocalDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endLocalDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // 创建一个空的Date列表用于存储每日午夜时刻
        List<Date> result = new ArrayList<>();

        // 遍历从起始日期到结束日期的每一天
        for (LocalDate date = startLocalDate; !date.isAfter(endLocalDate); date = date.plusDays(1)) {
            // 获取当前日期的午夜时刻
            Date midnight = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
            // 将午夜时刻添加到结果列表中
            result.add(midnight);
        }
        // 返回每日午夜时刻列表
        return result;
    }

}
