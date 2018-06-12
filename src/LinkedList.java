public class LinkedList<T> {
    private Node head;

    public boolean isEmpty() {
        return isNull(head);
    }

    public void addToFront(T aString) {
        this.head = new Node(aString, this.head);
    }

    public void addToBack(T item) {
        if (isNull(this.head)) {
            addToFront(item);
            return;
        }
        Node lastNode = this.head;
        while (notNull(lastNode.next)) {
            lastNode = lastNode.next;
        }
        lastNode.next = new Node(item);
    }

    public T front() {
        return head.item;
    }

    public T back() {
        Node currentNode = this.head;
        while (notNull(currentNode.next)) {
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
        if (isNull(this.head.next)) {
            this.head = null;
            return;
        }
        Node currentNode = this.head;
        while (notNull(currentNode.next.next)) {
            currentNode = currentNode.next;
        }
        currentNode.next = null;
    }

    public int size() {
        int currentIndex = 0;
        Node currentNode = this.head;
        while (notNull(currentNode)) {
            currentIndex++;
            currentNode = currentNode.next;
        }
        return currentIndex;
    }

    private boolean isNull(Node node) {
        return node == null;
    }

    private boolean notNull(Node node) {
        return !isNull(node);
    }

    private class Node {
        T item;
        Node next;

        Node(T item) {
            this(item, null);
        }

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

    }
}
