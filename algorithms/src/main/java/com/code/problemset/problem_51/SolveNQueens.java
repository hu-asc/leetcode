package com.code.problemset.problem_51;

import java.util.*;

public class SolveNQueens {

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        List<List<String>> result = new ArrayList<>();
        backtrack(board, 0, result);
        return result;
    }

    private void backtrack(char[][] board, int row, List<List<String>> result) {
        if (row == board.length) {
            List<String> sub = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                sub.add(new String(board[i]));
            }
            result.add(sub);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (valid(row, col, board)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1, result);
                board[row][col] = '.';
            }
        }
    }

    private boolean valid(int row, int col, char[][] board) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // 斜对角线 135度
        for (int i = row - 1, j = col - 1; i >= 0 & j >= 0; i--,j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // 反斜对角线 45度
        for (int i = row - 1, j = col + 1; i >= 0 & j < board.length; i--,j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        int n = 4;
        List<List<String>> lists = solveNQueens.solveNQueens(4);

        System.out.println(lists.toString());
    }

}
