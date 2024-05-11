package chaser.creational;

/**
 * 定义一个操作系统接口 OperatingSystem
 */
interface OperatingSystem {
    void run();
}

// 具体产品：Windows操作系统
class WindowsOS implements OperatingSystem {
    @Override
    public void run() {
        System.out.println("Running Windows OS");
    }
}

// 具体产品：Linux操作系统
class LinuxOS implements OperatingSystem {
    @Override
    public void run() {
        System.out.println("Running Linux OS");
    }
}

// 抽象产品接口：应用程序
interface Application {
    void open();
}

// 具体产品：Word应用程序
class WordApplication implements Application {
    @Override
    public void open() {
        System.out.println("Opening Word Application");
    }
}

// 具体产品：Excel应用程序
class ExcelApplication implements Application {
    @Override
    public void open() {
        System.out.println("Opening Excel Application");
    }
}

// 抽象工厂接口
interface SoftwareFactory {
    OperatingSystem createOperatingSystem();
    Application createApplication();
}

// 具体工厂：Windows工厂
class WindowsFactory implements SoftwareFactory {
    @Override
    public OperatingSystem createOperatingSystem() {
        return new WindowsOS();
    }

    @Override
    public Application createApplication() {
        return new ExcelApplication();
    }
}

// 具体工厂：Linux工厂
class LinuxFactory implements SoftwareFactory {
    @Override
    public OperatingSystem createOperatingSystem() {
        return new LinuxOS();
    }

    @Override
    public Application createApplication() {
        return new WordApplication();
    }
}

public class AbstractFactory {

    public static void main(String[] args) {
        SoftwareFactory windowsFactory = new WindowsFactory();
        OperatingSystem windows = windowsFactory.createOperatingSystem();
        Application excel = windowsFactory.createApplication();
        windows.run();
        excel.open();

        SoftwareFactory linuxFactory = new LinuxFactory();
        OperatingSystem linux = linuxFactory.createOperatingSystem();
        Application word = linuxFactory.createApplication();
        linux.run();
        word.open();
    }
}
