package com.sunflower.readerwriter;

import java.io.*;

public class BufferedInputOutputTest {
    public static void main(String[] args) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream("D:\\IO\\input\\InputFile.MP4"));
            bos = new BufferedOutputStream(new FileOutputStream("D:\\IO\\output\\OutputFile.MP4"));
            int len = -1;
            byte buff[] = new byte[1024];
            long start = System.currentTimeMillis();
            while ((len = bis.read(buff)) != -1) {
                bos.write(buff, 0, len);
            }
            long end = System.currentTimeMillis();
            System.out.println("用时：" + (end - start) + "毫秒");//412毫秒
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
