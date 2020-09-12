package com.github.demo.designPattern.creation.abstractfactory.shape;

/**
 * @author Shawn
 * @date 2019/7/2
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("draw rectangle");
    }
}
