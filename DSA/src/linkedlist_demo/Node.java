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
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        }else {
            this.tail.next = node;
            this.tail = node;
        }
    }

    public void  showLinkedList() {
        Node<T> currentNode = this.head;
        while (true) {
            System.out.println(currentNode.data + "; ");
            currentNode = currentNode.next;
            if (currentNode == null) break;
        }
    }

    class Main{
        public static void main(String[] args) {
            LinkedList<Integer> list = new LinkedList<>();
            list.add(1);
            list.add(12);
            list.add(45);
            list.add(33);
            list.showLinkedList();
        }
    }

}