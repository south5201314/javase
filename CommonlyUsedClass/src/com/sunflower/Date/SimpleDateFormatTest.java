package com.sunflower.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Date date = new Date();
        String dateStr= simpleDateFormat.format(date);
        System.out.println(dateStr);//21-2-18 下午1:49

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = simpleDateFormat1.format(date);
        System.out.println(format);//2021-02-18 01:49:22
        try {
            Date date1 = simpleDateFormat1.parse("2021-03-18 01:50:22");
            System.out.println(date1);//Thu Mar 18 01:50:22 CST 2021
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

