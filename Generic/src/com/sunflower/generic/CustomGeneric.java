package com.sunflower.generic;

public class CustomGeneric<T> {
    private String name;
    private int id;
    T t;
    public CustomGeneric(){

    }
    public CustomGeneric(String name,int id,T t){
        this.name = name;
        this.id = id;
        this.t = t;
    }
    public void SetT(T t){
        this.t = t;
    }
    public T getT(){
        return this.t;
    }

    @Override
    public String toString() {
        return "CustomGeneric{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", t=" + t +
                '}';
    }
}
