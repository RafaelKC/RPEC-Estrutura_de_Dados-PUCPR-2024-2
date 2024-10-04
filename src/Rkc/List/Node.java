package Rkc.List;

public class Node <T>{
    private T data;
    private Node<T> leftChild;
    private Node<T> rightChild;

    public Node(T data) {
        this.data = data;
    }

    public T getValue() {
        return this.data;
    }

    public void setValue(final T data) {
        this.data = data;
    }

    public Node<T> getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(final Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(final Node<T> rightChild) {
        this.rightChild = rightChild;
    }
}
