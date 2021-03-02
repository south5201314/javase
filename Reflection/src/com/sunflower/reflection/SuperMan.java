package com.sunflower.reflection;

import java.io.Serializable;
@MyAnnotation({"SuperMan value1","SuperMan value2"})
public class SuperMan extends Man<String,Integer>implements Serializable,MyInterface {
    public double high;
    protected String skill;
    int id;
    private float speed;
    private static int count = 5;
    public SuperMan(){}
    protected SuperMan(double high,String skill){
        this.high = high;
        this.skill = skill;
    }
    SuperMan(double high,String skill,int id){
        this(high,skill);
        this.id = id;
    }
    @MyAnnotation({"SuperManConstructor","SuperMan(double high,String skill,int id,float speed)"})
    private SuperMan(double high,String skill,int id,float speed){
        this(high,skill,id);
        this.speed = speed;
    }

    public void Fly(){
        System.out.println("我是超人，我可以飞");
    }
    protected String Attack(){
        System.out.println("超级射线");
        return "杀死敌人";
    }
    String Speak(String s){
        return s;
    }
    @MyAnnotation({"SleepTime","day"})
    private int SleepTime(){
        return 8;
    }
    public final static int StaticTest(){
        return 1;
    }
}
