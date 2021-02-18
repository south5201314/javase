package com.sunflower.string;

/**
 * String replace(char oldChar, char newChar)：返回一个新的字符串，它是
 * 通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
 * String replace(CharSequence target, CharSequence replacement)：使
 * 用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
 * String replaceAll(String regex, String replacement) ： 使 用 给 定 的
 * replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
 * string replaceFirst(String regex, String replacement) ： 使 用 给 定 的
 * replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
 * boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。
 * String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。
 * String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此
 * 字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。
 */
public class StringTest3 {
    public static void main(String[] args) {
        String str1 = "abc123";
        String str2 = str1.replace('a','w');
        System.out.println(str2);//wbc123
        String str3 = str1.replace("bc","gf");
        System.out.println(str3);//agf123
        try {
            String s =SubTurn.subTurn("0123456789",0, 9);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(SubTurn.indexNum("010201020102", "0"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
