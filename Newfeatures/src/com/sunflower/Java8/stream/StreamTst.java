package com.sunflower.Java8.stream;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTst {
    @Test
    public void CreateStreamTest(){
        //通过集合
        Collection<Student> students = Team.GetTeam();
        Stream<Student> stream = students.stream();
        Stream<Student> parallelStream = students.parallelStream();
        //通过数组
        int[] is = new int[]{1,8,4,9,0,11,88};
        IntStream arrayStream = Arrays.stream(is);
        //通过Stream的of()
        Stream<String> stringStream = Stream.of("qwe", "rty", "uio");
        //创建无限流
        //迭代
        Stream<Integer> iterate = Stream.iterate(0, sum -> sum + 2);
        iterate.limit(100).forEach(System.out::println);
        //生产
        Stream<Double> generate = Stream.generate(Math::random);
        generate.limit(10).forEach(System.out::println);
    }
    @Test
    public void MidOperatorTest1(){
        Collection<Student> students = Team.GetTeam();
        Stream<Student> studentStream = students.stream();
        //筛选所有男同学出来
        studentStream.filter(student -> student.getSex().equals(Sex.Male)).forEach(System.out::println);
        System.out.println();
        //通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        students.add(new Student("陈冠希",33,Sex.Male));
        students.add(new Student("陈冠希",33,Sex.Male));
        students.add(new Student("陈冠希",33,Sex.Male));
        students.add(new Student("陈冠希",33,Sex.Male));
        students.add(new Student("陈冠希",33,Sex.Male));
        students.stream().distinct().forEach(System.out::println);
        System.out.println();
        //截断,打印前五个
        students.stream().limit(5).forEach(System.out::println);
        System.out.println();
        //跳过,打印第五个后面所有的元素
        students.stream().skip(5).forEach(System.out::println);
    }
    @Test
    public void MidOperatorTest2(){
        Collection<Student> students = Team.GetTeam();
        //把name映射出来
        Stream<Student> studentStream = students.stream();
        Stream<String> nameStream = studentStream.map(student -> student.getName());
        nameStream.forEach(System.out::println);

        //把年龄映射出来，指定类型映射
        Stream<Student> studentStream1 = students.stream();
        IntStream mapToInt = studentStream1.mapToInt(student -> student.getAge());
        mapToInt.forEach(System.out::println);
        System.out.println();

        //通过年龄映射id
        Stream<Student> studentStream2 = students.stream();
        studentStream2.flatMap(student -> {
            if(student.getAge()<30){
                return Stream.of(student.getId());
            }
            return null;
        }).forEach(System.out::println);
    }

    @Test
    public void MidOperatorTest3(){
        Collection<Student> students = Team.GetTeam();
        Stream<Student> studentStream = students.stream();
        //自然排序,需要实现Comparable接口
        studentStream.sorted().forEach(System.out::println);
        System.out.println();
        //定制排序
        Stream<Student> studentStream1 = students.stream();
        studentStream1.sorted((student1,student2)-> -student1.getId()- student2.getId())
                .forEach(System.out::println);
    }
    @Test
    public void StopOperatorTest1(){
        Collection<Student> students = Team.GetTeam();
        Stream<Student> studentStream = students.stream();
        //学生是否都大于50岁
        System.out.println(studentStream.allMatch(student -> student.getAge() < 50));//true
        // 学生名单中是否有姓李的
        Stream<Student> studentStream1 = students.stream();
        System.out.println(studentStream1.anyMatch(student -> student.getName().startsWith("李")));//false
        //学生名单中是不是没有姓黄的
        Stream<Student> studentStream2 = students.stream();
        System.out.println(studentStream2.noneMatch(student ->
                student.getName().startsWith("黄")));//ture 是没有姓黄的
        //返回年龄最小的
        Stream<Student> studentStream3 = students.stream();
        //studentStream3.sorted(Comparator.comparingInt(Student::getAge)).forEach(System.out::println);
        Optional<Student> student = studentStream3.sorted().findFirst();
        Student student1 = student.get();
        System.out.println(student1);// Student{name='张一鸣', age=17, sex=Male, id=10003}
        // 返回流中的元素总数
        System.out.println(students.stream().count());// 11
    }
    @Test
    public void StopOperatorTest2(){
        Collection<Student> students = Team.GetTeam();
        Stream<Student> studentStream = students.stream();
        Stream<Integer> ageStream = studentStream.map(student -> student.getAge());
        Integer ageSum = ageStream.reduce(0, Integer::sum);
        System.out.println(ageSum);//280

        IntStream stream = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        OptionalInt optionalInt = stream.reduce(Integer::sum);
        int sum = optionalInt.orElse(100);
        System.out.println(sum);
    }
    @Test
    public void StopOperatorTest3(){
        Collection<Student> students = Team.GetTeam();
        Stream<Student> studentStream = students.stream();
        //把Name映射出来并收集到Set集合中
        Stream<String> nameStream = studentStream.map(student -> student.getName());
        Set<String> nameCollect = nameStream.collect(Collectors.toSet());
        System.out.println(nameCollect);
    }
}
