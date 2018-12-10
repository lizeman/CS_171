import java.util.Stack;

public class DepthFirstPaths {

    private boolean[] visited;
    private int[] edgeTo;
    private final int source;

    public DepthFirstPaths(Graph g, int s) {
        visited = new boolean[g.numVertices()];
        edgeTo = new int[g.numVertices()];
        this.source = s;
        dfs(g,s);
    }

    private void dfs(Graph g, int v) {
        visited[v] = true;
        for (int w : g.adj(v)) {
            if (!visited[w]) {
                edgeTo[w] = v;
                dfs(g,w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return visited[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != source; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(source);
        return path;
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

        DepthFirstPaths paths = new DepthFirstPaths(g,0);
        for (int v = 1; v < g.numVertices(); v++) {
            System.out.println(paths.pathTo(v));
        }

    }

}
