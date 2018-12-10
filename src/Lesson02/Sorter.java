package Lesson02;
public interface Sorter<Item extends Comparable<Item>> {
    void sort(Item[] a);
}
