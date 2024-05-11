package chaser.creational;
public class Singleton {
    // 私有静态成员变量，用于保存单例实例
    private static Singleton singletonInstance;

    // 私有构造函数
    private Singleton() {
        // 自定义
    }

    // 公有静态方法，用于获取静态实例对象
    public static Singleton getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new Singleton();
        }
        return singletonInstance;
    }

    public void showMessage() {
        System.out.println("This is a singleton!");
    }

    public static void main(String[] args) {
        // 获取单例实例
        Singleton singleton = Singleton.getInstance();

        // 调用成员方法
        singleton.showMessage();
    }
}
