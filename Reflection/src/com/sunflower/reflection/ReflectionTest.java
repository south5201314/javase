package com.sunflower.reflection;

import org.junit.Test;

public class ReflectionTest {
    //获取Class类的实例的四种方法
    @Test
    public void Test1() throws ClassNotFoundException {
        Person person = new Person();
        Class<? extends Person> aClass1 = person.getClass();
        Class<Person> aClass2 = Person.class;
        Class<?> aClass3 = Class.forName("com.sunflower.reflection.Person");
        ClassLoader classLoader = getClass().getClassLoader();
        Class<?> aClass4 = classLoader.loadClass("com.sunflower.reflection.Person");
        System.out.println(aClass1 == aClass2);//true
        System.out.println(aClass1 == aClass3);//true
        System.out.println(aClass1 == aClass4);//true
    }

}
