package com.code.problem_144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class PreorderTraversal {

    /**
     * 根 ->左 -> 右
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    private void traversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            traversal(root.left, result);
            traversal(root.right, result);
        }
    }

    public List<Integer> preorderTraversalV2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                result.add(root.val);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
        return result;
    }

}

class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}