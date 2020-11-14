package com.github.demo.design.structure.decorator;

/**
 * @author Shawn
 * @date 2020/11/14
 */
public class Milk extends Decorator {


    public Milk(Drink obj) {
        super(obj);
        this.name = "牛奶";
        this.price = 2.5f;
    }
}
