package Lesson00;
import java.util.Iterator;
public class LinkedQueue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;

    private int n;

    private class Node {
        Item item;
        Node next;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (IsEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        n++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        n --;
        if (IsEmpty()) {
            last = null;
        }
        return item;
    }

    public boolean IsEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Item next() {
                return null;
            }
        };
    }

    public static void main(String[] args) {
        LinkedStack<String> something = new LinkedStack();
    }
}
