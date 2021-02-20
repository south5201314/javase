package com.sunflower.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionTest {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
        list1.add(123);
        list1.add(new String("555"));
        list1.add("3232");
        list1.add(new People("JAX",21));
        //添加
        ArrayList list2 = new ArrayList();
        list2.add(333);
        list2.add(12.55f);
        list2.addAll(list1);
        System.out.println(list1);//[123, 555, 3232, People{name='JAX', age=21}]
        System.out.println(list2);//[333, 12.55, 123, 555, 3232, People{name='JAX', age=21}]

        System.out.println(list1.size());// 有效元素的个数 4
        list2.clear();//清空集合
        System.out.println(list2.isEmpty());// 是否是空集合 true
        //包含
        System.out.println(list1.contains(new People("JAX", 21)));//true
        ArrayList list3 = new ArrayList();
        list3.add(123);
        list3.add("3232");
        System.out.println(list1.containsAll(list3));//true
        list3.add("666");
        System.out.println(list1.containsAll(list3));//false
        //删除
        list3.remove(new Integer(123));//如果是int型需要使用Integer，不然会使用索引的方法
        System.out.println(list3);//[555, 666]
        ArrayList list4 = new ArrayList();
        list4.add(123);
        list4.add("555");
        list4.add("777");
        list4.add("0000");
        list3.removeAll(list4);//差集
        System.out.println(list3);//[666]

        ArrayList list5 = new ArrayList();
        list5.add(999);
        list5.add("555");
        list5.add("777");
        list4.retainAll(list5);//交集
        System.out.println(list4);//[555, 777]
        System.out.println(list4.equals(list5));//false
        //转换成数组
        Object[] objects = list5.toArray();
        for (int i=0;i<objects.length;i++){
            System.out.println(objects[i]);//999 555 777
        }

        System.out.println(list5.hashCode());//返回对象哈希值
        Iterator iterator = list5.iterator();//返回迭代器对象


    }
}
