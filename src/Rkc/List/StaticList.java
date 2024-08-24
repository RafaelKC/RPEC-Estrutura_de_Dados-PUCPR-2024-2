package Rkc.List;

public class StaticList<T> extends List<T> {
    private final int maxSize;

    public StaticList(int maxSize) {
        this.maxSize = maxSize;
        this.data = (T[]) new Object[this.maxSize];
    }


    @Override
    public void clear() {
        this.data = (T[]) new Object[this.maxSize];
    }

    @Override
    public void add(T t) {
        if (this.getSize() == this.maxSize) throw new IndexOutOfBoundsException();
        this.data[this.data.length - 1] = t;
        this.count++;
    }

    @Override
    public void add(T t, int pos) {
        if (this.getSize() == this.maxSize) throw new IndexOutOfBoundsException();

        T current = t;
        for (int i = pos; i < maxSize; i++) {
            this.data[i] = current;
            if (i+1 < maxSize) current = this.data[i+1];
        }
        this.count++;
    }

    @Override
    public void setData(T t, int pos) {
        this.data[pos] = t;
    }

    public boolean isFull() {
        return this.count == this.maxSize;
    }
}
