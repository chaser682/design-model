package chaser.creational;

/**
 * 定义一个图形接口 Shape
 */
interface Shape {
    void draw();
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Drawing a circle!");
    }
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle!");
    }
}

/**
 * 抽象工厂类 ShapeFactory，子类将实现它的方法来创建具体的图形对象
 */
abstract class ShapeFactory {
    abstract Shape createShape();
}

class CircleFactory extends ShapeFactory {

    @Override
    Shape createShape() {
        return new Circle();
    }
}

class RectangleFactory extends ShapeFactory {

    @Override
    Shape createShape() {
        return new Rectangle();
    }
}

public class FactoryMethod {

    public static void main(String[] args) {
        ShapeFactory circleFactory = new CircleFactory();
        Shape circle = circleFactory.createShape();
        circle.draw();

        ShapeFactory rectangleFactory = new RectangleFactory();
        Shape rectangle = rectangleFactory.createShape();
        rectangle.draw();
    }
}
