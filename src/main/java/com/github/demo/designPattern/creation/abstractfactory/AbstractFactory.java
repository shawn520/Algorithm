package com.github.demo.designPattern.creation.abstractfactory;

import com.github.designPattern.creation.abstractfactory.color.Color;
import com.github.designPattern.creation.abstractfactory.shape.Shape;

/**
 * @author Shawn
 * @date 2019/7/3
 */
public abstract class AbstractFactory {

    public abstract Shape getShape(String shape);

    public abstract Color getColor(String color);
}
