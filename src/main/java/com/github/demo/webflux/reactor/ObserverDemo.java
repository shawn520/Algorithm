package com.github.demo.webflux.reactor;

import java.util.Observable;

/**
 * @author Shawn
 * @date 2021/2/14
 */
public class ObserverDemo extends Observable {

    public static void main(String[] args) {
        ObserverDemo observerDemo = new ObserverDemo();
        observerDemo.addObserver((o, arg) -> {
            System.out.println("注册观察者");
        });
        observerDemo.addObserver((o, arg) -> {
            System.out.println("注册观察者2");
        });

        observerDemo.setChanged();

        observerDemo.notifyObservers();
    }
}
