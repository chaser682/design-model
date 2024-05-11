package chaser.behavioral;

// 命令接口
interface Command {
    void execute();
}

// 具体命令：控制电灯打开
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// 具体命令：控制电灯关闭
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// 电灯类
class Light {
    void turnOn() {
        System.out.println("Light is on");
    }

    void turnOff() {
        System.out.println("Light is off");
    }
}

// 遥控器类
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// 在这个示例中，我们使用命令模式创建了两种具体的命令：打开电灯和关闭电灯。
// 遥控器可以设置不同的命令，然后按下按钮触发相应的操作。
// 这样，命令发送者（遥控器）和命令接收者（电灯）之间实现了解耦。
public class CommandPattern {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(livingRoomLightOn);
        remote.pressButton(); // 打开电灯

        remote.setCommand(livingRoomLightOff);
        remote.pressButton(); // 关闭电灯
    }
}
