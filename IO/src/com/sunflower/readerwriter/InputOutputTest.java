package com.sunflower.readerwriter;

import java.io.*;

public class InputOutputTest {
    public static void main(String[] args) {
        File inputFile = new File("D:\\IO\\input\\InputFile.mp4");
        File outputFile = new File("D:\\IO\\output\\OutputFile.mp4");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(inputFile);
            fos = new FileOutputStream(outputFile);
            int len = -1;
            byte buff[] = new byte[1024];
            long start = System.currentTimeMillis();
            while ((len = fis.read(buff))!= -1){
                fos.write(buff,0,len);
            }
            long end = System.currentTimeMillis();
            System.out.println("复制用时："+(end - start)+"毫秒");//复制用时：1881毫秒
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis !=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fos !=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
