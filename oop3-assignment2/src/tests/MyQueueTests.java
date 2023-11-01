package tests;

import classes.MyQueue;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyQueueTests {
    @Test
    public void testEnqueueAndDequeue() {
        MyQueue<Integer> queue = new MyQueue<>(5);

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertFalse(queue.isEmpty());
        assertEquals(3, queue.size());

        assertEquals(1, queue.dequeue().intValue());
        assertEquals(2, queue.dequeue().intValue());
        assertEquals(3, queue.dequeue().intValue());

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void testPeek() {
        MyQueue<String> queue = new MyQueue<>(5);

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());

        queue.enqueue("Alice");
        queue.enqueue("Bob");

        assertFalse(queue.isEmpty());
        assertEquals(2, queue.size());

        assertEquals("Alice", queue.peek());
        assertEquals(2, queue.size());
    }

    @Test
    public void testIsEmpty() {
        MyQueue<Integer> queue = new MyQueue<>(5);

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());

        queue.enqueue(1);

        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());

        queue.dequeue();

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }
}
