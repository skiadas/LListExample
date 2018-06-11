public class LinkedList<T> {
    private Node head;

    public boolean isEmpty() {
        return head == null;
    }

    public void addToFront(T aString) {
        Node newNode = new Node(aString);
        newNode.next = this.head;
        this.head = newNode;
    }

    public T front() {
        return head.item;
    }

    public T back() {
        Node currentNode = this.head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        return currentNode.item;
    }

    public T get(int i) {
        Node currentNode = this.head;
        while (i > 0) {
            i--;
            currentNode = currentNode.next;
        }

        return currentNode.item;
    }

    public void removeFront() {
        this.head = this.head.next;
    }

    private class Node {
        T item;
        Node next;

        Node(T item) {
            this.item = item;
            next = null;
        }
    }
}
