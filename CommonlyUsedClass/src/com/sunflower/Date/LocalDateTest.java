package com.sunflower.Date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalField;

public class LocalDateTest {
    public static void main(String[] args) {
        //创建对象
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 12, 5, 15, 25, 57);
        //获取日期信息
        System.out.println(localDateTime1.getDayOfYear());//340
        System.out.println(localDateTime1.getMonth());//DECEMBER
        System.out.println(localDateTime1.getMonthValue());//12
        //设置值并返回一个新的对象，原有的对象不会被改变，不可变性
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(25);
        System.out.println(localDateTime);//2021-02-18T14:57:42.747
        System.out.println(localDateTime2);//2021-02-25T14:57:42.747
        //添加
        LocalDateTime localDateTime3 = localDateTime.plusDays(10);
        System.out.println(localDateTime);//2021-02-18T15:01:00.036
        System.out.println(localDateTime3);//2021-02-28T15:01:00.036
        //减去
        LocalDateTime localDateTime4 = localDateTime.minusMonths(3);
        System.out.println(localDateTime);//2021-02-18T15:03:11.811
        System.out.println(localDateTime4);//2020-11-18T15:03:11.811
    }
}
