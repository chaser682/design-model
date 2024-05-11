package chaser.behavioral;

import java.util.ArrayList;
import java.util.List;

// 中介者接口
interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}

// 具体中介者类
class ConcreteChatMediator implements ChatMediator {
    private List<User> users = new ArrayList<>();

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            if (u != user) {
                u.receiveMessage(message);
            }
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}

// 用户类
class User {
    private String name;
    private ChatMediator mediator;

    public User(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public void sendMessage(String message) {
        System.out.println(name + " 发送消息: " + message);
        mediator.sendMessage(message, this);
    }

    public void receiveMessage(String message) {
        System.out.println(name + " 收到消息: " + message);
    }
}

// 在这个示例中，ConcreteChatMediator 实现了 ChatMediator 接口，并管理用户列表。
// 每个用户对象在构造时都传递了中介者实例，以便用户可以使用中介者发送和接收消息。
public class MediatorPattern {
    public static void main(String[] args) {
        ConcreteChatMediator chatMediator = new ConcreteChatMediator();

        User user1 = new User("Alice", chatMediator);
        User user2 = new User("Bob", chatMediator);
        User user3 = new User("Charlie", chatMediator);

        chatMediator.addUser(user1);
        chatMediator.addUser(user2);
        chatMediator.addUser(user3);

        user1.sendMessage("大家好！");
        user2.sendMessage("你好，Alice！");
    }
}
