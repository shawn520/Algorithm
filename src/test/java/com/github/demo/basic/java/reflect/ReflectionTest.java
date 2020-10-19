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

        //3. 通过反射，在Person类外部，可以通过类对象来调用其内部私有结构。
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

        //疑问：反射机制和面向对象中的封装性是不是矛盾的？如何看待？
        // 反射的特性：动态性。
        // 什么时候会使用到反射的方式？

        /**
         * 关于java.lang.Class的理解
         * 1.类的加载过程：
         *  Demo.java ----javac---> Demo.class(字节码文件)-----java----->对字节码文件解释执行
         *  将字节码文件（某个类）加载到内存中。
         *  加载到内存中的类，成为运行时类，该运行时类，作为Class的一个实例。
         */

    }

    /**
     * 获取类实例的4种方式
     */
    @Test
    public void test3() throws Exception {
        //方式1：调用运行时类的属性
        Class<Person> class1 = Person.class;
        System.out.println(class1);

        //方式2：调用运行时类的对象的getClass()方法。
        Person person = new Person();
        Class<? extends Person> class2 = person.getClass();
        System.out.println(class2);

        //方式3：调用Class的静态方法
        Class class3 = Class.forName("com.github.demo.basic.java.reflect.Person");
        System.out.println(class3);

        System.out.println(class1 == class2);
        System.out.println(class1 == class3);

        //方式4：使用类的加载器ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> class4 = classLoader.loadClass("com.github.demo.basic.java.reflect.Person");
        System.out.println(class4);
        System.out.println(class1 == class4);


    }
}
