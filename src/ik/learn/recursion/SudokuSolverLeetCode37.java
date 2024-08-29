package ik.learn.recursion;
/*
 * ketnakhalasi created on 2/3/23
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

Input: board = [
* ["5","3",".",".","7",".",".",".","."],
* ["6",".",".","1","9","5",".",".","."],
* [".","9","8",".",".",".",".","6","."],
* ["8",".",".",".","6",".",".",".","3"],
* ["4",".",".","8",".","3",".",".","1"],
* ["7",".",".",".","2",".",".",".","6"],
* [".","6",".",".",".",".","2","8","."],
* [".",".",".","4","1","9",".",".","5"],
* [".",".",".",".","8",".",".","7","9"]]
Output: [
* ["5","3","4","6","7","8","9","1","2"],
* ["6","7","2","1","9","5","3","4","8"],
* ["1","9","8","3","4","2","5","6","7"],
* ["8","5","9","7","6","1","4","2","3"],
* ["4","2","6","8","5","3","7","9","1"],
* ["7","1","3","9","2","4","8","5","6"],
* ["9","6","1","5","3","7","2","8","4"],
* ["2","8","7","4","1","9","6","3","5"],
* ["3","4","5","2","8","6","1","7","9"]]
 * */

import java.util.ArrayList;

public class SudokuSolverLeetCode37 {
    public static void main(String[] args) {

    }

    static ArrayList<ArrayList<Integer>> solve_sudoku_puzzle(ArrayList<ArrayList<Integer>> board) {
        int[][] board1 = new int[9][9];
        int i=0, j=0;
        for(ArrayList<Integer> row : board) {
           for(int cell : row) {
               board1[i][j++] = cell;
           }
           j=0;
           i++;
        }
        if(isValidSudoku(board1)) {

        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int[] arr : board1) {
            ArrayList<Integer> aList = new ArrayList<>();
            for(int a : arr) {
                aList.add(a);
            }
            result.add(aList);
        }
        return result;
    }

    static boolean isValidSudoku(int[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                int cell = board[i][j];
                if(cell == 0) {
                    for(int k=1; k<=9; k++) {
                        if(checkRow(board, i, k) && checkColumn(board, j, k)
                                && checkSquare(board, i, j, k)) {
                            board[i][j] = k;
                            if(isValidSudoku(board)) return true;
                            board[i][j] = 0;
                        }
                    }
                    return false;
                }

            }
        }
        return true;
    }

    static boolean checkRow(int[][] board, int row, int candidate) {
        for(int col=0; col<9; col++) {
            if(board[row][col] == candidate)
                return false;
        }
        return true;
    }
    static boolean checkColumn(int[][] board, int col, int candidate) {
        for(int row=0; row<9; row++) {
            if(board[row][col] == candidate) {
                return false;
            }
        }
        return true;
    }
    static boolean checkSquare(int[][] board, int row, int col, int candidate) {
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;
        for(int i=startRow; i<startRow+3; i++) {
            for(int j=startCol; j<startCol+3; j++) {
                if(board[i][j] == candidate) {
                    return false;
                }
            }
        }
        return true;
    }
}
