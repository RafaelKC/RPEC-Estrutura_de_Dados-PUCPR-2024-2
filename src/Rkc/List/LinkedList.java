package Rkc.List;

import java.util.function.Predicate;

public class LinkedList<T> implements IList<T> {
    public Node<T> head;
    public Node<T> base;
    private int count = 0;


    @Override
    public void clear() {
        this.head = null;
        this.base = null;
    }

    @Override
    public void add(T t) {
        if (isEmpty()) {
            head = new Node<>(t);
            base = head;
        } else {
            Node<T> node = new Node<>(t);
            node.setLeftChild(this.head);
            this.head.setRightChild(node);
            this.head = node;
        }
        count++;
    }

    @Override
    public void add(T t, int pos) {
        if (pos < 0 || pos > count) {
            throw new IndexOutOfBoundsException();
        }
        if (pos == count) {
            this.add(t);
        } else if (pos == 0) {
           Node<T> node = new Node<>(t);
           node.setRightChild(this.base);
           this.base.setLeftChild(node);
           this.base = node;
           count++;
        } else {
            Node<T> node = new Node<>(t);
            Node<T> currentPos = this.getNode(pos);
            node.setLeftChild(currentPos.getLeftChild());
            node.setRightChild(currentPos);
            node.getLeftChild().setRightChild(node);
            currentPos.setLeftChild(node);
            count++;
        }

    }

    @Override
    public boolean remove(int pos) {
        Node<T> node = getNode(pos);
        if (node == null) {
            return false;
        }

        if (node.getLeftChild() != null) {
            node.getLeftChild().setRightChild(node.getRightChild());
        } else {
            this.base = node.getRightChild();
        }
        if (node.getRightChild() != null) {
            node.getRightChild().setLeftChild(node.getLeftChild());
        }
        else {
            this.head = node.getLeftChild();
        }
        count--;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null && this.base == null;
    }

    @Override
    public void setData(T t, int pos) {
        Node<T> node = getNode(pos);
        if (node == null) {
            throw new IndexOutOfBoundsException();
        }
        node.setValue(t);
    }

    @Override
    public T getData(int pos) {
        Node<T> node = getNode(pos);
        return node != null ? node.getValue() : null                                                                                                                                                                                                                  ;
    }

    @Override
    public int getSize() {
        return this.count;
    }

    @Override
    public int findIndex(T t) {
        Node<T> node = this.base;
        int current = 0;
        while (current < count) {
            if (node.getValue().equals(t)) {
                return current;
            }
            current++;
            node = node.getRightChild();
        }
        return -1;
    }

    @Override
    public int findIndex(Predicate<T> func) {
        Node<T> node = this.base;
        int current = 0;
        while (current < count) {
            if (func.test(node.getValue())) {
                return current;
            }
            current++;
            node = node.getRightChild();
        }
        return -1;
    }

    public Node<T> getNode(int pos) {
        float middle = (float)this.count / 2;
        boolean reverse = middle < pos;
        Node<T> node = reverse? this.head : this.base;

        int current = reverse ? count - 1 : 0;
        while (node != null) {
            if (current == pos) {
                return node;
            }
            if (reverse) current--;
            else current++;
            node = reverse? node.getLeftChild() : node.getRightChild();
        }
        return null;
    }
}