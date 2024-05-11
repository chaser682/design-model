package chaser.structural;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

// 享元接口
interface ShapeColor {
    void draw(int x, int y);
}

// 具体享元类
class CircleColor implements ShapeColor {
    private Color color;

    public CircleColor(Color color) {
        this.color = color;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing a " + color + " circleColor at (" + x + "," + y + ")");
    }
}

// 享元工厂类
class ShapeFactory {
    private static final Map<Color, ShapeColor> circleColorMap = new HashMap<>();

    public static ShapeColor getCircleColor(Color color) {
        ShapeColor CircleColor = circleColorMap.get(color);

        if (CircleColor == null) {
            CircleColor = new CircleColor(color);
            circleColorMap.put(color, CircleColor);
        }

        return CircleColor;
    }
}

// 在这个示例中，我们定义了一个Shape接口和一个具体的CircleColor类来表示享元对象。
// ShapeFactory类负责管理共享的对象池，并通过getCircleColor方法返回共享的或新创建的圆形对象。
// 在main函数中，我们随机选择不同的颜色，并使用ShapeFactory获取对应的圆形对象，然后调用draw方法绘制它们。
public class FlyweightPattern {
    public static void main(String[] args) {
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};

        for (int i = 0; i < 20; i++) {
            Color randomColor = colors[(int) (Math.random() * colors.length)];
            ShapeColor CircleColor = ShapeFactory.getCircleColor(randomColor);
            CircleColor.draw((int) (Math.random() * 100), (int) (Math.random() * 100));
        }
    }
}
