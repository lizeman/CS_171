package Lesson06;

import Lesson00.Queue;

import java.util.Iterator;

public class BreathFirstTraversal {

    private boolean visited[];

    private Queue<Integer> q = new Queue<Integer>() {
        @Override
        public boolean IsEmpty() {
            return false;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public void enqueue(Integer integer) {

        }

        @Override
        public Integer dequeue() {
            return null;
        }

        @Override
        public void resize(int cap) {

        }

        @Override
        public Iterator<Integer> iterator() {
            return null;
        }
    };




    public BreathFirstTraversal(Graph g, int source) {
        visited = new boolean[g.numVertices()];



    }
}
