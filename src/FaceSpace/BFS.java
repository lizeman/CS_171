package FaceSpace;

import java.lang.String;

import java.util.ArrayList;

import java.util.ArrayDeque;

public class BFS {

    private ArrayList<String> visited;
//    private String[][] edgeTo; //equal to edge to;

    User source;
    User destination;
    HashTableLinearProbe<String, User> graph;


    public BFS(HashTableLinearProbe<String, User> graph, User source, User destination) {

        this.graph = graph;
        this.source = source;
        this.destination = destination;

        visited = new ArrayList<String>();
//        edgeTo = new String[graph.getSize()][graph.getSize()];

        BreathFirstTraversal(graph, source);
    }


    public void BreathFirstTraversal(HashTableLinearProbe<String, User> graph, User source) {
        QueueArray<String> queue = new QueueArray<String>();

        visited.add(source.getName());
        queue.enqueue(source.getName());

        while (!queue.isEmpty()) {
            String v = queue.dequeue();
            for (User user_w : graph.get(v).getFriendList()) {
                if (!visited.contains(user_w.getName())) {
                    user_w.Upper_user = graph.get(v);
                    visited.add(user_w.getName());
                    queue.enqueue(user_w.getName());
                    if (user_w.getName().equals(destination.getName())) {
                        System.out.println("Find Path!");
                        Showpath();
                        return;
                    }
                }
            }
        }
        System.out.println("Not find Path");
        return;

    }

    private void Showpath() {

        Stack<String> path = new StackArray<>();
        for (User i = destination; !i.equals(source); i = i.Upper_user) {
            path.push(i.getName());
        }

        path.push(source.getName());

        while (!path.isEmpty()) {
            System.out.print(path.pop() + " ");
        }
        System.out.println();

    }


//
//    public class BreadthFirstPaths {
//
//        private boolean[] visited;
//        private int[] edgeTo;
//        private final int source;
//
//        public BreadthFirstPaths(Graph g, int source) {
//            visited = new boolean[g.numVertices()];
//            edgeTo = new int[g.numVertices()];
//            this.source = source;
//            bfs(g,source);
//        }
//
//        private void bfs(Graph g, int source) {
//            QueueArray<Integer> queue = new QueueArray<Integer>();
//            visited[source] = true;
//            queue.enqueue(source);
//            while (!queue.isEmpty()) {
//                int v = queue.dequeue();
//                for (int w : g.adj(v)) {
//                    if (! visited[w]) {
//                        edgeTo[w] = v;
//                        visited[w] = true;
//                        queue.enqueue(w);
//                    }
//                }
//            }
//        }
//
//        public boolean hasPathTo(int v) {
//            return visited[v];
//        }
//
//        public Iterable<Integer> pathTo(int v) {
//            if (!hasPathTo(v)) return null;
//            Stack<Integer> path = new Stack<Integer>();
//            for (int x = v; x != source; x = edgeTo[x]) {
//                path.push(x);
//            }
//            path.push(source);
//            return path;
//        }

//    public boolean hasPathTo(int v) {
//        return visited[v];
//    }
//
//    public Iterable<Integer> pathTo(int v) {
//        if (!hasPathTo(v)) return null;
//        Stack<Integer> path = new Stack<Integer>();
//        for (int x = v; x != source; x = edgeTo[x]) {
//            path.push(x);
//        }
//        path.push(source);
//        return path;
//    }

    public static void main(String[] args) {

//        User g = new User(7);
//        g.addEdge(0, 1);
//        g.addEdge(0, 6);
//        g.addEdge(1, 3);
//        g.addEdge(1, 5);
//        g.addEdge(1, 6);
//        g.addEdge(2, 3);
//        g.addEdge(2, 5);
//        g.addEdge(2, 6);
//        g.addEdge(3, 4);
//        g.addEdge(4, 5);
//        System.out.println(g);
//
//        BreadthFirstPaths paths = new BreadthFirstPaths(g,0);
//        for (int v = 1; v < g.numVertices(); v++) {
//            System.out.println(paths.pathTo(v));
//        }

    }

}
