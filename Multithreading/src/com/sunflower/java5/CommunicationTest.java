package com.sunflower.java5;

public class CommunicationTest {
    public static void main(String[] args) {
        NumberRunnable numberRunnable = new NumberRunnable();
        Thread thread1 = new Thread(numberRunnable);
        Thread thread2 = new Thread(numberRunnable);
        thread1.setName("线程1");
        thread2.setName("线程2");
        thread1.start();
        thread2.start();
    }
}

class NumberRunnable implements Runnable{
   private int number = 0;
   Object object = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized (object) {
                //唤醒线程
                object.notify();
                if (number <= 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "number:" + number);
                    number++;
                    try {
                        //进入阻塞状态,释放锁
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
