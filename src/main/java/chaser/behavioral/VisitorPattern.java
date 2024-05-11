package chaser.behavioral;

// 首先，我们需要定义图形形状的接口和具体类
// 图形形状接口
interface Shape {
    void accept(ShapeVisitor visitor);
}

// 圆形类
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}

// 矩形类
class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}
// 接下来，定义一个访问者接口和具体的访问者实现
// 访问者接口
interface ShapeVisitor {
    void visit(Circle circle);
    void visit(Rectangle rectangle);
}

// 面积计算访问者
class AreaCalculator implements ShapeVisitor {
    private double area;

    @Override
    public void visit(Circle circle) {
        area += Math.PI * circle.getRadius() * circle.getRadius();
    }

    @Override
    public void visit(Rectangle rectangle) {
        area += rectangle.getWidth() * rectangle.getHeight();
    }

    public double getArea() {
        return area;
    }
}
// 在这个示例中，访问者模式允许我们在不修改形状类的情况下，通过实现不同的访问者来执行不同的操作，例如计算面积。
// 这样，我们可以轻松地添加新的访问者来执行其他操作，同时保持形状类的不变。
public class VisitorPattern {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(4, 6);

        AreaCalculator areaCalculator = new AreaCalculator();
        circle.accept(areaCalculator);
        rectangle.accept(areaCalculator);

        System.out.println("Total area: " + areaCalculator.getArea());
    }
}
