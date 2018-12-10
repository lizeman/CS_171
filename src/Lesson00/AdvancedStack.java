package Lesson00;
import java.util.Iterator;
import java.util.Scanner;

public class AdvancedStack<Item> implements Iterable<Item> {

    private Item[] a = (Item[]) new Object[1];
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(Item item) {
        if (size == a.length) {
            resize(a.length * 2);
        }
        a[size++] = item;
    }

    public Item pop() {
        if (this.isEmpty()) return null;

        Item item = a[--size];
        a[size] = null;
        if (size > 0 && size == a.length / 4) resize(a.length / 2);
        return item;
    }
//use private instead of public because we don't wanna user change the size of stack.
    private void resize(int cap) {
        Item[] tmp = (Item[]) new Object[cap];

        for (int i = 0; i < size; i++) tmp[i] = a[i];

        a = tmp;
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private int i = size;

            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public Item next() {
                return (Item) a[--i];
            }
        };

    }


    @Override
    public String toString() {
        String s = "";
        for (Item item : this) {
            s += item + " ";
        }
        return s;
    }



    public static void main(String[] args){
        AdvancedStack<String> client = new AdvancedStack<>();
        for( int i = 0; i < args.length; i++)
            if (args[i].equalsIgnoreCase("-")) System.out.println(client.pop());
            else client.push(args[i]);


        System.out.println("    ");
        System.out.println(client);

        for (String something: client) System.out.println(something);
    }


}
