package Lesson04;

import com.sun.deploy.util.BlackList;

import java.sql.Blob;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
    /*
    red links "lean left"
    no node has 2 red links
    perfect black balance of all times
    */

    /*
    Rotate Left:
        right child red
        left child black
    Rotate Right:
        left child red
        left child of left child red
    Flip Color:
        both children red
     */

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        Key key;
        Value val;
        Node right;
        Node left;
        int size;
        boolean color;

        Node(Key key, Value val, int size, boolean color) {
            this.key = key;
            this.val = val;
            this.size = size;
            this.color = color;
        }

    }

    public int size() {
        return root.size;
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.size;
    }

    private boolean isRed(Node x) {
        if (x == null) return BLACK;
        return x.color == RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;

        x.size = size(h);
        h.size = size(h.left) + size(h.right) + 1;

        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;

        x.size = size(h);
        h.size = size(h.left) + size(h.right) + 1;

        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.right.color = BLACK;
        h.left.color = BLACK;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node h, Key key, Value val) {
        if (h == null)
            return new Node(key, val, 1, RED);
        int cmp = key.compareTo(h.key);
        if (cmp < 0)
            h.left = put(h.left, key, val);
        else if (cmp > 0)
            h.right = put(h.right, key, val);
        else
            h.val = val;

        if (isRed(h.right) && !isRed(h.left))
            h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left))
            h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))
            flipColors(h);

        h.size = size(h.left) + size(h.right) + 1;
        return h;
    }


}
