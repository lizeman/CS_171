package Lesson00;
import java.util.Iterator;

public class LinkedStack<Item> implements Iterable<Item> {
    private Node first;

    private int n;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public Item pop() {
        Item tmp = first.item;
        first = first.next;
        n--;
        return tmp;
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                Item item = current.item;
                current = current.next;
                return item;
            }

            @Override
            public void remove() {

            }
        };
    }

    public static void main(String[] args) {
        LinkedStack<String> client = new LinkedStack<>();
        for( int i= 0; i < args.length; i++){
            if (args[i].equalsIgnoreCase("-")){
                if (client.size() != 0)
                    System.out.println(client.pop());
                else{
                    System.out.println("Out of Bound!");
                }
            } else {
                client.push(args[i]);
            }
        }

        System.out.println("    ");

        for (String something: client) {
            System.out.println(something);
        }
    }
}
