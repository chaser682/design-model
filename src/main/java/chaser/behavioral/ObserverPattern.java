package chaser.behavioral;

import java.util.ArrayList;
import java.util.List;

// 主题接口
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// 具体主题类
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}

// 观察者接口
interface Observer {
    void update(int state);
}

// 具体观察者类
class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(int state) {
        System.out.println(name + " 收到更新，新状态为: " + state);
    }
}

// 在这个示例中，ConcreteSubject 充当主题（被观察者），ConcreteObserver 充当观察者。
// 主题维护一个观察者列表，并在状态变化时通知所有观察者。
// 当主题的状态发生变化时，所有观察者都会被通知并更新自己的状态。
public class ObserverPattern {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        Observer observer1 = new ConcreteObserver("观察者1");
        Observer observer2 = new ConcreteObserver("观察者2");

        subject.addObserver(observer1);
        subject.addObserver(observer2);

        subject.setState(10);
        subject.setState(20);

        subject.removeObserver(observer1);

        subject.setState(30);
    }
}
