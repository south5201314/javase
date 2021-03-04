package com.sunflower.Java8.quote;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodQuoteTest {
    @Test
    public void MethodQuoteTest(){
        Consumer<String> con1 = s -> System.out.println(s);
        // 等同于:
        Consumer<String> con2 = System.out::println;
        con1.accept("System.out.println(s)");// System.out.println(s)
        con2.accept("System.out::println");// System.out::println

        Comparator<Integer> com1 = (x,y)->Integer.compare(x,y);
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com1.compare(100, 50));// 1
        System.out.println(com2.compare(100, 50));// 1


        BiFunction<String,String,Integer> biFun1 = (s1,s2)-> s1.compareTo(s2);
        BiFunction<String,String,Integer> biFun2 = String::compareTo;
        System.out.println(biFun1.apply("abc", "apc"));// -14
        System.out.println(biFun2.apply("abc", "apc"));// -14
    }
}
