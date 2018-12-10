
public class DoubleListClient {
    public static void main(String[] args) {
        DoubleCircularList list  = new DoubleCircularList();
        DoubleCircularList.Node something;

        something  = new DoubleCircularList.Node(100);
        list.insertAtHead(something);

        something = new DoubleCircularList.Node(-100);
        list.insertAtTail(something);

        list.deleteAtTail();

//        list.print_list();

        something = new DoubleCircularList.Node(-100);
        list.insertAtTail(something);

        list.deleteAtTail();

        something = new DoubleCircularList.Node(101);
        list.insertAtHead(something);
        something = new DoubleCircularList.Node(102);
        list.insertAtHead(something);
        something = new DoubleCircularList.Node(103);
        list.insertAtHead(something);
        something = new DoubleCircularList.Node(104);
        list.insertAtHead(something);
        something = new DoubleCircularList.Node(105);
        list.insertAtHead(something);
//

        something = new DoubleCircularList.Node(-99);
        list.insertAtTail(something);
        something = new DoubleCircularList.Node(-98);
        list.insertAtTail(something);
        something = new DoubleCircularList.Node(-97);
        list.insertAtTail(something);

//
//        list.deleteAtTail();
//        list.deleteAtTail();
//        list.deleteAtTail();
//        list.deleteAtTail();
//        list.deleteAtTail();
//        list.deleteAtTail();
//        list.deleteAtTail();
//        list.deleteAtTail();
//        list.deleteAtTail();
//        list.deleteAtTail();
//        list.deleteAtTail();
//        list.deleteAtTail();

        list.print_list();



    }
}
