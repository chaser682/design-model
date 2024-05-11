package chaser.structural;

// 已存在的LegacyRectangle类
class LegacyRectangle {
    public void display(int x1, int y1, int x2, int y2) {
        System.out.println("LegacyRectangle: Point1(" + x1 + ", " + y1 + "), Point2(" + x2 + ", " + y2 + ")");
    }
}

// 统一的Shape接口
interface ShapeSize {
    void draw(int x, int y, int width, int height);
}

// 适配器类，将LegacyRectangle适配到Shape接口上
class RectangleAdapter implements ShapeSize {
    private LegacyRectangle legacyRectangle;

    public RectangleAdapter(LegacyRectangle legacyRectangle) {
        this.legacyRectangle = legacyRectangle;
    }

    @Override
    public void draw(int x, int y, int width, int height) {
        int x1 = x;
        int y1 = y;
        int x2 = x + width;
        int y2 = y + height;
        legacyRectangle.display(x1, y1, x2, y2);
    }
}

// 在这个示例中，LegacyRectangle是已经存在的类，而RectangleAdapter是适配器类，用于将LegacyRectangle适配到Shape接口上。
// 客户端代码通过使用适配器来画一个矩形，实际上是在调用了LegacyRectangle的display方法，但是通过适配器，它符合了Shape接口的标准。
public class AdapterPattern {
    public static void main(String[] args) {
        LegacyRectangle legacyRectangle = new LegacyRectangle();
        ShapeSize shapeAdapter = new RectangleAdapter(legacyRectangle);

        shapeAdapter.draw(10, 20, 50, 30);
    }
}