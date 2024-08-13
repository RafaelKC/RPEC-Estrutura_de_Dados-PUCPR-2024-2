package Rkc.Queue;

public abstract class Queue<T> implements IQueue<T> {
    protected T[] data;
    protected int base = 0;
    protected int top = 0;

    public T remove() {
        T temp = data[base];
        data[base] = null;
        base++;
        return temp;
    }

    public boolean isEmpty() {
        return top == base;
    }

    public int currentSize() {
        return top - base;
    }

    @Override
    public String toString() {
        return this.data.length + " elements";
    }
}
