package ik.learn.graphs;
/*
 * ketnakhalasi created on 5/11/22
 * */

import java.util.Iterator;
import java.util.LinkedList;

public class GraphIsValidTree {
    private int vertices;
    private LinkedList<Integer> adj[];

    //constructor
    @SuppressWarnings("unchecked")
    GraphIsValidTree(int vertices) {
        this.vertices = vertices;
        adj = new LinkedList[vertices];
        for(int i=0; i<vertices; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    //add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    // recursive func that uses visited[] and parent to
    // detect cycle in subgraph reachable from vertex v.
    boolean isCyclicUtil(int v, boolean visited[], int parent) {
        //mark the current node as visited
        visited[v] = true;
        Integer i;

        //recur for all the vertices adjacent to this vertex
        Iterator<Integer> it = adj[v].iterator();
        while(it.hasNext()) {
            i = it.next();

            // if adjacent is not visited, then recur that adjacent
            if(!visited[i]) {
                if(isCyclicUtil(i, visited, v)){
                    return true;
                }
            }

            // if adjacent is visited, and not parent of current vertex,
            // then there is a cycle
            else if (i != parent) {
                return true;
            }

        }
        return false;
    }

    //returns true if the graph is a tree, else false
    boolean isTree() {
        // mark all the vertices as not visited and
        // not part of the recursion stack
        boolean visited[] = new boolean[vertices];
        for(int i=0; i< vertices; i++) {
            visited[i] = false;
        }
        // isCyclicUtil - returns true if graph reachable from vertex 0 is cyclic.
        //  - It also marks all vertices reachable from 0.
        if(isCyclicUtil(0, visited, -1)) {
            return false;
        }

        // if we find a vertex not reachable from 0 (means not marked by
        // isCyclicUtil(), then return false
        for (int k=0; k< vertices; k++) {
            if(!visited[k])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // create a graph
        GraphIsValidTree g1 = new GraphIsValidTree(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);

        if(g1.isTree()) {
            System.out.println("Graph 1 is tree.");
        } else {
            System.out.println("Graph 1 is not tree.");
        }

        GraphIsValidTree g2 = new GraphIsValidTree(5);
        g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);

        if(g2.isTree()) {
            System.out.println("Graph 2 is tree.");
        } else {
            System.out.println("Graph 2 is not tree.");
        }
    }
}
