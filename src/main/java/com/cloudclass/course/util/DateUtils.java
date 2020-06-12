package com.cloudclass.course.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类DateUtils的功能描述:
 * 日期处理
 * @auther ss
 * @date 2020-06-11
 */
public class DateUtils {
    /** 时间格式(yyyy-MM-dd) */
    public final static String DATE_PATTERN = "yyyy-MM-dd";
    /** 时间格式(yyyy-MM-dd HH:mm:ss) */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public final static String YEAR_PATTERN = "yyyy";

    public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String format(Date date, String pattern) {
        if(date != null){
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }
}
