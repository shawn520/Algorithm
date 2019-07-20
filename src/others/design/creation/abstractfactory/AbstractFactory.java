package others.design.creation.abstractfactory;

import others.design.creation.abstractfactory.color.Color;
import others.design.creation.abstractfactory.shape.Shape;

/**
 * @author Shawn
 * @date 2019/7/3
 */
public abstract class AbstractFactory {

    public abstract Shape getShape(String shape);

    public abstract Color getColor(String color);
}
