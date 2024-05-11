package chaser.structural;

// 子系统：音响
class StereoSystem {
    public void turnOn() {
        System.out.println("Stereo System is turned on");
    }

    public void turnOff() {
        System.out.println("Stereo System is turned off");
    }
}

// 子系统：投影仪
class Projector {
    public void turnOn() {
        System.out.println("Projector is turned on");
    }

    public void turnOff() {
        System.out.println("Projector is turned off");
    }
}

// 子系统：灯光控制
class LightsControl {
    public void turnOn() {
        System.out.println("Lights are turned on");
    }

    public void turnOff() {
        System.out.println("Lights are turned off");
    }
}

// 外观类：家庭影院外观
class HomeTheaterFacade {
    private StereoSystem stereo;
    private Projector projector;
    private LightsControl lights;

    public HomeTheaterFacade() {
        stereo = new StereoSystem();
        projector = new Projector();
        lights = new LightsControl();
    }

    public void watchMovie() {
        System.out.println("Getting ready to watch a movie...");
        lights.turnOff();
        projector.turnOn();
        stereo.turnOn();
    }

    public void endMovie() {
        System.out.println("Ending the movie...");
        stereo.turnOff();
        projector.turnOff();
        lights.turnOn();
    }
}

// HomeTheaterFacade充当了一个外观类，封装了音响、投影仪和灯光控制等子系统的复杂操作，以便客户端可以通过简单的调用来完成观影过程。
// 这样，客户端不需要了解各个子系统的具体操作，只需通过外观类的方法来控制整个家庭影院系统的行为。
public class Facade {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();

        // 准备观影
        homeTheater.watchMovie();

        // 结束观影
        homeTheater.endMovie();
    }
}