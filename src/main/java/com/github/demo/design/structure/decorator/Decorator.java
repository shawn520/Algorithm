package com.github.demo.design.structure.decorator;

/**
 * @author Shawn
 * @date 2020/11/14
 */
public class Decorator extends Drink {

    Drink obj;

    public Decorator(Drink obj) {
        this.obj = obj;
    }

    @Override
    public float cost() {
        return this.price + obj.cost();
    }
}
