public class StackArray<Item> {

    private Item[] items;
    private int size;

    public StackArray() {
        items = (Item[]) (new Object[1]);
        size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void push(Item item) {
        if (size == items.length)
            resize(2 * items.length);
        items[size++] = item;
    }

    public void resize(int capacity) {
        Item[] newArray = (Item[]) (new Object[1]);
        for ( int i  = 0; i < size; i++) {
            newArray[i] = items[i];
        }
        items = newArray;
    }


    public static void main(String args[]) {


    }
}
