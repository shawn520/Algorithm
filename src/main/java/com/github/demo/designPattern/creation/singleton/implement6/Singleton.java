package com.github.demo.designPattern.creation.singleton.implement6;

/**
 * 单例模式的枚举实现
 * 优点:更简洁，自动支持序列化机制，绝对防止多次实例化,避免多线程同步
 * @author Shawn
 * @date 2019/7/1
 */
public enum  Singleton {
    INSTANCE;


    public void showMsg() {
        System.out.println("Hello World!");
    }
}
