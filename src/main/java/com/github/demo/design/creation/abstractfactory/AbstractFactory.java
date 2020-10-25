package com.github.demo.design.creation.abstractfactory;


import com.github.demo.design.creation.abstractfactory.color.Color;
import com.github.demo.design.creation.abstractfactory.shape.Shape;

/**
 * @author Shawn
 * @date 2019/7/3
 */
public abstract class AbstractFactory {

    public abstract Shape getShape(String shape);

    public abstract Color getColor(String color);
}
