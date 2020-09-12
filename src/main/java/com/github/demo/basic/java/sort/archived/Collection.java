package com.github.demo.basic.java.sort.archived;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Collection {

    public void test() {
        testSort();

    }

    public void testSort() {
        /*ArrayList<Human> humans = Lists.newArrayList(
                new Human("tomy", 22),
                new Human("tomy", 25)
        );*/
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("allen", 28));
        humans.add(new Human("tony", 22));

        humans.sort(Comparator.comparing(Human::getAge));
        System.out.println(humans);
    }


}

class Human {

    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
