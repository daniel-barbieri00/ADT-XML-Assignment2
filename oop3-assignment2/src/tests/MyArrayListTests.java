package tests;

import classes.MyArrayList;

import org.junit.Test;
import static org.junit.Assert.*;

public class MyArrayListTests {
    @Test
    public void testAddAndRemove() {
        MyArrayList<Integer> list = new MyArrayList<>();

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        list.add(1);
        list.add(2);
        list.add(3);

        assertFalse(list.isEmpty());
        assertEquals(3, list.size());

        assertEquals(1, list.get(0).intValue());
        assertEquals(2, list.get(1).intValue());
        assertEquals(3, list.get(2).intValue());

        assertEquals(2, list.remove(1).intValue());
        assertEquals(2, list.size());
        assertEquals(1, list.get(0).intValue());
        assertEquals(3, list.get(1).intValue());
    }

    @Test
    public void testSet() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Alice");
        list.add("Bob");

        assertEquals("Alice", list.set(1, "Charlie"));
        assertEquals("Charlie", list.get(1));
    }

    @Test
    public void testContains() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Alice");
        list.add("Bob");

        assertTrue(list.contains("Alice"));
        assertFalse(list.contains("Eve"));
    }
}

