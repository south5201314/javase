package com.sunflower.java2;

import java.util.concurrent.locks.ReentrantLock;

public class WindowTest4 {
    public static void main(String[] args) {
        WindowRunnable4 windowRunnable4 = new WindowRunnable4();
        Thread thread1 = new Thread(windowRunnable4);
        Thread thread2 = new Thread(windowRunnable4);
        Thread thread3 = new Thread(windowRunnable4);
        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class WindowRunnable4 implements Runnable {
    private int ticket = 100;
    //1.实例化ReentrantLock
    private  ReentrantLock reentrantLock= new ReentrantLock();
    @Override
    public void run() {
        while (SellingTickets());
    }

    //同步方法
    public  boolean SellingTickets() {//非静态方法同步监视器：this
        //2.上锁,调用lock()
        reentrantLock.lock();
        try {
            //需要同步的代码
            if (ticket > 0) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 票号为：" + ticket);
                ticket--;
            }
        } finally {
            //3.解锁,调用unlock()
            reentrantLock.unlock();
            if(ticket <= 0){
                return false;
            }
        }
        return true;
    }
}