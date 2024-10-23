package com.code.problemset.problem_427;

/**
 * @author huhongtao
 * @date 2024-10-22
 */
public class Construct {

    /**
     * 左上角 (r0, c0) 右下角 (r1, c1)
     * 如果包括的元素全部为 0 或 1，则创建根节点
     * 如果不是，需要递归获得对应的 4 个节点
     */
    public Node construct(int[][] grid) {
        Node node = construct(grid, 0, 0, grid.length, grid.length);
        return node;
    }

    private Node construct(int[][] grid, int r0, int c0, int r1, int c1) {
        boolean equal = true;
        for (int i = r0; i < r1; i++) {
            for (int j = c0; j < c1; j++) {
                if (grid[r0][c0] != grid[i][j]) {
                    equal = false;
                    break;
                }
            }
            if (!equal) {
                break;
            }
        }
        if (equal) {
            return new Node(grid[r0][c0] == 1, true);
        }
        Node root = new Node(true, false);
        root.topLeft = construct(grid, r0, c0, (r0 + r1) / 2, (c0 + c1) / 2);
        root.topRight = construct(grid, r0, (c0 + c1) / 2, (r0 + r1) / 2, c1);
        root.bottomLeft = construct(grid, (r0 + r1) / 2, c0, r1, (c0 + c1) / 2);
        root.bottomRight = construct(grid, (r0 + r1) / 2, (c0 + c1) / 2, r1, c1);
        return root;
    }
}
