package Lesson00;
public interface Queue<Item> extends Iterable<Item> {

    boolean IsEmpty();

    int size();

    void enqueue(Item item);

    Item dequeue();

    void resize(int cap);

}
