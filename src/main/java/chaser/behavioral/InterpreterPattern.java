package chaser.behavioral;

// 表达式接口
interface Expression {
    int interpret();
}

// 数字表达式类
class NumberExpression implements Expression {
    private int value;

    public NumberExpression(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return value;
    }
}

// 加法表达式类
class AddExpression implements Expression {
    private Expression leftOperand;
    private Expression rightOperand;

    public AddExpression(Expression leftOperand, Expression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    @Override
    public int interpret() {
        return leftOperand.interpret() + rightOperand.interpret();
    }
}

// 减法表达式类
class SubtractExpression implements Expression {
    private Expression leftOperand;
    private Expression rightOperand;

    public SubtractExpression(Expression leftOperand, Expression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    @Override
    public int interpret() {
        return leftOperand.interpret() - rightOperand.interpret();
    }
}

// 在这个示例中，我们构建了一个简单的数学表达式解释器，用于解释并计算基本的加法和减法表达式。
// 这展示了解释器模式如何工作，将表达式解释成实际的结果。
// 在实际应用中，解释器模式可以用于更复杂的领域，如编程语言解释器或规则引擎。
public class InterpreterPattern {
    public static void main(String[] args) {
        // 构建表达式：2 + (3 - 1)
        Expression expression = new AddExpression(
                new NumberExpression(2),
                new SubtractExpression(
                        new NumberExpression(3),
                        new NumberExpression(1)
                )
        );

        // 解释并计算表达式的值
        int result = expression.interpret();
        System.out.println("Result: " + result); // 输出: Result: 4
    }
}
