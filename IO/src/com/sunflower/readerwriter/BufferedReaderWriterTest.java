package com.sunflower.readerwriter;

import java.io.*;
import java.util.Arrays;

public class BufferedReaderWriterTest {
    public static void main(String[] args) {
        BufferedReader bfr = null;
        BufferedWriter bfw = null;
        try {
            FileReader fr = new FileReader("D:\\IO\\input\\BuffReaderFile.txt");
            FileWriter fw = new FileWriter("D:\\IO\\output\\BuffWriterFile.txt");
            bfr = new BufferedReader(fr);
            bfw = new BufferedWriter(fw);
            int len = -1;
            char buff[] = new char[1024];
            long start = System.currentTimeMillis();
            while ((len = bfr.read(buff)) != -1){
//                char[] chars = Arrays.copyOf(buff, 10);
//                System.out.println(chars);
                bfw.write(buff,0,len);
            }
            long end = System.currentTimeMillis();
            System.out.println("用时：" + (end - start) + "毫秒");//829毫秒
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bfw !=null){
                try {
                    bfw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(bfr !=null){
                try {
                    bfr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
