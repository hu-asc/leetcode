package com.code.problem_200;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {

    /**
     * dfs
     * floodfill算法:遍历过的节点置为0
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x == grid.length || y < 0 || y == grid[0].length || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        dfs(grid, x + 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x - 1, y);
        dfs(grid, x, y - 1);
    }

    /**
     * bfs
     * @param grid
     * @return
     */
    public int numIslandsV2(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    Queue<String> queue = new LinkedList<>();
                    queue.offer(i + "," + j);
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            String poll = queue.poll();
                            String[] split = poll.split(",");
                            int x = Integer.parseInt(split[0]);
                            int y = Integer.parseInt(split[1]);
                            if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                                grid[x - 1][y] = '0';
                                queue.offer((x - 1) + "," + y);
                            }
                            if (x + 1 < grid.length && grid[x + 1][y] == '1') {
                                grid[x + 1][y] = '0';
                                queue.offer((x + 1) + "," + y);
                            }
                            if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                                grid[x][y - 1] = '0';
                                queue.offer(x + "," + (y - 1));
                            }
                            if (y + 1 < grid[i].length && grid[x][y + 1] == '1') {
                                grid[x][y + 1] = '0';
                                queue.offer(x + "," + (y + 1));
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

}
