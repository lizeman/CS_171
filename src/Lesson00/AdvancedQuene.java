package Lesson00;

//finish this class code
import java.util.Iterator;
public class AdvancedQuene<Item> implements Queue<Item>, Iterable<Item> {
    private int size;
    private int head;
    private int tail;

    private Item[] items;

    public AdvancedQuene() {
        items = (Item[]) new Object[1];
//        head = 0;
//        tail = 0;
//        size = 0;
    }

    public boolean IsEmpty(){
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item){
        if (size == items.length - 1)
            resize(items.length * 2);
        items[tail++] = item;
        if (size == items.length) {
            tail = 0;
        }
        size++;
    }

    public Item dequeue() {
        if (this.IsEmpty())
            throw new RuntimeException("Tried to dequeue in an empty queue");
        Item itemToReturn = items[head];
        items[head++] = null;
        size--;
        if (head == items.length)
            head = 0;
        if (size == items.length / 4){
            resize(items.length / 2);
        }
        return itemToReturn;

    }

    public void resize(int cap) {
        Item[] tmp = (Item[]) (new Object[cap]);
        for(int i = 0; i < size; i++) {
            tmp[i] = items[(head + i) % items.length];
        }
        head = 0;
        tail = size;
        items = tmp;
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private int pos = head;
            private int count = 0;

            @Override
            public boolean hasNext() {
                return (count < size);
            }

            @Override
            public Item next() {
                Item item = items[pos++];
                if (pos == items.length){
                    pos = 0;
                }
                count++;
                return item;
            }
        };
    }



    public static void main(String[] args) {}

}
