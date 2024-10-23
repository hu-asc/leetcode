package com.code.problemset.problem_2641;

import com.code.problemset.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author huhongtao
 * @date 2024-10-23
 */
public class ReplaceValueInTree {

    /**
     * 两次 bfs
     * 第一次求出每层的 sum
     * 第二次求出每层的节点对应的子树的 siblingSum，然后对应层数的 sum - siblingSum 即为所求结果
     */
    public TreeNode replaceValueInTree(TreeNode root) {
        List<Integer> levelSums = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            levelSums.add(sum);
        }

        // 替换值
        queue.add(root);
        int level = 1;
        root.val = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                // 算出当前根节点的子节点的 sum
                int sum = (poll.left != null ? poll.left.val : 0) + (poll.right != null ? poll.right.val : 0);
                if (poll.left != null) {
                    poll.left.val = levelSums.get(level) - sum;
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    poll.right.val = levelSums.get(level) - sum;
                    queue.add(poll.right);
                }
            }
            level++;
        }
        return root;
    }


    /**
     * 两次 dfs
     *
     * 第一次先计算出每层的 sum
     *
     * 第二次遍历
     * sum - 子节点总和 就是替换后的节点值得
     */
    public TreeNode replaceValueInTreeV2(TreeNode root) {
        List<Integer> levelSums = new ArrayList<>();
        sum(root, 0, levelSums);
        replace(root, 1, levelSums);
        root.val = 0;
        return root;
    }

    private void replace(TreeNode root, int level, List<Integer> levelSums) {
        if (root == null) {
            return;
        }
        int leftVal = root.left != null ? root.left.val : 0;
        int rightVal = root.right != null ? root.right.val : 0;
        int sum = leftVal + rightVal;
        if (root.left != null) {
            root.left.val = levelSums.get(level) - sum;
            replace(root.left, level + 1, levelSums);
        }
        if (root.right != null) {
            root.right.val = levelSums.get(level) - sum;
            replace(root.right, level + 1, levelSums);
        }
    }

    private void sum(TreeNode root, int level, List<Integer> levelSums) {
        if (root == null) {
            return;
        }
        if (levelSums.size() <= level) {
            levelSums.add(0);
        }
        levelSums.set(level, levelSums.get(level) + root.val);
        sum(root.left, level + 1, levelSums);
        sum(root.right, level + 1, levelSums);
    }

}
