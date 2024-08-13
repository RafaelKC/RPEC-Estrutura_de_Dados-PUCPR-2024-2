package Rkc.Queue;

public class StaticQueue<T> extends Queue<T> {
    private final int size;

    public StaticQueue(int size) {
        this.size = size;
        this.data = (T[]) new Object[this.size];
    }

    @Override
    public void add(T item) {
        if (isFull()) {
            throw new StackOverflowError("Rkc.Queue is full");
        }
        this.data[this.top] = item;
        this.top++;
    }

    @Override
    public void addRange(T[] items) {
        int topAfterPushRange = items.length + top;
        if (topAfterPushRange > size) {
            throw new StackOverflowError("Rkc.Queue will overflow");
        }
        System.arraycopy(items, 0, data, top, items.length);
        top = topAfterPushRange;
    }

    @Override
    public void clear() {
        this.data = (T[]) new Object[this.size];
        this.top = 0;
        this.base = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isFull() {
        return this.top >= this.size;
    }
}
