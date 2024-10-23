package com.code.problemset.problem_637;

import com.code.problemset.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author huhongtao
 * @date 2024-10-23
 */
public class AverageOfLevels {

    /**
     * bfs 遍历
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            double size = queue.size();
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
            result.add(sum / size);
        }
        return result;
    }

    /**
     * dfs 遍历
     * countList 保存每层的节点个数
     */
    public List<Double> averageOfLevelsV2(TreeNode root) {
        List<Double> result = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();
        dfs(root, result, countList, 0);
        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i) / countList.get(i));
        }
        return result;
    }

    private void dfs(TreeNode root, List<Double> result, List<Integer> countList, int level) {
        if (root == null) {
            return;
        }
        if (result.size() <= level) {
            result.add(0.0);
            countList.add(0);
        }
        result.set(level, result.get(level) + root.val);
        countList.set(level, countList.get(level) + 1);
        dfs(root.left, result, countList, level + 1);
        dfs(root.right, result, countList, level + 1);
    }
}
