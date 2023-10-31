package classes;

public class MyQueue<T> implements QueueADT<T> {
    private Object[] array;
    private int size;
    private int capacity;
    private int front;
    private int rear;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = -1;
    }

    public void enqueue(T item) {
        if (size == capacity) {
            // Queue is full, you can choose to resize the array here
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        array[rear] = item;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = (T) array[front];
        array[front] = null; // Clear the reference
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return (T) array[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            array[i] = null;
        }
        size = 0;
        front = 0;
        rear = -1;
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Queue elements: ");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();
    }
}

