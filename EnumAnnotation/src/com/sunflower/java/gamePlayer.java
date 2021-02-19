package com.sunflower.java;

public class gamePlayer {
    private String name;
    private Hero1 hero1;

    public gamePlayer() {

    }

    public gamePlayer(String name, Hero1 hero1) {
        this.name = name;
        this.hero1 = hero1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hero1 getHero() {
        return hero1;
    }

    public void setHero(Hero1 hero1) {
        this.hero1 = hero1;
    }

    @Override
    public String toString() {
        return "玩家名字："+this.name+" 选择的英雄是："+hero1.toString();
    }
}
