package com.github.demo.designPattern.creation.abstractfactory.color;


import com.github.demo.designPattern.creation.abstractfactory.AbstractFactory;
import com.github.demo.designPattern.creation.abstractfactory.shape.Shape;

/**
 * @author Shawn
 * @date 2019/7/3
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shape) {
        return null;
    }

    @Override
    public Color getColor(String color) {
        if(null == color) {
            return null;
        }

        if(color.equalsIgnoreCase("Red")) {
            return new Red();
        } else if(color.equalsIgnoreCase("Green")) {
            return new Green();
        } else if(color.equalsIgnoreCase("Blue")) {
            return new Blue();
        }

        return null;
    }
}
