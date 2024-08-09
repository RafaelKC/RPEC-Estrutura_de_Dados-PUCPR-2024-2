package Rkc.Stack;

public class StaticStack<T> extends Stack<T> {
    private final int stackSize;


    public StaticStack(int stackSize) {
        this.stackSize = stackSize;
        this.data = (T[]) new Object[this.stackSize];
    }

    @Override
    public void push(T item) {
        if (isFull()) {
            throw new StackOverflowError("Rkc.Stack is full");
        }
        this.data[count++] = item;
    }

    @Override
    public void pushRange(T[] items) {
        int countAfterPushRange = items.length + count;
        if (countAfterPushRange > stackSize) {
            throw new StackOverflowError("Rkc.Stack will overflow");
        }
        System.arraycopy(items, 0, data, count, items.length);
        count = countAfterPushRange;
    }

    @Override
    public void clear() {
        count = 0;
        data = (T[]) new Object[this.stackSize];
    }

    public boolean isFull() {
        return count >= stackSize;
    }
}
