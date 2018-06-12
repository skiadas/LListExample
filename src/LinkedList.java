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

    public void addToBack(T item) {

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

    public void removeBack() {
        if (this.head.next == null) {
            this.head = null;
            return;
        }
        Node currentNode = this.head;
        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = null;
    }

    public int size() {
        int currentIndex = 0;
        Node currentNode = this.head;
        while (currentNode != null) {
            currentIndex++;
            currentNode = currentNode.next;
        }
        return currentIndex;
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
