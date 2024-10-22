package com.code.problemset.problem_530;

import com.code.problemset.TreeNode;

/**
 * @author huhongtao
 * @date 2024-10-22
 */
public class GetMinimumDifference {

    int min = Integer.MAX_VALUE;
    int prev;

    /**
     * 中序遍历
     * 遍历的数组为升序
     *
     * 最小的差值一定是数组中相邻的两个元素
     * 也可使用 prev 指针保存上一个节点的值，这样就无需新增数组
     */
    public int getMinimumDifference(TreeNode root) {
        prev = -1;
        inOrder(root);
        return min;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (prev == -1) {
            prev = root.val;
        } else {
            min = Math.min(min, root.val - prev);
            prev = root.val;
        }
        inOrder(root.right);
    }

}
