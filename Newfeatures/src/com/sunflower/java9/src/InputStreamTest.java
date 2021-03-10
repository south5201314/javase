package com.sunflower.java9.src;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputStreamTest {
    @Test
    public void Test(){
        try(FileInputStream inputStream = new FileInputStream("in.txt");
            FileOutputStream outputStream = new FileOutputStream("out.txt")) {
            inputStream.transferTo(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
