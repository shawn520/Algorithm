package com.github.demo.basic.java.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Shawn
 * @date 2020/10/17
 */
public class ReflectionTest {

    //反射之前，对于person的操作
    @Test
    public void test() {
        //1. 创建person类的对象
        Person person = new Person("shawn", 12);

        //2. 通过对象调用其内部的属性和方法
        person.name = "Bob";
        System.out.println(person.toString());
        person.talk();

        //3. 在Person类外部，不可以通过类的对象来调用其内部私有结构。
//        比如私有构造器，name属性，show方法等。

    }

    //反射之后，对于person的操作
    @Test
    public void test2() throws Exception {
        //1. 通过反射创建person类的对象
        Class<Person> personClass = Person.class;
        Constructor<? extends Person> constructor = personClass.getConstructor(String.class, int.class);
        Person person = constructor.newInstance("Tom", 11);

        //2. 通过对象调用其内部的属性和方法
        person.talk();
        System.out.println(person.toString());
        Field name = personClass.getDeclaredField("name");
        name.set(person, "Shawn");
        System.out.println(person.toString());

        Method talk = personClass.getMethod("talk");
        talk.invoke(person);

        //3. 通过反射，在Person类外部，可以通过类的对象来调用其内部私有结构。
        //比如私有构造器，name属性，show方法等。
        Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Person person1 = declaredConstructor.newInstance("Hellen");
        System.out.println(person1.toString());

        Field age = personClass.getDeclaredField("age");
        age.setAccessible(true);
        age.set(person1, 18);
        System.out.println(person1.toString());

        Method show = personClass.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        show.invoke(person1, "China");


    }
}
