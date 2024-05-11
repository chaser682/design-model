package chaser.behavioral;

// 模板类
abstract class AbstractClass {
    // 模板方法，定义算法的骨架
    public void templateMethod() {
        step1();
        step2();
        step3();
    }

    // 基本方法，子类需要实现
    abstract void step1();
    abstract void step2();
    abstract void step3();
}

// 具体子类实现
class ConcreteClass extends AbstractClass {
    @Override
    void step1() {
        System.out.println("ConcreteClass: Step 1");
    }

    @Override
    void step2() {
        System.out.println("ConcreteClass: Step 2");
    }

    @Override
    void step3() {
        System.out.println("ConcreteClass: Step 3");
    }
}

// 在上面的示例中，AbstractClass 是模板类，定义了一个包含三个步骤的模板方法 templateMethod
// 这些步骤由抽象方法 step1、step2 和 step3 构成。ConcreteClass 是具体子类，继承自 AbstractClass，它实现了基本方法来完成每个步骤的具体行为。
// 在 main 方法中，我们创建了一个 ConcreteClass 实例并调用了 templateMethod，这会按照模板的结构执行具体的步骤。
public class TemplateMethod {
    public static void main(String[] args) {
        AbstractClass template = new ConcreteClass();
        template.templateMethod();
    }
}