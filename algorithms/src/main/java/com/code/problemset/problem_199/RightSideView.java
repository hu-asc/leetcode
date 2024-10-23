package com.code.problemset.problem_199;

import com.code.problemset.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author huhongtao
 * @date 2024-10-22
 */
public class RightSideView {

    /**
     * bfs 遍历
     *
     * 先将右节点放入队列，所以 i == 0 时的值就需要放入结果集合
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == 0) {
                    result.add(poll.val);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
            }
        }
        return result;
    }


    /**
     * dfs 遍历
     * 优先遍历右节点
     *
     * 每层选取一个节点
     */
    public List<Integer> rightSideViewV2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideView(root, result, 0);
        return result;
    }

    private void rightSideView(TreeNode root, List<Integer> result, int level) {
        if (root == null) {
            return;
        }
        if (level == result.size()) {
            result.add(root.val);
        }
        rightSideView(root.right, result, level + 1);
        rightSideView(root.left, result, level + 1);
    }
}
