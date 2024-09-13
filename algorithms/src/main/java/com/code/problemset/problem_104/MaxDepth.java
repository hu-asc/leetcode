package com.code.problemset.problem_104;

import com.code.problemset.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 10^4].
 * -100 <= Node.val <= 100
 */
public class MaxDepth {

    /**
     * 左右子树的最大深度在加上根
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * bfs
     */
    public int maxDepthV2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            max++;
        }
        return max;
    }


    /**
     * dfs
     */
    public int maxDepthV3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        int max = 0;
        int depth = 1;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                depthStack.push(depth);
                root = root.left;
                depth++;
            } else {
                root = stack.pop();
                depth = depthStack.pop();
                max = Math.max(depth, max);
                root = root.right;
                depth++;
            }
        }
        return max;
    }

}
