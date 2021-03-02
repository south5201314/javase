package com.sunflower.reflection;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

public class ReflectionTest {
    //获取Class类的实例的四种方法
    @Test
    public void Test1() throws ClassNotFoundException {
        Person person = new Person();
        Class aClass1 = person.getClass();
        Class aClass2 = Person.class;
        Class aClass3 = Class.forName("com.sunflower.reflection.Person");
        ClassLoader classLoader = getClass().getClassLoader();
        Class aClass4 = classLoader.loadClass("com.sunflower.reflection.Person");
        System.out.println(aClass1 == aClass2);//true
        System.out.println(aClass1 == aClass3);//true
        System.out.println(aClass1 == aClass4);//true
        //获取类加载器
        System.out.println(aClass3.getClassLoader().getClass().getName());//sun.misc.Launcher$AppClassLoader
        System.out.println(aClass3.getClassLoader().getParent().getClass().getName());//sun.misc.Launcher$ExtClassLoader
        System.out.println(String.class.getClassLoader());//null
        System.out.println(aClass3.getClassLoader().getParent().getParent());//null
        System.out.println(Object.class.getClassLoader()); //null
    }

    @Test
    public void TestCreateObject() throws Exception {
        //调用Class的newInstance()
        Class aClass = Class.forName("com.sunflower.reflection.Person");
        Object o = aClass.newInstance();
        System.out.println(o);//Person{name='null', age=0, wages=0.0}
        Constructor constructor = aClass.getDeclaredConstructor(String.class, int.class, float.class);
        constructor.setAccessible(true);
        Object tom = constructor.newInstance("tom", 18, 10.5f);
        System.out.println(tom);//Person{name='tom', age=18, wages=10.5}
    }

}
