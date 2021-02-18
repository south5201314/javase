package com.sunflower.string;

public class SubTurn {
    public static String subTurn(String str, int beginIndex, int endIndex) throws Exception {
        if (str == null || beginIndex < 0 || endIndex > str.length() - 1 || beginIndex >= endIndex) {
            throw new Exception();
        }
        String beginString = str.substring(0, beginIndex);
        char middleChar[] = str.substring(beginIndex, endIndex + 1).toCharArray();
        String endString = str.substring(endIndex + 1, str.length());
        for (int i = 0, j = middleChar.length - 1; i < j; i++, j--) {
            char tmpChar = middleChar[i];
            middleChar[i] = middleChar[j];
            middleChar[j] = tmpChar;
        }
        return beginString + new String(middleChar) + endString;
    }

    public static int indexNum(String str, String substr) throws Exception {
        if (str == null || substr == null) {
            throw new Exception();
        }
        int count = 0;
        int index = 0;
        while (true) {
            index = str.indexOf(substr, index);
            if (index == -1) {
                break;
            }
            count++;
            index += 1;
        }
        return count;
    }
}
