public class LinkedList<T> {
    private Node head;

    public boolean isEmpty() {
        return head == null;
    }

    public void addToFront(T aString) {
        head = new Node(aString);
    }

    public T front() {
        return head.item;
    }

    private class Node {
        T item;

        Node(T item) {
            this.item = item;
        }
    }
}
