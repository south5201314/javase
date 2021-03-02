package com.sunflower.reflection;

public class Man<K,V> implements Comparable{
    public String name;
    protected int age;
    String sex;
    private K key;
    private V value;

    public Man(){

    }
    protected Man(K key,V value){
        this.key = key;
        this.value = value;
    }
    Man(String name,int age){
        this.name = name;
        this.age = age;
    }
    private Man(String name,int age,String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
    protected String east(String food){
        return food;
    }
    void show(){
        System.out.println("我是一个人");
    }
    private String Hobby(){
        return "我喜欢女人";
    }
}
