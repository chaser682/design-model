package chaser.structural;

// 图像接口
interface Image {
    void display();
}

// 真实图像类
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image from disk: " + filename);
    }

    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// 代理图像类
class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// 在这个示例中，Image接口定义了display方法，RealImage是实际的图像加载类，而ProxyImage是代理图像类。
// 当ProxyImage的display方法被调用时，它会在需要时创建一个RealImage实例，并调用其display方法。
public class ProxyPattern {
    public static void main(String[] args) {
        Image image = new ProxyImage("sample.jpg");

        // 图像未加载，直到调用display()方法
        image.display();

        // 图像已加载，无需再次创建
        image.display();
    }
}
