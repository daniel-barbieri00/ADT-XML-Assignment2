package classes;

public interface QueueADT<T> {
    // Add an element to the back of the queue
    void enqueue(T item);

    // Remove and return the element from the front of the queue
    T dequeue();

    // Peek at the element at the front of the queue without removing it
    T peek();

    // Check if the queue is empty
    boolean isEmpty();

    // Get the number of elements in the queue
    int size();

    // Clear the queue
    void clear();
}
