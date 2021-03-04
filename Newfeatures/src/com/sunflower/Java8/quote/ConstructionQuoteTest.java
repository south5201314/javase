package com.sunflower.Java8.quote;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class ConstructionQuoteTest {
    @Test
    public void ConstructionQuoteTest(){
        Function<String,StringBuffer> fun1 = s -> new StringBuffer(s);
        Function<String,StringBuffer> fun2 = StringBuffer::new;
        StringBuffer sb1 = fun1.apply("s -> new StringBuffer(s)");
        System.out.println(sb1);//s -> new StringBuffer(s)
        StringBuffer sb2 = fun2.apply("StringBuffer::new");
        System.out.println(sb2);//StringBuffer::new
    }
}
