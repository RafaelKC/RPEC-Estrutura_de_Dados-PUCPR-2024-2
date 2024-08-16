package Rkc.Queue;

public class CircleQueue<T> extends Queue<T> {
    private final int size;
    private int count = 0;

    public CircleQueue(int size) {
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
        this.count++;
        if (this.top >= this.size) {
            this.top = 0;
        }
    }

    @Override
    public void addRange(T[] items) {
       int finalCount = this.count + items.length;

       if (finalCount > this.size) {
           throw new StackOverflowError("Rkc.Queue will be full");
       }

       for (T item : items) {
           this.add(item);
       }
    }

    @Override
    public T remove() {
        count--;
        return super.remove();
    }

    @Override
    public void clear() {
        this.data = (T[]) new Object[this.size];
        this.top = 0;
        this.base = 0;
        this.count = 0;
    }

    public int getSize() {
        return size;
    }

    public int getCount() {
        return count;
    }

    public boolean isFull() {
        return this.count >= this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }
}
