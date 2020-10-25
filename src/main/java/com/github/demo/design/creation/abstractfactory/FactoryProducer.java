package com.github.demo.design.creation.abstractfactory;


import com.github.demo.design.creation.abstractfactory.color.ColorFactory;
import com.github.demo.design.creation.abstractfactory.shape.ShapeFactory;

/**
 * @author Shawn
 * @date 2019/7/3
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String factory) {

        if(null == factory) {
            return null;
        }

        if(factory.equalsIgnoreCase("Shape")) {
            return new ShapeFactory();
        } else if(factory.equalsIgnoreCase("Color")) {
            return new ColorFactory();
        }
        return null;
    }
}
