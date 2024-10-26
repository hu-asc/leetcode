package com.code.problemset.problem_2458;

import com.code.problemset.TreeNode;

import java.util.*;

/**
 * @author huhongtao
 * @date 2024-10-26
 */
public class TreeQueries {

    Map<Integer, Integer> leftMap = new HashMap<>();
    Map<Integer, Integer> rightMap = new HashMap<>();
    Map<Integer, Integer> removed = new HashMap<>();


    /**
     * bfs 暴力方法超时
     * 遍历到该节点的时候，判断是否跟 queries[i] 相等
     * 如果不相等放入队列
     *
     * 两次 dfs
     * 第一次 dfs 先计算出当前节点的高度 leftMap, rightMap
     * 第二次 dfs 计算删除节点的高度
     */
    public int[] treeQueries(TreeNode root, int[] queries) {
        getHeight(root, 0);
        removed(root, 0);
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = removed.get(queries[i]);
        }
        return result;
    }

    /**
     * 删除当前节点的最高高度是相反的节点的高度和当前高度的最大值
     */
    private void removed(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        removed.put(root.val, height);
        removed(root.left, Math.max(height, rightMap.get(root.val)));
        removed(root.right, Math.max(height, leftMap.get(root.val)));
    }


    private int getHeight(TreeNode root, int height) {
        if (root == null) {
            return height - 1;
        }
        leftMap.put(root.val, getHeight(root.left, height + 1));
        rightMap.put(root.val, getHeight(root.right, height + 1));
        return Math.max(leftMap.get(root.val), rightMap.get(root.val));
    }
}
