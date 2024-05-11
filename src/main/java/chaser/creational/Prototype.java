package chaser.creational;

// 创建一个实现 Cloneable 接口的原型类
class Color implements Cloneable {
    private String type;

    public Color(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public Color clone() {
        try {
            return (Color) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
public class Prototype {
    public static void main(String[] args) {
        // 创建原型对象
        Color red = new Color("Red");

        // 克隆原型对象来创建对象
        Color clone = red.clone();
        clone.setType("Blue");

        // 输出原型对象和克隆对象的类型
        System.out.println("Original Shape Type: " + red.getType());
        System.out.println("Cloned Shape Type: " + clone.getType());
    }
}
