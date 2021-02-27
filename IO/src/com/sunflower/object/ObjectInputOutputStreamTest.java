package com.sunflower.object;

import org.junit.Test;

import java.io.*;

public class ObjectInputOutputStreamTest {
    public static void main(String[] args) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("D:\\IO\\output\\object.bat"));
            Person tom = new Person("tom", 23);
            Person jak = new Person("jak", 15);
            oos.writeObject(tom);
            oos.flush();
            oos.writeObject(jak);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos !=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void TestObjectInput() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("D:\\IO\\output\\object.bat"));
            Person p1 = (Person) ois.readObject();
            System.out.println(p1);
            Person p2 = (Person) ois.readObject();
            System.out.println(p2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois !=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
