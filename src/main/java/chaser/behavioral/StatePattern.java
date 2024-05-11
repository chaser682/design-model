package chaser.behavioral;

// 状态接口
interface ElevatorState {
    void openDoors();
    void closeDoors();
    void move();
    void stop();
}

// 具体状态类：开门状态
class OpenState implements ElevatorState {
    @Override
    public void openDoors() {
        System.out.println("Doors are already open.");
    }

    @Override
    public void closeDoors() {
        System.out.println("Closing doors.");
    }

    @Override
    public void move() {
        System.out.println("Cannot move while doors are open.");
    }

    @Override
    public void stop() {
        System.out.println("Stopping while doors are open.");
    }
}

// 具体状态类：关门状态
class CloseState implements ElevatorState {
    @Override
    public void openDoors() {
        System.out.println("Opening doors.");
    }

    @Override
    public void closeDoors() {
        System.out.println("Doors are already closed.");
    }

    @Override
    public void move() {
        System.out.println("Moving.");
    }

    @Override
    public void stop() {
        System.out.println("Stopping.");
    }
}

// 上下文类：电梯
class Elevator {
    private ElevatorState state;

    public Elevator() {
        state = new CloseState(); // 初始状态为关门状态
    }

    public void setState(ElevatorState state) {
        this.state = state;
    }

    public void openDoors() {
        state.openDoors();
    }

    public void closeDoors() {
        state.closeDoors();
    }

    public void move() {
        state.move();
    }

    public void stop() {
        state.stop();
    }
}

// 在这个示例中，我们创建了一个模拟电梯系统，其中有开门状态和关门状态两个具体状态类，以及电梯类作为上下文类。
// 通过切换状态，电梯在不同状态下有不同的行为表现。这就是状态模式的基本思想。
public class StatePattern {
    public static void main(String[] args) {
        Elevator elevator = new Elevator();

        elevator.openDoors(); // 当前状态：开门
        elevator.move();      // 当前状态：开门，无法移动
        elevator.closeDoors(); // 当前状态：关门
        elevator.move();       // 当前状态：移动中
        elevator.stop();       // 当前状态：停止
        elevator.openDoors();  // 当前状态：开门
    }
}