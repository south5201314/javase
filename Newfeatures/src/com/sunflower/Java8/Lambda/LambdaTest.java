package com.sunflower.Java8.Lambda;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaTest {
    @Test
    public void TestLambda(){
        // 语法格式一：无参，无返回值
        Runnable runnable = ()-> {
            System.out.println("Hello Lambda");
        };
        runnable.run();//Hello Lambda.

        // 语法格式二：Lambda 需要一个参数，但是没有返回值
        Consumer<String> con = (String str)-> {
            System.out.println(str);
        };
        con.accept("Lambda");//Lambda

        // 语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
        Consumer<Integer> con2 = (integer)->{
            System.out.println(integer);
        };
        con2.accept(12487489);//12487489

        // 语法格式四：Lambda 若只需要一个参数时，参数的小括号可以省略
        Consumer<Float> con3 = f ->{
            System.out.println(f);
        };
        con3.accept(0.124f);//0.124

        // 语法格式五：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
        Comparator<Integer> com1 = (integer1,integer2)->{
            System.out.println("多条语句");
            return Integer.compare(integer1,integer2);
        };
        System.out.println(com1.compare(12, 2));//1

        //语法格式六：当 Lambda 体只有一条语句时，return 与大括号若有，都可以省略
        Comparator<Integer> com2 = (integer1,integer2)-> Integer.compare(integer1,integer2);
        System.out.println(com2.compare(188, 988));//-1
    }
}
