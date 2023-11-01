package classes;

public class MyArrayList<E> implements ListADT<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public MyArrayList() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Invalid initial capacity");
        }
        this.array = new Object[initialCapacity];
        this.size = 0;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > array.length) {
            int newCapacity = Math.max(array.length * 2, minCapacity);
            Object[] newArray = new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
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

    public boolean add(int index, E toAdd) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }

        ensureCapacity(size + 1);

        if (toAdd == null) {
            throw new NullPointerException("Null elements are not allowed");
        }

        if (index < size) {
            for (int i = size; i > index; i--) {
                array[i] = array[i - 1];
            }
        }

        array[index] = toAdd;
        size++;
        return true;
    }

    public boolean add(E toAdd) {
        if (toAdd == null) {
            throw new NullPointerException("Null elements are not allowed");
        }

        ensureCapacity(size + 1);
        array[size] = toAdd;
        size++;
        return true;
    }

    public boolean addAll(ListADT<? extends E> toAdd) {
        ensureCapacity(size + toAdd.size());

        for (int i = 0; i < toAdd.size(); i++) {
            add((E) toAdd.get(i));
        }
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        return (E) array[index];
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }

        E removedElement = (E) array[index];
        if (index < size - 1) {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
        }
        array[size - 1] = null; // Clear the reference
        size--;
        return removedElement;
    }

    public E remove(E toRemove) {
        if (toRemove == null) {
            throw new NullPointerException("Null elements are not allowed");
        }

        for (int i = 0; i < size; i++) {
            if (toRemove.equals(array[i])) {
                return remove(i);
            }
        }
        return null;
    }

    public E set(int index, E toChange) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }

        if (toChange == null) {
            throw new NullPointerException("Null elements are not allowed");
        }

        E previousElement = (E) array[index];
        array[index] = toChange;
        return previousElement;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E toFind) {
        if (toFind == null) {
            throw new NullPointerException("Null elements are not allowed");
        }

        for (int i = 0; i < size; i++) {
            if (toFind.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    public E[] toArray(E[] toHold) {
        if (toHold == null) {
            throw new NullPointerException("Specified array is null");
        }

        if (toHold.length < size) {
            toHold = (E[]) new Object[size];
        }

        for (int i = 0; i < size; i++) {
            toHold[i] = (E) array[i];
        }

        if (size < toHold.length) {
            toHold[size] = null;
        }

        return toHold;
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public Iterator<E> iterator() {
        return null;
    }

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("List elements:");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        list.remove(1);
        System.out.println("List elements after removing element at index 1:");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}