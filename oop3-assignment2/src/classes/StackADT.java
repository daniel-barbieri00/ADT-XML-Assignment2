package classes;

public interface StackADT<T> {
    // Push an element onto the stack
    void push(T item);

    // Pop the top element from the stack and return it
    T pop();

    // Peek at the top element of the stack without removing it
    T peek();

    // Check if the stack is empty
    boolean isEmpty();

    // Get the number of elements in the stack
    int size();

    // Clear the stack
    void clear();
}
