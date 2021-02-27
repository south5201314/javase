package com.sunflower.random;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    @Test
    public void RandomAccessFileTest() {
        RandomAccessFile rw = null;
        ByteArrayOutputStream aos = null;
        try {
            rw = new RandomAccessFile("D:\\IO\\output\\random.txt", "rw");
            aos = new ByteArrayOutputStream((int) rw.length());
            rw.seek(10);
            byte buff[] = new byte[5];
            int len;
            while ((len = rw.read(buff)) != -1) {
                aos.write(buff, 0, len);
            }
            rw.seek(10);
            rw.write("123456".getBytes());
            rw.write(aos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (rw != null) {
                try {
                    rw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (aos !=null){
                try {
                    aos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
