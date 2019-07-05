package design.creation.factory;

/**
 * 工厂模式的Demo实现
 * @author Shawn
 * @date 2019/7/2
 */
public class ShapeFactoryDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("Circle");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("Square");
        shape2.draw();

        Shape shape3 = shapeFactory.getShape("Rectangle");
        shape3.draw();
    }
}
