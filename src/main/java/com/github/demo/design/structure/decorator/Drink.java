package com.github.demo.design.structure.decorator;

/**
 * @author Shawn
 * @date 2020/11/14
 */
public abstract class Drink {

    String name;

    float price = 0.0f;

    public abstract float cost();
}
