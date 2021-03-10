package com.sunflower.java10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class UCollection {
    @Test
    public void Test(){
        List<String> list = List.of("jjj", "uuu");
        List<String> copyList = List.copyOf(list);
        System.out.println(list == copyList);//true

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("qqq");
        list1.add("nnn");
        List<String> copyList1 = List.copyOf(list1);
        System.out.println(list1 == copyList1);//false
    }
}
