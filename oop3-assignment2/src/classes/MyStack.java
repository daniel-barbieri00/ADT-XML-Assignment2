package classes;

public class MyStack<T> implements StackADT<T> {
    private Object[] array;
    private int size;
    private int capacity;

    public MyStack(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
        this.size = 0;
    }

    public void push(T item) {
        if (size == capacity) {
            // Stack is full, you can choose to resize the array here
            throw new IllegalStateException("Stack is full");
        }
        array[size++] = item;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T item = (T) array[--size];
        array[size] = null; // Clear the reference
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) array[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }
}