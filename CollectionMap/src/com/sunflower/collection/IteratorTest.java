package com.sunflower.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class IteratorTest {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("555");
        arrayList.add("666");
        arrayList.add(1247);
        for(Object o:arrayList){
            System.out.println(o);
        }

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        LinkedList linkedList = new LinkedList();
    }
}
