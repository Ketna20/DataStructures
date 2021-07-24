package RecursionDynamicProgramming;
/*
 * ketnakhalasi created on 7/23/21
 * */

import java.awt.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RobotGrid {

    /* R - robot, # - maze, X - target
 (m, n) +           +
        |R| | | | | |
        |R|R| | | | |
        |#|R|R|R|R| |
        |#|#|#|#|R| |
        | | | | |R| |
        | | | | |R|X|
        +           + (0, 0)
        */
    public static void main(String[] args) {
        //store the path in linkedHashSet
        Set<Point> path = new LinkedHashSet<>();

        //define a maze
        boolean maze[][] = new boolean[6][6];
        maze[2][0] = true;
        maze[3][0] = true;
        maze[3][1] = true;
        maze[3][2] = true;
        maze[3][3] = true;

        findPath(5, 5, maze, path);
        System.out.println("plain recusrsive: ");
        path.forEach(System.out::println);

        //store visited cells
        Set<Point> visited = new HashSet<>();
        computePath(5, 5 ,maze, path, visited);
        System.out.println("Memoization: ");
        path.forEach(System.out::println);
        System.out.println("visited Failed cells: ");
        visited.forEach(System.out::println);
    }

    // Plain recursion = O(2^m+n)
    public static boolean findPath(int m, int n, boolean[][] maze, Set<Point> path) {
        if(maze == null || path == null) {
            throw new IllegalArgumentException("Path and maze cannot be null.");
        }
        //outside of the grid
        if(m < 0 || n < 0) {
            return false;
        }
        //we can't step at this cell, maze true means gray area
        if(maze[m][n]){
            return false;
        }

        if(((m==0) && (n==0))
        || findPath(m , n-1, maze, path)
        ||  findPath(m-1 , n, maze, path)) {
            path.add(new Point(m, n));
            return true;
        }
        return false;
    }

    //Memoization approach = O(mn)
    public static boolean computePath(int m, int n, boolean[][] maze, Set<Point> path, Set<Point> visitFailed) {
        if(maze == null || path == null || visitFailed == null) {
            throw new IllegalArgumentException("Path and maze and visitFailed cannot be null.");
        }
        //outside the grid
        if((m < 0) || (n < 0) ) {
            return false;
        }
        //maze point - gray area
        if(maze[m][n]){
            return false;
        }
        Point cell = new Point(m, n);
        // check if this cell already visited
        if(visitFailed.contains(cell)) {
            return false;
        }

        if(((m == 0) && (n == 0))
            || computePath(m, n-1, maze, path, visitFailed)
            || computePath(m-1, n, maze, path, visitFailed)
        ) {
            path.add(cell);
            return true;
        }
        visitFailed.add(cell);
        return false;
    }

}
