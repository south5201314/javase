package com.sunflower.java4;

public class Deadlock2 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t2.front(t1);
            }
        }).start();
        t1.front(t2);
    }
}

class T1{
    public synchronized void front(T2 t2){
        System.out.println("T1 front(T2 t2)");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //到这里时t2已经被锁住,等待释放
        t2.rear();
    }
    public synchronized void rear(){
        System.out.println("T1 rear()");
    }
}

class T2{
    public synchronized void front(T1 t1){
        System.out.println("T2 front(T1 t1)");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //到这里时t1已经被锁住,等待释放
        t1.rear();
    }
    public synchronized void rear(){
        System.out.println("T2 rear()");
    }
}
