package com.code.problemset.problem_2326;

import com.code.problemset.ListNode;

import java.util.Arrays;

/**
 * @author huhongtao
 * @date 2024-10-20
 */
public class SpiralMatrix {

    /**
     * 模拟整个流程
     * 用 movement 保存每个方向的执行操作
     */
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result = new int[m][n];
        for (int[] row : result) {
            Arrays.fill(row, -1);
        }
        int[][] movement = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int i = 0;
        int j = 0;
        int currDirection = 0;
        ListNode node = head;
        while (node != null) {
            result[i][j] = node.val;
            int newi = i + movement[currDirection][0];
            int newj = j + movement[currDirection][1];
            // 到达边界或者已经被填充数据时需要改变方向
            if (Math.min(newi, newj) < 0 || newi >= m || newj >= n || result[newi][newj] != -1) {
                currDirection = (currDirection + 1) % 4;
            }
            i += movement[currDirection][0];
            j += movement[currDirection][1];
            node = node.next;
        }
        return result;
    }
}
