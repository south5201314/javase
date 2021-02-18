package com.sunflower.java2;

public class WindowTest2 {
    public static void main(String[] args) {
        WindowRunnable2 windowRunnable2 = new WindowRunnable2();
        Thread thread1 = new Thread(windowRunnable2);
        Thread thread2 = new Thread(windowRunnable2);
        Thread thread3 = new Thread(windowRunnable2);
        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class WindowRunnable2 implements Runnable {
    private int ticket = 100;
    @Override
    public void run() {
        while (SellingTickets());
    }

    //同步方法
    public synchronized boolean SellingTickets() {//非静态方法同步监视器：this
        //需要同步的代码
        if (ticket > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 票号为：" + ticket);
            ticket--;
        }else{
            return false;
        }
        return true;
    }
}