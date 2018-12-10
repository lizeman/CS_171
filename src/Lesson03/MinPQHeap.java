package Lesson03;

public class MinPQHeap<Item extends Comparable<Item>> {

    private Item[] items;
    private int size;

    public MinPQHeap(int capacity) {
        items = (Item[]) (new Comparable[capacity + 1]);
        size = 0;
    }

    public int size() {
        return size;
    }

    private boolean less(int i, int j) {
        return (items[i].compareTo(items[j])) < 0;
    }

    private void exch(int i, int j) {
        Item tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    public void put(Item item) {
        items[size + 1] = item;
        size++;
        swim(size);
    }

    private void swim(int position) {
        while(position > 1 && less(position, position/2)) {
            exch(position/2, position);
            position = position/2;
        }
    }

    public Item removeMinItem() {
        Item minItem = items[1];
        items[1] = items[size];
        items[size--] = null;
        sink();
        return minItem;
    }

    private void sink() {
        int position = 1;
        while(2 * position <= size) {
            int j = 2 * position;
            if(j < size && less(j+1, j)) {
                j++;
            }

            if(less(position, j))
                break;

            exch(position, j);

            position = j;
        }
    }

    public static void main(String[] args) {

    }
}
