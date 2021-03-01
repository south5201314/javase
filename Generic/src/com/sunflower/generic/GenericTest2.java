package com.sunflower.generic;

import java.util.*;

public class GenericTest2 {
    public static void main(String[] args) {
        CustomGeneric<String> tom = new CustomGeneric<>("tom", 1001, "tom:1001");
        System.out.println(tom.getT());//tom:1001
        CustomGenericInterface<String,Integer> genericImplement = new GenericImplement<String,Integer,String>("jak", 98, "菜鸡");
        System.out.println(genericImplement.getT());
        String show = GenericImplement.show(genericImplement);//调用泛型方法
        System.out.println(show);//jak 98

        List<String> list = null;
        List<Date> list1 =new ArrayList<Date>();
        //list = list1; //编译错误
    }

    public static void TestAddSuper(Collection<? super CustomGenericInterface<String,Integer>> collection){
        collection.add(new GenericImplement());//CustomGenericInterface的实现类实例是可以添加的
        Iterator<?> iterator = collection.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
    }

    public static void TestAddExtends(Collection<? extends CustomGenericInterface> collection){
        /*
        编译错误，无法添加
        collection.add(new GenericImplement());
        collection.add(new Object());
        */

        Iterator<? extends CustomGenericInterface> iterator = collection.iterator();
        while (iterator.hasNext()){
            CustomGenericInterface next = iterator.next();
            System.out.println(next);
        }
    }
}
