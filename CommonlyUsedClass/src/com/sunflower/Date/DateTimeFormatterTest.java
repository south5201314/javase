package com.sunflower.Date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

public class DateTimeFormatterTest {
    public static void main(String[] args) {
        //预定义的标准格式
        DateTimeFormatter isoLocalDate = DateTimeFormatter.ISO_LOCAL_DATE;
        DateTimeFormatter isoLocalTime = DateTimeFormatter.ISO_LOCAL_TIME;
        DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = isoLocalDateTime.format(localDateTime);
        System.out.println(localDateTime);//2021-02-18T15:42:07.689
        System.out.println(format);//2021-02-18T15:42:07.689
        //本地化相关的格式
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        String format1 = dateTimeFormatter.format(localDateTime);
        System.out.println(format1);//2021年2月18日 下午03时47分36秒
        //自定义的格式
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yy-MM-dd");
        LocalDate localDate = LocalDate.now();
        String format2 = dateTimeFormatter1.format(localDate);
        System.out.println(localDate);//2021-02-18
        System.out.println(format2);//21-02-18
        TemporalAccessor parse = dateTimeFormatter1.parse("22-05-14");
        System.out.println(parse);//{},ISO resolved to 2022-05-14
    }
}
