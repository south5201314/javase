package com.sunflower.java1;

public class WindowTest {
    public static void main(String[] args) {
        WindowRunnable windowRunnable = new WindowRunnable();
        Thread thread1 = new Thread(windowRunnable);
        Thread thread2 = new Thread(windowRunnable);
        Thread thread3 = new Thread(windowRunnable);
        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class WindowRunnable implements Runnable {
    private int ticket = 100;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                //需要同步的代码
                if (ticket > 0) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
            //同步代码结束
        }
    }
}
