package com.sunflower.java;

public class Hero {
    private Hero(String name, int id) {
        this.id = id;
        this.name = name;
    }

    private String name;
    private int id;
    public static final Hero ASHE = new Hero("寒冰射手", 1);
    public static final Hero KAYLE = new Hero("审判天使", 2);
    public static final Hero JAX = new Hero("武器大师", 3);

    @Override
    public String toString() {
        return "英雄名称:" + name + '\'' +
                ",英雄id:" + id ;
    }
}
