public class LinkedList<T> {
    private final Node nullNode = new NullNode();
    private Node head = nullNode;

    public boolean isEmpty() {
        return firstNode().isNull();
    }

    public void addToFront(T item) {
        setHead(createNode(item, firstNode()));
    }

    public void addToBack(T item) {
        if (firstNode().isNull()) {
            addToFront(item);
        } else {
            lastNode().setNext(createNode(item));
        }
    }

    public T front() {
        return firstNode().getItem();
    }

    public T back() {
        return lastNode().getItem();
    }

    public T get(int i) {
        Node node = firstNode();
        while (i > 0) {
            i--;
            node = node.getNext();
        }

        return node.getItem();
    }

    public void removeFront() {
        setHead(firstNode().getNext());
    }

    public void removeBack() {
        if (isOneElementList()) {
            setHead(nullNode());
        } else {
            nextToLastNode().setNext(nullNode());
        }
    }

    public int size() {
        int count = 0;
        Node node = firstNode();
        while (node.notNull()) {
            count++;
            node = node.getNext();
        }
        return count;
    }

    private boolean isOneElementList() {
        return firstNode().isLast();
    }

    private Node nextToLastNode() {
        Node currentNode = firstNode();
        while (hasTwoNodesFollowing(currentNode)) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    private boolean hasTwoNodesFollowing(Node node) {
        return node.getNext().hasNext();
    }

    private void setHead(Node node) {
        this.head = node;
    }

    private Node firstNode() {
        return this.head;
    }

    private Node lastNode() {
        Node node = firstNode();
        while (node.hasNext()) {
            node = node.getNext();
        }
        return node;
    }

    private Node createNode(T item, Node next) {
        return new ItemNode(item, next);
    }

    private Node createNode(T item) {
        return createNode(item, nullNode());
    }

    private Node nullNode() {
        return nullNode;
    }

    public abstract class Node {
        abstract T getItem();
        abstract void setItem(T item);

        abstract Node getNext();
        abstract void setNext(Node next);

        protected abstract boolean hasNext();
        protected abstract boolean isLast();
        protected abstract boolean isNull();
        protected abstract boolean notNull();
    }

    private class NullNode extends Node {
        @Override
        T getItem() {
            throw new IndexOutOfBoundsException();
        }

        @Override
        void setItem(T item) {}

        @Override
        Node getNext() {
            return nullNode();
        }

        @Override
        void setNext(Node next) {

        }

        @Override
        protected boolean hasNext() {
            return false;
        }

        @Override
        protected boolean isLast() {
            return false;
        }

        @Override
        protected boolean isNull() {
            return true;
        }

        @Override
        protected boolean notNull() {
            return false;
        }
    }

    private class ItemNode extends Node {
        private T item;

        private Node next;

        private ItemNode(T item, Node next) {
            this.setItem(item);
            this.setNext(next);
        }

        @Override
        T getItem() {
            return item;
        }

        @Override
        void setItem(T item) {
            this.item = item;
        }

        @Override
        Node getNext() {
            return next;
        }

        @Override
        void setNext(Node next) {
            this.next = next;
        }

        @Override
        protected boolean hasNext() {
            return getNext().notNull();
        }

        @Override
        protected boolean isLast() {
            return getNext().isNull();
        }

        @Override
        protected boolean isNull() {
            return false;
        }

        @Override
        protected boolean notNull() {
            return true;
        }
    }
}
