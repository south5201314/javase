package com.sunflower.java2;

public class WindowTest3 {
    public static void main(String[] args) {
        WindowThread3 windowThread1 = new WindowThread3();
        WindowThread3 windowThread2 = new WindowThread3();
        WindowThread3 windowThread3 = new WindowThread3();
        windowThread1.setName("窗口1");
        windowThread2.setName("窗口2");
        windowThread3.setName("窗口3");
        windowThread1.start();
        windowThread2.start();
        windowThread3.start();
    }
}

class WindowThread3 extends Thread {
    private static int ticket = 100;
    @Override
    public void run() {
        while (SellingTickets());
    }

    public static synchronized boolean SellingTickets() {//静态方法同步监视器：WindowThread3.class
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
