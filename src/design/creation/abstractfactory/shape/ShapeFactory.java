package design.creation.abstractfactory.shape;

import design.creation.abstractfactory.AbstractFactory;
import design.creation.abstractfactory.color.Color;


/**
 * @author Shawn
 * @date 2019/7/3
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shape) {
        if(null == shape) {
            return null;
        }
        if(shape.equalsIgnoreCase("Circle")) {
            return new Circle();
        } else if(shape.equalsIgnoreCase("Square")) {
            return new Square();
        } else if(shape.equalsIgnoreCase("Rectangle")) {
            return new Rectangle();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
