package com.sunflower.reflection;

public class Person {
    public String name;
    private int age;
    private float wages;
    public Person(){

    }
    private Person(String name,int age,float wages){
        this.name=name;
        this.age=age;
        this.wages=wages;
    }
    public void show(){
        System.out.println("Person show()");
    }
    private float Bonus(){
        return wages*3;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", wages=" + wages +
                '}';
    }
}
