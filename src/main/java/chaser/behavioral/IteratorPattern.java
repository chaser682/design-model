package chaser.behavioral;

import java.util.ArrayList;
import java.util.List;

// 定义一个可迭代的集合接口
interface IterableCollection<T> {
    Iterator<T> createIterator();
}

// 具体的集合类实现可迭代的集合接口
class ConcreteCollection<T> implements IterableCollection<T> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    @Override
    public Iterator<T> createIterator() {
        return new ConcreteIterator<>(items);
    }
}

// 定义迭代器接口
interface Iterator<T> {
    boolean hasNext();

    T next();
}

// 具体迭代器实现迭代器接口
class ConcreteIterator<T> implements Iterator<T> {
    private List<T> items;
    private int position = 0;

    public ConcreteIterator(List<T> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public T next() {
        if (hasNext()) {
            T item = items.get(position);
            position++;
            return item;
        }
        throw new IndexOutOfBoundsException("No more elements");
    }
}

// 在这个示例中，我们定义了一个IterableCollection接口来表示可迭代的集合，一个具体的集合类ConcreteCollection实现了这个接口，并提供了一个用于创建迭代器的方法。
// 迭代器接口Iterator定义了hasNext和next方法，具体的迭代器类ConcreteIterator实现了这个接口，并通过内部的位置追踪来遍历集合。
public class IteratorPattern {
    public static void main(String[] args) {
        ConcreteCollection<String> collection = new ConcreteCollection<>();
        collection.addItem("Item 1");
        collection.addItem("Item 2");
        collection.addItem("Item 3");

        Iterator<String> iterator = collection.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
