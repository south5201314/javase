package com.sunflower.java9.src;

import java.io.IOException;
import java.io.InputStreamReader;

public class TryTest {
    public static void main(String[] args) {
        //java8
//        try(InputStreamReader reader = new InputStreamReader(System.in)) {
//            char buff[] =new char[1024];
//            reader.read(buff);
//            System.out.println(new String(buff));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
        //java9
        InputStreamReader reader = new InputStreamReader(System.in);
        try (reader) {
            //编译错误
            //reader = new InputStreamReader(new FileInputStream("hello.txt"));
            char buff[] = new char[1024];
            reader.read(buff);
            System.out.println(new String(buff));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
