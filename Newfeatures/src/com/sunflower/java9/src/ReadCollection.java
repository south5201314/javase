package com.sunflower.java9.src;

import org.junit.jupiter.api.Test;

import java.util.List;

public class ReadCollection {
    @Test
    public void Test1(){
        List<Object> list = List.of("jjj", 123);
        list.add(55);//抛异常：java.lang.UnsupportedOperationException
    }
}
