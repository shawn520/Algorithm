package com.github.demo.designPattern.creation.singleton.implement1;

/**
 * @author Shawn
 * @date 2019/7/1
 */
public class SingletonDemo {

    public static void main(String[] args) {

        Singleton object = Singleton.getInstance();

        object.showMsg();
    }
}
