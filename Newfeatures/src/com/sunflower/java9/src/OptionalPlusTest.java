package com.sunflower.java9.src;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

public class OptionalPlusTest {
    @Test
    public void OptionalPlusTest(){
        ArrayList<String> list = new ArrayList<>();
        list.add("jjj");
        list.add("bbb");
        Optional<ArrayList<String>> op = Optional.of(list);
        //op = Optional.empty();
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("uuu");
        Optional<ArrayList<String>> orList = op.or(() -> Optional.of(list1));
        System.out.println(orList);//Optional[[jjj, bbb]]
    }
}
