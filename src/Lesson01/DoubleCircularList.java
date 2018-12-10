public class DoubleCircularList {
    public Node head;
    public Node tail;

    public static class Node {
        public int value;
        Node next;
        Node prev;

        public Node(){ }
        public Node(int value) {
            this.value = value;
        }
    }

    public void insertAtHead(Node x) {
        // this is function used for insert a node before head, also change the tail.next;
        // when the list is empty
        if(head == null) {
            head = x;
            tail = x;
            return;
        }

        // when the list only have one node
        if(head.next == null) {
            x.next = head;
            x.prev = head;
            head.next = x;
            head.prev = x;
            head = x;
            return;
        }

        // when the list have two or more node;
        x.next = head;
        x.prev = tail;
        tail.next = x;
        head.prev = x;
        head = x;
    }

    public void insertAtTail(Node x) {
        if(head == null) {
            head = x;
            tail = x;
            return;
        }

        // when the list only have one node
        if(head.next == null) {
            x.next = head;
            x.prev = head;
            head.next = x;
            head.prev = x;
            tail = x;
            return;
        }

        // when the list have two or more node;
        x.next = head;
        x.prev = tail;
        tail.next = x;
        head.prev = x;
        tail = x;
    }

    public void deleteAtTail() {
        if(head == null) {
            return;
        }

        // when the list only have one node
        if(head.next == null || head == tail) {
            head = null;
            tail = null;
            return;
        }

        // when the list have two or more node;
        tail.prev.next = tail.next;
        tail.next.prev = tail.prev;
        tail = tail.prev;
    }

    public void print_list() {
        if(head == null)
            return;
        if(head.next == null) {
            System.out.println(head.value);
            return;
        }
        for(Node n = head; n != tail; n = n.next)
            System.out.println(n.value);
        System.out.println(tail.value);
    }

//    public static void main(String[] args) {
//        DoubleCircularList list = new DoubleCircularList();
//        Node x = new Node()
//        list.insertAtHead();
//
//    }

}