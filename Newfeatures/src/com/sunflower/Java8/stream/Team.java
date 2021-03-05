package com.sunflower.Java8.stream;

import java.util.ArrayList;
import java.util.Collection;

public class Team {
    public static Collection<Student> GetTeam(){
        Collection<Student> team = new ArrayList<>();
        team.add(new Student("马云",18,Sex.Male));
        team.add(new Student("马化腾",19,Sex.Male));
        team.add(new Student("张一鸣",17,Sex.Male));
        team.add(new Student("刘强东",20,Sex.Male));
        team.add(new Student("赵丽颖",22,Sex.Female));
        team.add(new Student("迪丽热巴",21,Sex.Female));
        team.add(new Student("范冰冰",23,Sex.Female));
        team.add(new Student("杨幂",30,Sex.Female));
        team.add(new Student("刘德华",42,Sex.Male));
        team.add(new Student("彭于晏",35,Sex.Male));
        team.add(new Student("陈冠希",33,Sex.Male));
        return team;
    }
}
