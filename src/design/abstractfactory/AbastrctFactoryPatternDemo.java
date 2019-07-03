package design.abstractfactory;

import design.abstractfactory.color.Color;
import design.abstractfactory.shape.Shape;

/**
 * @author Shawn
 * @date 2019/7/3
 */
public class AbastrctFactoryPatternDemo {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("Shape");
        Shape circle = shapeFactory.getShape("Circle");
        circle.draw();
        AbstractFactory colorFactory = FactoryProducer.getFactory("Color");
        Color red = colorFactory.getColor("Red");
        red.fill();

    }
}
