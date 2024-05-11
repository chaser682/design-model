package chaser.behavioral;

// 备忘录类
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// 原始对象类
class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento createMemento() {
        return new Memento(state);
    }

    public void restoreMemento(Memento memento) {
        state = memento.getState();
    }
}

// 管理者类
class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}

// 在这个示例中，Originator 类表示原始对象，它具有状态并能够创建和恢复备忘录。
// Memento 类表示备忘录对象，保存了特定时刻的状态。Caretaker 类负责保存和获取备忘录对象。
// 通过设置初始状态、创建备忘录、修改状态、然后恢复状态，我们可以看到备忘录模式的工作方式。
public class MementoPattern {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        // 设置初始状态
        originator.setState("State 1");
        System.out.println("Current State: " + originator.getState());

        // 创建备忘录并保存状态
        caretaker.setMemento(originator.createMemento());

        // 修改状态
        originator.setState("State 2");
        System.out.println("Updated State: " + originator.getState());

        // 恢复之前的状态
        originator.restoreMemento(caretaker.getMemento());
        System.out.println("Restored State: " + originator.getState());
    }
}
