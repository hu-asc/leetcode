package com.code.problem_529;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class UpdateBoard {

    int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};

    /**
     * dfs
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0], col = click[1];
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }
        dfs(board, row, col);
        return board;
    }

    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'E') {
            return;
        }
        int num = getNumsOfMines(board, row, col);
        if (num == 0) {
            board[row][col] = 'B';
            for (int i = 0; i < 8; i++) {
                int x = row + dx[i], y = col + dy[i];
                dfs(board, x, y);
            }
        } else {
            board[row][col] = (char) ('0' + num);
        }
    }

    private int getNumsOfMines(char[][] board, int row, int col) {
        int num = 0;
        for (int i = 0; i < 8; i++) {
            int x = row + dx[i], y = col + dy[i];
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                continue;
            }
            if (board[x][y] == 'M' || board[x][y] == 'X') {
                num++;
            }
        }
        return num;
    }

    /**
     * bfs
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoardV2(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(click);
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int row = poll[0], col = poll[1];
            if (board[row][col] == 'M') {
                board[row][col] = 'X';
            } else {
                int count = 0;
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        int r = row + i, c = col + j;
                        if (r < 0 || r >= m || c < 0 || c >= n) {
                            continue;
                        }
                        if (board[r][c] == 'M' || board[r][c] == 'X') {
                            count++;
                        }
                    }
                }
                if (count > 0) {
                    board[row][col] = (char) ('0' + count);
                } else {
                    board[row][col] = 'B';
                    for (int i = -1; i < 2; i++) {
                        for (int j = -1; j < 2; j++) {
                            if (i == 0 && j == 0) {
                                continue;
                            }
                            int r = row + i, c = col + j;
                            if (r < 0 || r >= m || c < 0 || c >= n) {
                                continue;
                            }
                            if (board[r][c] == 'E') {
                                queue.offer(new int[]{r, c});
                                board[r][c] = 'B';
                            }
                        }
                    }
                }
            }
        }
        return board;
    }

    public static void main(String[] args) {
        char[][] board = new char[4][5];
        board[0] = new char[]{'E', 'E', 'E', 'E', 'E'};
        board[1] = new char[]{'E', 'E', 'M', 'E', 'E'};
        board[2] = new char[]{'E', 'E', 'E', 'E', 'E'};
        board[3] = new char[]{'E', 'E', 'E', 'E', 'E'};
        int[] click = {3, 0};
        UpdateBoard updateBoard = new UpdateBoard();
        char[][] chars = updateBoard.updateBoardV2(board, click);
        System.out.println(Arrays.deepToString(chars));
    }
}
