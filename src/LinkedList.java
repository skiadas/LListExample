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
        } else {
            lastNode().next = new Node(item);
        }
    }

    public T front() {
        return head.item;
    }

    public T back() {
        return lastNode().item;
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
        if (isOneElementList()) {
            this.head = null;
        } else {
            nextToLastNode().next = null;
        }
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

    private boolean isOneElementList() {
        return isLast(this.head);
    }

    private Node nextToLastNode() {
        Node currentNode = this.head;
        while (hasTwoNodesFollowing(currentNode)) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    private boolean hasTwoNodesFollowing(Node node) {
        return hasNext(node.next);
    }

    private Node lastNode() {
        Node node = this.head;
        while (hasNext(node)) {
            node = node.next;
        }
        return node;
    }

    private boolean hasNext(Node node) {
        return notNull(node.next);
    }

    private boolean isLast(Node node) {
        return isNull(node.next);
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
