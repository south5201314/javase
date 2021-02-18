package com.sunflower.Date;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();//常用
        System.out.println(instance.get(Calendar.DAY_OF_WEEK));//5 星期日是1~星期六是7
        System.out.println(instance.get(Calendar.MONDAY));// 1 一月是0，以此类推
        String property = System.getProperty("user.dir");
        System.out.println(property);
    }
}
