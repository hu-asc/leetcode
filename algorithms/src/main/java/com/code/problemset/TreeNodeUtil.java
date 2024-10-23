package com.code.problemset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author huhongtao
 * @date 2024-10-22
 */
public class TreeNodeUtil {

    private TreeNodeUtil() {}

    public static TreeNode toTreeNode(Integer[] nums) {
        Queue<TreeNode> queue = new LinkedList<>();
        int k = 0;
        TreeNode root = new TreeNode(nums[k++]);
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (k < nums.length) {
                    poll.left = nums[k] == null ? null : new TreeNode(nums[k]);
                    queue.add(poll.left);
                    k++;
                }
                if (k < nums.length) {
                    poll.right = nums[k] == null ? null : new TreeNode(nums[k]);
                    queue.add(poll.right);
                    k++;
                }
            }
        }
        return root;
    }

    public static Integer[] toArray(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        if (root != null) {
            list.add(root.val);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    list.add(poll.left.val);
                    queue.add(poll.left);
                } else if (poll.left == null && poll.right != null) {
                    list.add(null);
                }
                if (poll.right == null && poll.left != null) {
                    list.add(null);
                } else if (poll.right != null) {
                    list.add(poll.right.val);
                    queue.add(poll.right);
                }
            }
        }
        Integer[] result = new Integer[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
