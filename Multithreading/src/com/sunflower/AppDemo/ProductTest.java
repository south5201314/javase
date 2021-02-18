package com.sunflower.AppDemo;

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);
        producer.setName("生产者1");
        consumer.setName("消费者1");
        producer.start();
        consumer.start();
    }

}
class Clerk{//店员
    private int productCount = 0;
    public synchronized void producerProduct() {
        if(productCount < 20){
            productCount++;
            System.out.println(Thread.currentThread().getName()+"开始生产第"+productCount+"个产品");
            notify();
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumerProduct() {
        if(productCount > 0){
            System.out.println(Thread.currentThread().getName()+"开始消费第"+productCount+"个产品");
            productCount--;
            notify();
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Producer extends Thread{//生产者
    private Clerk clerk;
    public Producer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.producerProduct();
        }
    }
}

class Consumer extends Thread {//消费者
    private Clerk clerk;
    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumerProduct();
        }
    }
}
