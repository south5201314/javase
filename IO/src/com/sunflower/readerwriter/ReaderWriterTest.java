package com.sunflower.readerwriter;

import java.io.*;
import java.util.Arrays;

public class ReaderWriterTest {
    public static void main(String[] args) {
        File readerFile = new File("ReaderFile.txt");
        File writerFile = new File("WriterFile.text");
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(readerFile);
            fw = new FileWriter(writerFile);
            int len = -1;
            char buff[] = new char[12];
            while ((len = fr.read(buff))!=-1){
                if(len != buff.length){
                    char[] chars = Arrays.copyOf(buff, len);
                    System.out.println(chars);
                }else {
                    System.out.println(buff);
                }
                fw.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr !=null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fw !=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
