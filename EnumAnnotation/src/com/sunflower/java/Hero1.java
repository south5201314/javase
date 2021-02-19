package com.sunflower.java;

public enum Hero1 {
    ASHE("寒冰射手", 1),
    KAYLE("审判天使", 2){
        //枚举值分别实现方法
        @Override
        public String toString() {
            return this.name();
        }
    },
    JAX("武器大师", 3);
    private final String name;
    private final int id;

    Hero1(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
