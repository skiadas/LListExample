public class LinkedList<T> {
    private Node<T> head;

    public boolean isEmpty() {
        return isNull(head);
    }

    public void addToFront(T item) {
        this.head = Node.create(item, this.head);
    }

    public void addToBack(T item) {
        if (isNull(this.head)) {
            addToFront(item);
        } else {
            lastNode().next = Node.create(item);
        }
    }

    public T front() {
        return head.item;
    }

    public T back() {
        return lastNode().item;
    }

    public T get(int i) {
        Node<T> node = this.head;
        while (i > 0) {
            i--;
            node = node.next;
        }

        return node.item;
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
        int count = 0;
        Node node = this.head;
        while (notNull(node)) {
            count++;
            node = node.next;
        }
        return count;
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

    private Node<T> lastNode() {
        Node<T> node = this.head;
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

    private static class Node<T> {
        T item;
        Node next;

        private Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        static <T> Node create(T item, Node next) {
            return new Node(item, next);
        }

        static <T> Node create(T item) {
            return Node.create(item, null);
        }
    }

}
