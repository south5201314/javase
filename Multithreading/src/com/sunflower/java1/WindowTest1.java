package com.sunflower.java1;

public class WindowTest1 {
    public static void main(String[] args) {
        WindowThread windowThread1 = new WindowThread();
        WindowThread windowThread2 = new WindowThread();
        WindowThread windowThread3 = new WindowThread();
        windowThread1.setName("窗口1");
        windowThread2.setName("窗口2");
        windowThread3.setName("窗口3");
        windowThread1.start();
        windowThread2.start();
        windowThread3.start();
    }
}

class WindowThread extends Thread {
    private static int ticket = 100;
    @Override
    public void run() {
        while (true) {
            synchronized(WindowThread.class) {
                //需要同步的代码
                if (ticket > 0) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + " 票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
            //同步代码结束
        }
    }
}
