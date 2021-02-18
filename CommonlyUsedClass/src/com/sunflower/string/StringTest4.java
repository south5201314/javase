package com.sunflower.string;

public class StringTest4 {
    public static void main(String[] args) {
        String str1 = "123.66";
        float f1 = Float.parseFloat(str1);
        System.out.println(f1);//123.66
        double d = 2.556d;
        System.out.println(String.valueOf(d));//2.556
    }
}
