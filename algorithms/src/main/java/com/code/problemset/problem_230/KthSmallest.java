package com.code.problemset.problem_230;

import com.code.problemset.TreeNode;

/**
 * @author huhongtao
 * @date 2024-10-22
 */
public class KthSmallest {

    int count = 0;
    int result = Integer.MIN_VALUE;

    /**
     * 中序遍历是升序
     * 所以第 k 小的值就是遍历到第 k 个的节点值
     */
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        dfs(root, k);
        return result;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        dfs(root.right, k);
    }

    /**
     * 二分搜索
     *
     * k 小于左子树的 count, 则需要在右子树查找
     */
    public int kthSmallestV2(TreeNode root, int k) {
        int count = countNode(root.left);
        if (k <= count) {
            return kthSmallestV2(root.left, k);
        } else if (k > count + 1) {
            return kthSmallestV2(root.right, k - 1 - count);
        }
        return root.val;
    }

    private int countNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNode(root.left) + countNode(root.right);
    }
}
