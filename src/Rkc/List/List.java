package Rkc.List;

import java.util.function.Predicate;

public abstract class List<T> implements IList<T> {
    protected T[] data;
    protected int count = 0;

    public boolean remove(int pos) {
        boolean removed = false;

        if (pos >= this.getSize()) return removed;

        for (int i = pos; i < getSize(); i++) {
            if (i + 1 == getSize()) data[i] = null;
            else data[i] = data[i + 1];
        }

        this.count--;
        return removed;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public T getData(int pos) {
        return data[pos];
    }

    public int findIndex(Predicate<T> func) {
        int resultado = -1;
        for (int i = 0; i < getSize(); i++) {
            if (func.test(data[i])) {
                resultado = i;
            }
        }
        return resultado;
    }

    public int findIndex(T t) {
        int resultado = -1;
        for (int i = 0; i < getSize(); i++) {
            if (data[i].equals(t)) {
                resultado = i;
            }
        }
        return resultado;
    }

    public int getSize() {
        return this.count;
    }
}
