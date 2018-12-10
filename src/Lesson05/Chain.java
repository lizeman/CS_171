package Lesson05;

public class Chain<Key, Value> {

    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    private Node first;
    private int size;

    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next)
            if (x.key == key) {
                x.val = val;
                return;
            }
        first = new Node(key, val, first);
        size++;
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key == key) {
                return x.val;
            }
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        String string = "";
        for (Node x = first; x != null; x = x.next) {
            string += x.val;
            string += " ";
        }
        return string;
    }
}
