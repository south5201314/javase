package com.sunflower.generic;

import java.util.*;

public class GenericTest1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("aa");
        list.add("bb");
        //list.add(123);编译错误
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s);//aa bb
        }

        HashMap<String, Integer> map = new HashMap<>();
        map.put("tom",88);
        map.put("jax",55);
        map.put("li",76);
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
            Map.Entry<String, Integer> next = iterator1.next();
            String name = next.getKey();
            int number = next.getValue();
            System.out.println("name:"+name+" number:"+number);
        }
    }
}
