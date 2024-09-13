package com.code.problemset.problem_120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTotal {

    /**
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotal(triangle, 0, 0);
    }

    private int minimumTotal(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }
        int left = minimumTotal(triangle, row + 1, col);
        int right = minimumTotal(triangle, row + 1, col + 1);
        return Math.min(left, right) + triangle.get(row).get(col);
    }


    /**
     * dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + t[i][j]
     *
     * @param triangle
     * @return
     */
    public int minimumTotalV2(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        int[][] dp = new int[row][col];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < row; i ++) {
            for (int j = 0; j < triangle.get(i).size(); j ++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        System.out.println(Arrays.toString(dp[row - 1]));
        return Arrays.stream(dp[row - 1]).min().getAsInt();
    }


    public int minimumTotalV3 (List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    /**
     * bottom-up
     * 每次递推一层
     * @param triangle
     * @return
     */
    public int minimumTotalV4(List<List<Integer>> triangle) {
        int[] res = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i --) {
            for (int j = 0; j < triangle.get(i).size(); j ++) {
                res[j] = Math.min(res[j], res[j + 1]) + triangle.get(i).get(j);
            }
        }
        return res[0];
    }


    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        MinimumTotal t = new MinimumTotal();
        System.out.println(t.minimumTotalV2(triangle));

    }
}
