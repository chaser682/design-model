package chaser.behavioral;

// 首先，我们定义一个接口 MathOperation，表示数学操作的策略
// 定义策略接口
interface MathOperation {
    int operate(int a, int b);
}

// 实现加法策略
class Addition implements MathOperation {
    @Override
    public int operate(int a, int b) {
        return a + b;
    }
}

// 实现减法策略
class Subtraction implements MathOperation {
    @Override
    public int operate(int a, int b) {
        return a - b;
    }
}

// 实现乘法策略
class Multiplication implements MathOperation {
    @Override
    public int operate(int a, int b) {
        return a * b;
    }
}
// 然后，我们创建一个 Calculator 类，它接受一个数学操作策略，并根据用户的选择执行相应的操作
class Calculator {
    private MathOperation operation;

    public void setOperation(MathOperation operation) {
        this.operation = operation;
    }

    public int performOperation(int a, int b) {
        if (operation != null) {
            return operation.operate(a, b);
        }
        throw new IllegalStateException("No operation set");
    }
}
// 在这个示例中，我们通过创建不同的数学操作策略类来实现加法、减法和乘法功能，并通过设置不同的策略来执行不同的操作。这就是策略模式的基本思想。
public class StrategyPattern {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.setOperation(new Addition());
        int result1 = calculator.performOperation(5, 3);
        System.out.println("Addition Result: " + result1);

        calculator.setOperation(new Subtraction());
        int result2 = calculator.performOperation(10, 4);
        System.out.println("Subtraction Result: " + result2);

        calculator.setOperation(new Multiplication());
        int result3 = calculator.performOperation(6, 2);
        System.out.println("Multiplication Result: " + result3);
    }
}
