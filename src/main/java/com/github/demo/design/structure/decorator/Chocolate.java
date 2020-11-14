package com.github.demo.design.structure.decorator;

/**
 * @author Shawn
 * @date 2020/11/14
 */
public class Chocolate extends Decorator {
    public Chocolate(Drink obj) {
        super(obj);
        this.name = "巧克力";
        this.price = 3.0f;
    }
}
