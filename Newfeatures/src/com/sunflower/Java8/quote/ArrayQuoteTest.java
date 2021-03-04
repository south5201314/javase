package com.sunflower.Java8.quote;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class ArrayQuoteTest {
    @Test
    public void ArrayQuoteTest(){
        Function<Integer,String[]> fun1 = len ->new String[len];
        Function<Integer,String[]> fun2 = String[]::new;
        String[] strings1 = fun1.apply(8);
        System.out.println(strings1.length); // 8
        String[] strings2 = fun2.apply(10);
        System.out.println(strings2.length); // 10
    }
}
