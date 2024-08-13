package Rkc.Queue;

public class DynamicQueue<T> extends Queue<T> {
    private int currentSize = 5;

    public DynamicQueue() {
        this.data = (T[]) new Object[this.currentSize];
    }

    @Override
    public void add(T item) {
        if (currentIsFull()) {
            duplicateArray();
        }
        this.data[this.top] = item;
        this.top++;
    }

    @Override
    public void addRange(T[] items) {
        int topAfterPushRange = items.length + top;
        if (topAfterPushRange > currentSize) {
            duplicateArray();
            addRange(items);
        } else {
            System.arraycopy(items, 0, data, top, items.length);
            top = topAfterPushRange;
        }
    }

    @Override
    public void clear() {
        this.currentSize = 5;
        this.data = (T[]) new Object[this.currentSize];
        this.top = 0;
        this.base = 0;
    }

    private boolean currentIsFull() {
        return top >= currentSize;
    }

    private void duplicateArray() {
        this.currentSize *= 2;
        T[] newData = (T[]) new Object[this.currentSize];
        System.arraycopy(data, 0, newData, 0, data.length);
        this.data = newData;
    }
}
