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
            lastNode().setNext(Node.create(item));
        }
    }

    public T front() {
        return head.getItem();
    }

    public T back() {
        return lastNode().getItem();
    }

    public T get(int i) {
        Node<T> node = this.head;
        while (i > 0) {
            i--;
            node = node.getNext();
        }

        return node.getItem();
    }

    public void removeFront() {
        this.head = this.head.getNext();
    }

    public void removeBack() {
        if (isOneElementList()) {
            this.head = null;
        } else {
            nextToLastNode().setNext(null);
        }
    }

    public int size() {
        int count = 0;
        Node node = this.head;
        while (notNull(node)) {
            count++;
            node = node.getNext();
        }
        return count;
    }

    private boolean isOneElementList() {
        return isLast(this.head);
    }

    private Node nextToLastNode() {
        Node currentNode = this.head;
        while (hasTwoNodesFollowing(currentNode)) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    private boolean hasTwoNodesFollowing(Node node) {
        return hasNext(node.getNext());
    }

    private Node<T> lastNode() {
        Node<T> node = this.head;
        while (hasNext(node)) {
            node = node.getNext();
        }
        return node;
    }

    private boolean hasNext(Node node) {
        return notNull(node.getNext());
    }

    private boolean isLast(Node node) {
        return isNull(node.getNext());
    }

    private boolean isNull(Node node) {
        return node == null;
    }

    private boolean notNull(Node node) {
        return !isNull(node);
    }

    private static class Node<T> {
        private T item;
        private Node next;

        private Node(T item, Node next) {
            this.setItem(item);
            this.setNext(next);
        }

        static <T> Node create(T item, Node next) {
            return new Node(item, next);
        }

        static <T> Node create(T item) {
            return Node.create(item, null);
        }

        T getItem() {
            return item;
        }

        void setItem(T item) {
            this.item = item;
        }

        Node getNext() {
            return next;
        }

        void setNext(Node next) {
            this.next = next;
        }
    }

}
