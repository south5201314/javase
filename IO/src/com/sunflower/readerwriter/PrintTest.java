package com.sunflower.readerwriter;

import java.io.*;

public class PrintTest {
    public static void main(String[] args) {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        PrintStream printTest = null;
        try {
            printTest = new PrintStream("printTest.txt");//打印流
            System.setOut(new PrintStream("printFile.txt"));//重新设置打印输出位置
            while (true) {
                String line = bfr.readLine();
                if ("exit".equals(line) || "e".equals(line)) {
                    break;
                }
                System.out.println(line);
                printTest.println(line);
                System.out.flush();
                printTest.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bfr != null) {
                try {
                    bfr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (printTest != null) {
                printTest.close();
            }
        }

    }
}

