//package Lesson06;

import java.util.Stack;

public class DepthFirstTraversalStackBased {

    private boolean visited[];

    public DepthFirstTraversalStackBased(Graph g, int source) {
        Stack<Integer> stack = new Stack<Integer>();
        visited = new boolean[g.numVertices()];
        stack.push(source);

        while (!stack.isEmpty()) {

            int v = stack.pop();
            System.out.print(v + "  ");
            visited[v] = true;
            for (int w : g.adj(v))
                if (!visited[w]) {
                    stack.push(w);
                    visited[w] = true;
                }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 6);
        g.addEdge(1, 3);
        g.addEdge(1, 5);
        g.addEdge(1, 6);
        g.addEdge(2, 3);
        g.addEdge(2, 5);
        g.addEdge(2, 6);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        System.out.println(g);

        DepthFirstTraversalStackBased cc = new DepthFirstTraversalStackBased(g, 0);
    }

}