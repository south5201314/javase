package com.sunflower.string;

/**
 * boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
 * boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
 * boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始
 * boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true
 * int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
 * nt indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
 * int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
 * int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
 * 注：indexOf和lastIndexOf方法如果未找到都是返回-1
 *
 */

public class StringTest2 {
    public static void main(String[] args) {
        String str1 = "abc123a";
        System.out.println(str1.endsWith("3b"));//false
        System.out.println(str1.startsWith("a"));//true
        System.out.println(str1.startsWith("c1", 2));//true
        System.out.println(str1.contains("123"));//true
        System.out.println(str1.indexOf("c12"));//2
        System.out.println(str1.indexOf("12", 2));//3
        String str2 = "abc123abc123abc";
        System.out.println(str2.lastIndexOf("3a"));//11
        System.out.println(str2.lastIndexOf("3a", 8));//5
    }
}
