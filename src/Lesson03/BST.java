package Lesson03;

import Lesson00.AdvancedQuene;
import Lesson00.Queue;

public class BST<Key extends Comparable<Key>, Value> {

    private class Node {
        private Key key;
        private Value value;
        private Node Left;
        private Node Right;
        private int count;// <-- gives of # nodes in subtree topped by this node.

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;
//
//    public Value get(Key key) {
//        Node n = root;
//        while (n != null) {
//            int cmo = key.compareTo(n.key);
//            if(cmo < 0) //key < n.key
//                n = n.Left;
//            else if(cmo > 0)
//                n = n.Right;
//            else
//                return n.value;
//        }
//
//        return null;
//    }


    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node n, Key key) {
        if (n == null) {
            return null;
        }

        int cmp = key.compareTo(n.key);

        if (cmp < 0) { // key < n.key
            return get(n.Left, key);
        } else if (cmp > 0) {
            return get(n.Right, key);
        } else {
            return n.value;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node n) {
        return (n == null) ? 0 : n.count;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node n, Key key, Value val) {
        if (n == null) {
            Node node = new Node(key, val);
            node.count = 1;
            return node;
        }

        int cmp = key.compareTo(n.key);

        if (cmp < 0) { // key < n.key
            n.Left = put(n.Left, key, val);
        } else if (cmp > 0) {
            n.Right = put(n.Right, key, val);
        } else {
            n.value = val;
        }

        n.count = 1 + size(n.Left) + size(n.Left);

        return n;
    }

    public Iterable<Key> keyInOrder() {
        Queue<Key> q = new AdvancedQuene<Key>();
        enqueKeysInOrderFromNode(root, q);
        return q;
    }

    private void enqueKeysInOrderFromNode(Node n, Queue<Key> q) {
        if (n == null) return;
        enqueKeysInOrderFromNode(n.Left, q);
        enqueKeysInOrderFromNode(n.Right, q);
        q.enqueue(n.key);
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node n, Key key) {
        if (n == null) {
            return 0;
        }

        int cmp = key.compareTo(n.key);

        if (cmp < 0) {
            return rank(n.Left, key);
        } else if (cmp > 0) {
            return size(n.Left) + rank(n.Right, key) + 1;
        } else { ///cmp == 0
            return size(n.Left);
        }

    }

    public Key select(int rank) {
        Node n = select(root, rank);

        return n.key;
    }

    private Node select(Node n, int rank) {
        if (n == null) {
            return null;
        }

        int numToLeft = size(n.Left);

        if (numToLeft > rank) {
            return select(n.Left, rank);
        } else if (numToLeft < rank) {
            return select(n.Right, rank - numToLeft - 1);
        } else {
            return n;
        }

    }


    private Node deleteMin(Node n) {
        if (n.Left == null) {
            return n.Right;
        }
        n.Left = deleteMin(n.Left);

        n.count = 1 + size(n.Left) + size(n.Right); //because recurse method keep the things on top

        return n;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node n, Key key) {
        if (n == null) {
            return null;
        }

        int cmp = key.compareTo(n.key);
        if (cmp < 0) {
            n.Left = delete(n.Left, key);
        } else if (cmp > 0) {
            n.Right = delete(n.Right, key);
        } else { // found the right node to delete
            if (n.Right == null) {
                return n.Left;
            }
            Node t = n;

            n = select(n.Right, 0);
            n.Right = deleteMin(t.Right);
            n.Left = t.Left;
        }

        n.count = size(n.Left) + size(n.Right) + 1;

        return n;

    }


    public static void main(String args[]) {

    }


}
