package Rkc.Stack;

public class DynamicStack<T> extends Stack<T> {
    private int currentStackSize = 3;


    public DynamicStack() {
        this.data = (T[]) new Object[this.currentStackSize];
    }

    @Override
    public void push(T item) {
        if (currentIsFull()) {
            duplicateArray();
        }
        this.data[count++] = item;
    }

    @Override
    public void pushRange(T[] items) {
        int countAfterPushRange = items.length + count;
        if (countAfterPushRange > currentStackSize) {
            duplicateArray();
            pushRange(items);
        } else {
            System.arraycopy(items, 0, data, count, items.length);
            count = countAfterPushRange;
        }
    }

    @Override
    public void clear() {
        count = 0;
        this.currentStackSize = 3;
        data = (T[]) new Object[this.currentStackSize];
    }

    private boolean currentIsFull() {
        return count >= currentStackSize;
    }

    private void duplicateArray() {
        this.currentStackSize *= 2;
        T[] newData = (T[]) new Object[this.currentStackSize];
        System.arraycopy(data, 0, newData, 0, data.length);
        this.data = newData;
    }
}
