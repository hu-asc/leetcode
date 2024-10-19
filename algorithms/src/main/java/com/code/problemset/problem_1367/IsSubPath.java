package com.code.problemset.problem_1367;

import com.code.problemset.ListNode;
import com.code.problemset.TreeNode;

/**
 * @author huhongtao
 * @date 2024-10-19
 */
public class IsSubPath {

    /**
     * 递归判断当前节点是否满足
     * 如果满足在判断左右子树是否满足
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        return checkPath(root, head);
    }

    private boolean checkPath(TreeNode node, ListNode head) {
        if (node == null) {
            return false;
        }
        if (dfs(node, head)) {
            return true;
        }
        return checkPath(node.left, head) || checkPath(node.right, head);
    }

    private boolean dfs(TreeNode root, ListNode head) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.val != head.val) {
            return false;
        }
        boolean r1 = dfs(root.left, head.next);
        boolean r2 = dfs(root.right, head.next);
        return r1 || r2;
    }

}
