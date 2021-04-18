package com.code.problem_145;

import java.util.*;

/**
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 *
 * Constraints:
 * The number of the nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * Follow up:
 * Recursive solution is trivial, could you do it iteratively?
 */
public class PostorderTraversal {

    /**
     * 左 -> 右 -> 根
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    private void traversal(TreeNode root, List<Integer> result) {
        if  (root != null) {
            traversal(root.left, result);
            traversal(root.right, result);
            result.add(root.val);
        }
    }


    public List<Integer> postorderTraversalV2(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                result.addFirst(root.val);
                root = root.right;
            } else {
                root = stack.pop();
                root = root.left;
            }
        }
        return result;
    }


    /**
     * 根 -> 右 -> 左  翻转为 左 -> 右 -> 根
     */
    public List<Integer> postorderTraversalV3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                result.add(root.val);
                root = root.right;
            } else {
                root = stack.pop();
                root = root.left;
            }
        }
        Collections.reverse(result);
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