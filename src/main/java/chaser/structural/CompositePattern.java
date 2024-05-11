package chaser.structural;

import java.util.ArrayList;
import java.util.List;

// 组件接口
interface FileSystemComponent {
    void displayInfo();
}

// 叶子节点
class File implements FileSystemComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("File: " + name);
    }
}

// 容器节点
class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components;

    public Directory(String name) {
        this.name = name;
        components = new ArrayList<>();
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void displayInfo() {
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : components) {
            component.displayInfo();
        }
    }
}

// 在这个示例中，FileSystemComponent 是组合模式的组件接口，File 是叶子节点类，而 Directory 是容器节点类。
// 通过使用这些类，我们可以构建一个具有层次结构的文件系统。
// 注意：这只是一个简单的示例，真实的组合模式可能涉及更复杂的场景和更多的功能。
public class CompositePattern {
    public static void main(String[] args) {
        // 创建文件和文件夹
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        Directory subDirectory = new Directory("Subdirectory");
        subDirectory.addComponent(file1);
        subDirectory.addComponent(file2);

        Directory rootDirectory = new Directory("Root");
        rootDirectory.addComponent(subDirectory);

        // 展示文件系统结构
        rootDirectory.displayInfo();
    }
}