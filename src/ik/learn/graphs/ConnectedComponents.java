package ik.learn.graphs;
/*
 * ketnakhalasi created on 5/10/22
 * */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectedComponents {

    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        ArrayList<Integer> e1 = new ArrayList<>();
        e1.add(0);
        e1.add(1);
        ArrayList<Integer> e2 = new ArrayList<>();
        e2.add(1);
        e2.add(2);
        ArrayList<Integer> e3 = new ArrayList<>();
        e3.add(3);
        e3.add(4);
        edges.add(e1);
        edges.add(e2);
        edges.add(e3);
        int c = findComponents(n, edges);
        System.out.println("Components: " + c);

//        System.out.println("Edges: ");
//        for (int i = 0; i < edges.size(); i++) {
//            for (int j = 0; j < edges.get(i).size(); j++) {
//                System.out.print(edges.get(i).get(j) + " ");
//            }
//            System.out.println();
//        }

    }

    static Integer findComponents(Integer n, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n);
        for(int i=0; i<n; i++) {
            adjList.add(i, new ArrayList<Integer>());
        }
        System.out.println("adjList Before: ");
        for (int i = 0; i < adjList.size(); i++) {
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.println( i + " i " + adjList.get(i).get(j) + " 1");
            }
            System.out.println();
        }

        for(ArrayList<Integer> edge : edges){
            adjList.get(edge.get(0)).add(edge.get(1));
            adjList.get(edge.get(1)).add(edge.get(0));
        }

        System.out.println("adjList: ");
        for (int i = 0; i < adjList.size(); i++) {
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
        int components = 0;
        int[] visited = new int[n];
        for(int i=0; i<n; i++) {
            if(visited[i] == 0) {
                components++;
                bfs(i, adjList, visited);
            }
        }
        return components;
    }

    private static void bfs(Integer src, ArrayList<ArrayList<Integer>> adjList, int[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(src.intValue());

        visited[src] = 1;
        while(!q.isEmpty()) {
            int node = q.poll();
            for(Integer neighbor : adjList.get(node)) {
                if(visited[neighbor] == 0) {
                    visited[neighbor] = 1;
                    q.offer(neighbor);
                }
            }
        }

    }
}
