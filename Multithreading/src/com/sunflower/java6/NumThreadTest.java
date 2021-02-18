package com.sunflower.java6;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class NumThreadTest{
    public static void main(String[] args) {
        //3.创建一个Callable接口实现类的对象
        NumThread numThread = new NumThread();
        //4.创建FutureTask对象,Callable接口实现类的对象作为构造器参数
        FutureTask futureTask = new FutureTask(numThread);
        //5.创建Thread对象,FutureTask的对象作为构造器参数
        new Thread(futureTask).start();
        try {
            //通过get()获取Callable中call()的返回值
            Object sum = futureTask.get();
            System.out.println("总和为："+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
//1.创建一个实现Callable接口的类
class NumThread implements Callable {
    //实现call方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for(int i = 0; i <= 100;i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
