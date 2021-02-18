package com.sunflower.string;

/**
 * int length()：返回字符串的长度： return value.length
 * char charAt(int index)： 返回某索引处的字符return value[index]
 * boolean isEmpty()：判断是否是空字符串：return value.length == 0
 * String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写
 * String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写
 * String trim()：返回字符串的副本，忽略前导空白和尾部空白
 * boolean equals(Object obj)：比较字符串的内容是否相同
 * boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写
 * String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
 * int compareTo(String anotherString)：比较两个字符串的大小
 * String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。
 * String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
 */
public class StringTest1 {
    public static void main(String[] args) {
        String str1 = " ab2";
        System.out.println(str1.length());//4
        System.out.println(str1.charAt(1));//a
        System.out.println(str1.isEmpty());//false
        String str2 = str1.toUpperCase();
        System.out.println(str2);// AB2
        String str3 = str2.toLowerCase();
        System.out.println(str3);// ab2
        String str4 = str3.trim();
        System.out.println(str4);//ab2
        System.out.println(str1.equals(str2));//false
        System.out.println(str1.equalsIgnoreCase(str2));//true
        String str5 = str4.concat("666");
        System.out.println(str5);//ab2666
        String str6 = "ae2";
        System.out.println(str6.compareTo(str4));//3 e-b=3
        String str7 = str5.substring(2);
        System.out.println(str7);//2666
        String str8 = str5.substring(1,4);
        System.out.println(str8);//b26
    }
}
