package com.sunflower.proxy;

public class Star implements Occupation{
    @Override
    public void Work(String task) {
        System.out.println(task);
    }

    @Override
    public int MakeMoney() {
        System.out.println("明星一年可以赚五千万");
        return 50000000;
    }
}
