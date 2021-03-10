package com.sunflower.java9.src;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class Operator {
    @Test
    public void OperatorTest(){
        Comparator<Object> comparator = new Comparator<>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
    }
}
