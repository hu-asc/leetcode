package com.code.problemset.problem_98;

import com.code.problemset.TreeNode;

import java.util.Stack;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 10^4].
 * -2^31 <= Node.val <= 2^31 - 1
 */
public class IsValidBST {

    /**
     * 递归判断子树是否在(min, max)之间
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long minVal, long maxVal) {
        if (node == null) {
            return true;
        }
        if (node.val <= minVal || node.val >= maxVal) {
            return false;
        }
        return isValidBST(node.left, minVal, node.val) && isValidBST(node.right, node.val, maxVal);
    }

    /**
     * 中序遍历的数组为递增的
     * 无需保存全部节点，只需比较相邻节点
     */
    public boolean isValidBSTV2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (pre != null && root.val <= pre.val) {
                    return false;
                }
                pre = root;
                root = root.right;
            }
        }
        return true;
    }

    // node 的 val 可以为 int 的最小值，所以此处使用 Long.MIN_VALUE
    long prev = Long.MIN_VALUE;

    /**
     * 中序遍历
     */
    public boolean isValidBSTV3(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBSTV3(root.left)) {
            return false;
        }
        if (root.val <= prev) {
            return false;
        }
        prev = root.val;
        return isValidBSTV3(root.right);
    }


    /**
     * 中序遍历
     */
    public boolean isValidBSTV4(TreeNode root) {
        if (root == null) {
            return true;
        }
        prev = Long.MIN_VALUE;
        return inOrder(root);
    }

    private boolean inOrder(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isLeftValid = inOrder(root.left);
        if (!isLeftValid) {
            return false;
        }
        // 当前节点不能小于前一个节点
        if (root.val <= prev) {
            return false;
        }
        prev = root.val;
        return inOrder(root.right);
    }

}
