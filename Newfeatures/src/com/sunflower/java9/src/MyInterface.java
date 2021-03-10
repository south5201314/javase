package com.sunflower.java9.src;

interface MyInterface {
    abstract void MethodAbstract();
    void Method();
    default void MethodDefault(){
        System.out.println("MethodDefault");
        MethodPrivate();
    }
    private void MethodPrivate(){
        System.out.println("MethodPrivate");
    }
    static void StaticMethod(){
        System.out.println("StaticMethod");
    }
}
