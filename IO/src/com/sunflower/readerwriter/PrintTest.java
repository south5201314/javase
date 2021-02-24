package com.sunflower.readerwriter;

import java.io.*;

public class PrintTest {
    public static void main(String[] args){
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.setOut(new PrintStream("printFile.txt"));
            while (true){
                String line = bfr.readLine();
                if("exit".equals(line)||"e".equals(line)){
                    break;
                }
                System.out.println(line);
                System.out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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

