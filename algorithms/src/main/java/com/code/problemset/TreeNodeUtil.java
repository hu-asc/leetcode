package com.code.problemset;

import java.util.LinkedList;
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
}
