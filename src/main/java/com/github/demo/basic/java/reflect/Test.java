package com.github.demo.basic.java.reflect;

/**
 * @author Shawn
 * @date 2019/8/13
 */
class Base {
    public void f() {
        System.out.println("Base");
    }
}
class Sub extends Base {
    @Override
    public void f() {
        System.out.println("Sub");
    }
}
public class Test {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("com.github.basic.java.reflect.Sub");
            Base b = (Base)(c.newInstance());
            b.f();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
