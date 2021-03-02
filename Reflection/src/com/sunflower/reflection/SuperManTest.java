package com.sunflower.reflection;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class SuperManTest {
    @Test
    public void ClassTest() throws Exception {
        Class aClass = Class.forName("com.sunflower.reflection.SuperMan");
        Class[] interfaces = aClass.getInterfaces();
        for(Class inter: interfaces){
            System.out.println(inter.getName());
            //java.io.Serializable
            //com.sunflower.reflection.MyInterface
        }
        Class superclass = aClass.getSuperclass();
        System.out.println(superclass.getName());//com.sunflower.reflection.Man
    }
    @Test
    public void TestConstructor() throws ClassNotFoundException {
        Class aClass = Class.forName("com.sunflower.reflection.SuperMan");
        Constructor[] constructors = aClass.getConstructors();
        for(Constructor struct:constructors){
            System.out.println(struct.getModifiers());//1
            System.out.println(struct);//public com.sunflower.reflection.SuperMan()
        }

        Constructor[] declaredConstructors = aClass.getDeclaredConstructors();
        for(Constructor struct:declaredConstructors){
            StringBuffer constructor = new StringBuffer();
            switch (struct.getModifiers()){
                case 1:
                    constructor.append("public ");
                    break;
                case 2:
                    constructor.append("private ");
                    break;
                case 4:
                    constructor.append("protected ");
                    break;
            }
            String name = struct.getName();
            constructor.append(name+"(");
            Parameter[] parameters = struct.getParameters();//获取形参列表
            for(int i=0;i<parameters.length;i++){
                String type = parameters[i].getType().getName();//类型名称
                String arg = parameters[i].getName();//参数名称
                if(i>=parameters.length-1){
                    constructor.append(type+" "+arg+")");
                }else {
                    constructor.append(type+" "+arg+",");
                }
            }
            System.out.println(constructor);
            // public com.sunflower.reflection.SuperMan()
            // public com.sunflower.reflection.SuperMan(
            // protected com.sunflower.reflection.SuperMan(double arg0,java.lang.String arg1)
            // com.sunflower.reflection.SuperMan(double arg0,java.lang.String arg1,int arg2)
            // private com.sunflower.reflection.SuperMan(double arg0,java.lang.String arg1,int arg2,float arg3)
        }
    }
    @Test
    public void TestAnnotation() throws Exception {
        Class aClass = Class.forName("com.sunflower.reflection.SuperMan");
        Annotation[] annotations = aClass.getDeclaredAnnotations();

        for (Annotation annotation:annotations){
            System.out.println(annotation);//@com.sunflower.reflection.MyAnnotation(value=[SuperMan value1, SuperMan value2])
        }
    }
    @Test
    public void TestGeneric() throws Exception {
        Class aClass = Class.forName("com.sunflower.reflection.SuperMan");
        ParameterizedType genericSuperclass = (ParameterizedType)aClass.getGenericSuperclass();
        Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
        for (Type type:actualTypeArguments){
            System.out.println(type);
        }
    }
    @Test
    public void TestField() throws Exception {
        Class aClass = Class.forName("com.sunflower.reflection.SuperMan");
        Field count = aClass.getDeclaredField("count");//静态属性
        count.setAccessible(true);
        System.out.println(count.get(null));// 5
        count.set(null,100);
        System.out.println(count.get(null));// 100
        Object o = aClass.newInstance();

        Class superclass = aClass.getSuperclass();//得到父类的Class
        Field value = superclass.getDeclaredField("value");//得到父类中的属性
        value.setAccessible(true);
        value.set(o,"12487489");//给子类对象中的父类定义的属性赋值
        System.out.println(value.get(o));//12487489 得到属性的值
    }
}
