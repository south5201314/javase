package com.sunflower.readerwriter;

import java.io.*;

public class StreamReaderStreamWriterTest {
    public static void main(String[] args){
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            isr = new InputStreamReader(new FileInputStream("StreamReader.txt"), "UTF-8");
            osw = new OutputStreamWriter(new FileOutputStream("StreamWriter.txt"), "gbk");
            int len;
            char buff[] = new char[10];
            while ((len = isr.read(buff)) != -1) {
                System.out.println(buff);
                osw.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(isr!=null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(osw !=null ){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
