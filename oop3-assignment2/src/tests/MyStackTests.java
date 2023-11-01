package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import classes.MyStack;

public class MyStackTests {

	@Test
	public void testPushAndPop() {
        MyStack<Integer> stack = new MyStack<>(5);

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertFalse(stack.isEmpty());
        assertEquals(3, stack.size());

        assertEquals(3, stack.pop().intValue());
        assertEquals(2, stack.pop().intValue());
        assertEquals(1, stack.pop().intValue());

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }
	
	@Test
    public void testPeek() {
        MyStack<String> stack = new MyStack<>(5);

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());

        stack.push("Alice");
        stack.push("Bob");

        assertFalse(stack.isEmpty());
        assertEquals(2, stack.size());

        assertEquals("Bob", stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    public void testIsEmpty() {
        MyStack<Integer> stack = new MyStack<>(5);

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());

        stack.push(1);

        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());

        stack.pop();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }
}
