package com.sunflower.Java8.FunctionalInterface;

import org.junit.jupiter.api.Test;

import java.util.function.DoubleToIntFunction;

public class FunctionalInterfaceTest {
    @Test
    public void FunctionalInterfaceTest(){
        MyFunctionalInterface<String> mFun = str -> str;
        String result = mFun.getValue("this is MyFunctionalInterface test demo");
        System.out.println(result);//this is MyFunctionalInterface test demo
    }
}
