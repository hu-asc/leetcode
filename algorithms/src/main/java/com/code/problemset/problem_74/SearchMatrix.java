package com.code.problemset.problem_74;

/**
 * @author huhongtao
 * @date 2024-10-23
 */
public class SearchMatrix {


    /**
     * 第一次二分查找可以找出 matrix 的某行
     * 第二次二分查找某行是否有等于 target 的元素
     * 闭区间[left, right]，所以 更新的时候要用 mid + 1 和 mid -1
     *
     * 如果区间left,right 只有一个元素，仍然用 mid 赋值，这样就会死循环，所以要用 mid + 1 和 mid -1
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = getRow(matrix, target);
        if (row < 0) {
            return false;
        }
        return search(matrix, row, target);
    }

    private boolean search(int[][] matrix, int row, int target) {
        int left = 0;
        int right = matrix[row].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] > target) {
                right = mid - 1;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * matrix[mid][0] <= target 不一定要 mid + 1
     * 因为 target 可能在这一行，所以 left = -1，要用开区间
     */
    private int getRow(int[][] matrix, int target) {
        int left = -1;
        int right = matrix.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else if (matrix[mid][0] <= target) {
                left = mid;
            }
        }
        return left;
    }


    /**
     * 二分搜索
     *
     * matrix[mid / n][mid % n] 转换为矩阵对应的下标
     */
    public boolean searchMatrixV2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int x = matrix[mid / n][mid % n];
            if (x == target) {
                return true;
            }
            if (x < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

}
