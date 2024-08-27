package Rkc.List;

class Node<T> {
    public Node<T> previus;
    public Node<T> next;

    public T data;

    public Node(T data) {
        this.data = data;
    }
}
