package ik.learn.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphsDFSPattern {
    private List<List<Integer>> adjList;  // Adjacency list
    private int[] visited;                // Visited array

    public GraphsDFSPattern(int n) {
        adjList = new ArrayList<>();
        visited = new int[n];
        Arrays.fill(visited, -1); // Initially mark all nodes as unvisited (-1)

        // Initialize the adjacency list
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Function to add an edge into the graph
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);  // For directed graph
        adjList.get(v).add(u);  // If the graph is undirected
    }

    // DFS function
    public void dfs(int source) {
        visited[source] = 1;  // Mark the source as visited (1)

        for (int neighbor : adjList.get(source)) {
            if (visited[neighbor] == -1) {
                dfs(neighbor);  // Recursively visit unvisited neighbors
            }
        }
    }

    public static void main(String[] args) {
        // Example usage:
        GraphsDFSPattern graph = new GraphsDFSPattern(5);  // Create a graph with 5 nodes (0 to 4)

        // Add some edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);

        // Start DFS from node 0
        graph.dfs(0);
    }

}
