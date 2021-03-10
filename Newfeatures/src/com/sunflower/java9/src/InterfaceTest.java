package com.sunflower.java9.src;

import org.junit.jupiter.api.Test;

public class InterfaceTest {
    @Test
    public void TestInterfacePrivateMethod(){
        MyInterface myInterface = new MyInterface() {
            @Override
            public void MethodAbstract() {
                System.out.println("MethodAbstract");
            }

            @Override
            public void Method() {
                System.out.println("Method");
            }
        };
        myInterface.MethodDefault();
    }
}
