package com.code.problemset.problem_79;

/**
 * @author huhongtao
 * @date 2024-10-22
 */
public class Exist {

    /**
     * 判断是否能拼成 word 字符串，不需要拼接成整体在比较，只需要比较每个字符是否能匹配上就行
     * visited 保存是否遍历过
     * 相邻字符有四个方向，所以新增二维数组 direction 存储方向
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int[][] direction = new int[][]{{0,1}, {1,0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean flag = backtrack(board, visited, i, j, word, 0, direction);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, boolean[][] visited, int row, int column, String word, int k, int[][] direction) {
        if (board[row][column] != word.charAt(k)) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }
        boolean result = false;
        // 标记访问过
        visited[row][column] = true;
        for (int[] value : direction) {
            int newRow = row + value[0];
            int newColumn = column + value[1];
            if (newRow >= 0 && newRow < board.length && newColumn >= 0 && newColumn < board[newRow].length) {
                if (!visited[newRow][newColumn]) {
                    boolean flag = backtrack(board, visited, newRow, newColumn, word, k + 1, direction);
                    if (flag) {
                        result =true;
                    }
                }
            }
        }
        // 恢复
        visited[row][column] = false;
        return result;
    }

}
