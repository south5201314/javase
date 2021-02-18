package com.sunflower.Date;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class InstantTest {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant.toEpochMilli());//1613632815782
        System.out.println(instant);//2021-02-18T07:20:15.782Z 有8小时的偏移

        Instant instant1 = Instant.ofEpochSecond(10000);
        System.out.println(instant1);//1970-01-01T02:46:40Z

        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(instant);//2021-02-18T07:29:34.092Z
        System.out.println(offsetDateTime);//2021-02-18T15:29:34.092+08:00
    }
}
