package com.sunflower.java;

import java.util.ArrayList;

public class ThreadTest {
    public static void main(String[] args) {

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        //以下代码主线程执行
        for (int i = 0;i < 100; i++){
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        //setPriority(Thread.MAX_PRIORITY);
        for (int i = 0;i < 100; i++){
            if(i % 2 == 0){
                System.out.println(getName()+":"+i);
            }
        }
    }
}


class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0;i < 100; i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
