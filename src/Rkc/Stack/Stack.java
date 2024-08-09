package Rkc.Stack;

import java.util.NoSuchElementException;

public abstract class Stack<T> implements IStack<T> {
    protected int count = 0;
    protected T[] data;

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return data[--count];
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return data[0];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int currentSize() {
        return count;
    }
}
