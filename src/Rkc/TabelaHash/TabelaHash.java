package Rkc.TabelaHash;

import Rkc.List.LinkedList;

public abstract class TabelaHash {
    private final LinkedList<String>[] arr;

    public TabelaHash(int length) {
        this.arr = new LinkedList[length];
    }

    public boolean put(String value) {
        if (value != null) {
            var hash = this.getHashCode(value);
            var position = hash % this.getLength();

            if (this.arr[position] == null) {
                this.arr[position] = new LinkedList<>();
            }

            this.arr[position].add(value);
            return true;

        }
        return false;
    }

    public abstract int getHashCode(String value);

    private int getLength() {
        return this.arr.length;
    }


}
