package com.github.demo.basic.java.reflect;

import sun.reflect.ReflectionFactory;

/**
 * @author Shawn
 * @date 2020/10/17
 */
public class Person {

    public String name;
    private int age;

    public Person() {

    }

    private Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void talk() {
        System.out.println("hi, my name is " + name);
    }

    private String show(String nation) {
        System.out.println("I come from " + nation);
        return nation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
