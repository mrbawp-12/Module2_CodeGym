package linkedlist_demo;

public class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList<T> {
    Node<T> head;
    Node<T> tail;

    public LinkedList() {
    }

    public void add(T data) {
        Node<T> node = new Node<>(data);

    }

}