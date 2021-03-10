package com.sunflower.java10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class TypeInfer {
    @Test
    public void TestTypeInfer() {
        var list = new ArrayList<String>();
        list.add("tmo");
        for (var s : list) {
            System.out.println(s);
        }
        for (var i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void TestTypeInfer1() {
        //初始化为null。
        //var i;
        //var s = null;
        //Lambda表达式。
        Consumer consumer = c->System.out.println(c);
        //var consumer1 = c->System.out.println(c);
        // 方法引用。
        Supplier<Double> supplier =  Math::random;
        //var supplier1 =Math::random;
        // 数组静态初始化。
        int array[] = {1,3,4};
        //var array[] = {1,3,4};
    }
}
