package com.github.demo.designPattern.creation.factory;

/**
 * @author Shawn
 * @date 2019/7/2
 */
public class ShapeFactory {

    public Shape getShape(String type) {
        if(null == type) {
            return null;
        }
        if(type.equalsIgnoreCase("Circle")) {
            return new Circle();
        } else if(type.equalsIgnoreCase("Square")) {
            return new Square();
        } else if(type.equalsIgnoreCase("Rectangle")) {
            return new Rectangle();
        }
        return null;
    }
}
