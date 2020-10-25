package com.github.demo.design.creation.abstractfactory.shape;

/**
 * @author Shawn
 * @date 2019/7/2
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("draw Square");
    }
}
