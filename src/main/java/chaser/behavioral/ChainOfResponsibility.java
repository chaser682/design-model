package chaser.behavioral;

// 首先，我们需要创建一个表示请求的类 ReimbursementRequest
class ReimbursementRequest {
    private double amount;
    private String description;

    public ReimbursementRequest(double amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}
// 然后，创建一个抽象处理者类 ReimbursementHandler
abstract class ReimbursementHandler {
    protected ReimbursementHandler successor;

    public void setSuccessor(ReimbursementHandler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(ReimbursementRequest request);
}

// 接下来，实现具体的处理者类：经理、部门主管和财务部门处理者。
class ManagerHandler extends ReimbursementHandler {
    @Override
    public void handleRequest(ReimbursementRequest request) {
        if (request.getAmount() <= 1000) {
            System.out.println("经理处理报销请求：" + request.getDescription());
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

class DepartmentHeadHandler extends ReimbursementHandler {
    @Override
    public void handleRequest(ReimbursementRequest request) {
        if (request.getAmount() <= 5000) {
            System.out.println("部门主管处理报销请求：" + request.getDescription());
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

class FinanceHandler extends ReimbursementHandler {
    @Override
    public void handleRequest(ReimbursementRequest request) {
        System.out.println("财务部门处理报销请求：" + request.getDescription());
    }
}

// 在这个示例中，报销请求会依次被经理、部门主管和财务部门处理。根据报销金额的不同，请求会被传递到适当的处理者。
public class ChainOfResponsibility {
    public static void main(String[] args) {
        ReimbursementHandler manager = new ManagerHandler();
        ReimbursementHandler departmentHead = new DepartmentHeadHandler();
        ReimbursementHandler finance = new FinanceHandler();

        manager.setSuccessor(departmentHead);
        departmentHead.setSuccessor(finance);

        ReimbursementRequest request1 = new ReimbursementRequest(800, "购买办公用品");
        ReimbursementRequest request2 = new ReimbursementRequest(3000, "参加培训");
        ReimbursementRequest request3 = new ReimbursementRequest(10000, "举办团建活动");

        manager.handleRequest(request1);
        manager.handleRequest(request2);
        manager.handleRequest(request3);
    }
}
