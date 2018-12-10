//package Lesson03;
//SUBMITTED BY: David(LI ZEMAN)
public class BSTIndex {

    public BSTIndex() {
    }

    private Node root;

    private class Node {
        private String shortname;   //key
        private MovieInfo movieInfo;    //value
        //Children
        private Node Left;
        private Node Right;

        public Node(String shortname, MovieInfo movieInfo) {
            this.shortname = shortname;
            this.movieInfo = movieInfo;
        }
    }

    public MovieInfo findExact(String key) {
        return findExact(root, key.toLowerCase());
    }

    private MovieInfo findExact(Node n, String shortname) {
        if (n == null) {
            return null;
        }

        int cmp = shortname.compareTo(n.shortname);

        if (cmp < 0) { // key < n.key
            return findExact(n.Left, shortname);
        } else if (cmp > 0) {
            return findExact(n.Right, shortname);
        } else {
            return n.movieInfo;
        }

    }

    public MovieInfo findPrefix(String prefix) {
        String[] tmp = prefix.split("\\*");
        return findPrefix(root, tmp[0].toLowerCase());
    }

    private MovieInfo findPrefix(Node node, String prefix) {
        if (node == null) {
            return null;
        }

        int cmp = prefix.compareTo(node.shortname);
        if (node.shortname.startsWith(prefix)) {
            return node.movieInfo;
        }
        if (cmp < 0) { // key < n.key
            return findPrefix(node.Left, prefix);
        } else {
            return findPrefix(node.Right, prefix);
        }


    }

    public void insert(MovieInfo data) {
        root = insert(root, data.shortName.toLowerCase(), data);
    }

    private Node insert(Node n, String shortname, MovieInfo movieInfo) {
        if (n == null) {
            Node node = new Node(shortname, movieInfo);
            return node;
        }

        int cmp = shortname.compareTo(n.shortname);

        if (cmp < 0) { // key < n.key
            n.Left = insert(n.Left, shortname, movieInfo);
        } else if (cmp > 0) {
            n.Right = insert(n.Right, shortname, movieInfo);
        } else {
            n.shortname = shortname;
        }

        return n;
    }


//debugging

//    public void printLeftchild() {
//        for(Node node = root; node.Left != null; node = node.Left)
//            System.out.println(node.shortname);
//    }
//
//    public void printRighttchild() {
//        System.out.println("==================================");
//        for(Node node = root; node.Right != null; node = node.Right)
//            System.out.println(node.shortname);
//    }

//    public void printAllchild() {
//        System.out.println("==================================");
//        printAllchild(root);
//    }

    private Node printAllchild(Node node) {
        if (node.Left == null) {
            System.out.println(node.shortname);
        } else {
            printAllchild(node.Left);
        }

        if (node.Right == null) {
            System.out.println(node.shortname);
        } else {
            printAllchild(node.Right);
        }
        return null;
    }

}
