package com.sunflower.java9.src;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamTest {
    @Test
    public void Test() {
        List<Integer> integers = Arrays.asList(12, 21, 14, 16, 34, 89, 76, 42, 9);
        Stream<Integer> stream = integers.stream();
        stream.takeWhile(x->x<30).forEach(System.out::println);
        System.out.println();
        Stream<Integer> stream1 = integers.stream();
        stream1.dropWhile(x->x<30).forEach(System.out::println);
    }
    @Test
    public void Test1(){
        Stream<Object> stream = Stream.ofNullable(null);
        System.out.println(stream.count());//0
    }
    @Test
    public void Test2(){
        Stream<Integer> iterate = Stream.iterate(0, x -> x < 30, x -> x + 2);
        iterate.forEach(System.out::println);
    }
    @Test
    public void Test3(){
        List<Integer> integers = Arrays.asList(1, 21, 34, 45, 99);
        Optional<List<Integer>> optional = Optional.ofNullable(integers);
        Stream<List<Integer>> stream = optional.stream();
        Stream<Integer> stream1 = stream.flatMap(integers1 -> integers1.stream());
        stream1.forEach(System.out::println);
    }
}
