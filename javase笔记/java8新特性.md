[TOC]

# Lambda表达式

* Lambda 是一个匿名函数，我们可以把 Lambda 表达式理解为是一段可以 传递的代码（将代码像数据一样进行传递）。使用它可以写出更简洁、更 灵活的代码。作为一种更紧凑的代码风格，使Java的语言表达能力得到了 提升。

```java
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
```

# 函数式接口

* 只有一个抽象方法的接口，称为函数式接口。
* 我们可以在一个接口上使用 `@FunctionalInterface` 注解，这样做可以检查它是否是一个函数式接口。同时 javadoc 也会包含一条声明，说明这个接口是一个函数式接口。
* 在`java.util.function`包下定义了Java 8 的丰富的函数式接口。
* `Lambda`表达式就是一个函数式接口的实例。
```java
//自定义函数式接口
public interface MyFunctionalInterface<T> {
    T getValue(T t);
}

@Test
public void FunctionalInterfaceTest(){
    MyFunctionalInterface<String> mFun = str -> str;
    String result = mFun.getValue("this is MyFunctionalInterface test demo");
    System.out.println(result);//this is MyFunctionalInterface test demo
}
```

## Java 内置四大核心函数式接口

|        函数式接口         | 参数类型 | 返回类型 | 用途                                                         |
| :-----------------------: | :------: | :------: | :----------------------------------------------------------- |
|  `Consumer<T>`消费型接口  |    T     |   void   | 对类型为T的对象应用操作，包含方法： `void accept(T t)`       |
|  `Supplier<T>`供给型接口  |    无    |    T     | 返回类型为T的对象，包含方法：`T get()`                       |
| `Function<T,R>`函数型接口 |    T     |    R     | 对类型为T的对象应用操作，并返回结果。结果是R类型的对象。包含方法：`R apply(T t)` |
| `Predicate<T>`断定型接口  |    T     | boolean  | 确定类型为T的对象是否满足某约束，并返回 boolean 值。包含方法：`boolean test(T t)` |

## 其他接口

| 函数式接口          | 参数类型 | 返回类型 | 用途                                                         |
| ------------------- | -------- | -------- | ------------------------------------------------------------ |
| `BiFunction<T,U,R>` | T,U      | R        | 对类型为 T, U 参数应用操作，返回 R 类型的结果。包含方法为： `R apply(T t, U u)` |
| `UnaryOperator<T>`  | T        | T        | 对类型为T的对象进行一元运算，并返回T类型的 结果。包含方法为：`T apply(T t)` |
| `BinaryOperator<T>` | T,T      | T        | 对类型为T的对象进行二元运算，并返回T类型的 结果。包含方法为： `T apply(T t1, T t2)` |
| `BiConsumer<T,U>`   | T,U      | void     | 对类型为T, U 参数应用操作。 包含方法为： `void accept(T t, U u)` |
| `BiPredicate<T,U>`  | T,U      | boolean  | 包含方法为： `boolean test(T t,U u)`                         |
| `ToXxxFunction<T>`  | T        | Xxx      | 分别计算int、long、double值的函数(Xxx：int/long/double)      |
| `XxxFunction<R>`    | Xxx      | R        | 参数分别为int、long、double 类型的函数(Xxx：int/long/double) |



# 方法引用和构造器引用

## 方法引用

* 当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！
* 方法引用就是Lambda表达式。
* 要求：实现接口的抽象方法的参数列表和返回值类型，必须与被引用的方法的参数列表和返回值类型保持一致！

```java
public class MethodQuoteTest {
    @Test
    public void MethodQuoteTest(){
        //对象::方法
        Consumer<String> con1 = s -> System.out.println(s);
        // 等同于:
        Consumer<String> con2 = System.out::println;
        con1.accept("System.out.println(s)");// System.out.println(s)
        con2.accept("System.out::println");// System.out::println
        
        //类::静态方法
        Comparator<Integer> com1 = (x,y)->Integer.compare(x,y);
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com1.compare(100, 50));// 1
        System.out.println(com2.compare(100, 50));// 1
        //类::实例方法
        BiFunction<String,String,Integer> biFun1 = (s1,s2)-> s1.compareTo(s2);
        BiFunction<String,String,Integer> biFun2 = String::compareTo;
        System.out.println(biFun1.apply("abc", "apc"));// -14
        System.out.println(biFun2.apply("abc", "apc"));// -14
    }
}
```

## 构造器引用

* 要求

  * 构造器参数列表要与接口中抽象方法的参数列表一致。

  * 抽象方法的返回值即为构造器对应类的对象。

```java
public class ConstructionQuoteTest {
    @Test
    public void ConstructionQuoteTest(){
        Function<String,StringBuffer> fun1 = s -> new StringBuffer(s);
        Function<String,StringBuffer> fun2 = StringBuffer::new;
        StringBuffer sb1 = fun1.apply("s -> new StringBuffer(s)");
        System.out.println(sb1);//s -> new StringBuffer(s)
        StringBuffer sb2 = fun2.apply("StringBuffer::new");
        System.out.println(sb2);//StringBuffer::new
    }
}
```

## 数值引用

* 数组引用类似于构造器引用，把数组的“[]”当做是一个参数的构造器。

```java
public class ArrayQuoteTest {
    @Test
    public void ArrayQuoteTest(){
        Function<Integer,String[]> fun1 = len ->new String[len];
        Function<Integer,String[]> fun2 = String[]::new;
        String[] strings1 = fun1.apply(8);
        System.out.println(strings1.length); // 8
        String[] strings2 = fun2.apply(10);
        System.out.println(strings2.length); // 10
    }
}
```

# Stream API



# Optional类

