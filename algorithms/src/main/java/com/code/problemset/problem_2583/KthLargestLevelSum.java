package com.code.problemset.problem_2583;

import com.code.problemset.TreeNode;

import java.util.*;

/**
 * @author huhongtao
 * @date 2024-10-22
 */
public class KthLargestLevelSum {


    /**
     * 层序遍历 + 最大堆
     * 层序遍历得到每层节点的 sum，并放入最大堆
     * 取出 k - 1 次，则 peek 即为最终结果
     */
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
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
            pq.add(sum);
        }
        if (pq.size() < k) {
            return -1;
        }
        for (int i = 0; i < k - 1; i++) {
            pq.remove();
        }
        return pq.peek();
    }



    /**
     * dfs + 排序
     *
     */
    public long kthLargestLevelSumV2(TreeNode root, int k) {
        List<Long> result = new ArrayList<>();
        dfs(root, 0, result);
        if (result.size() < k) {
            return -1;
        }
        Collections.sort(result, Collections.reverseOrder());
        return result.get(k - 1);
    }

    private void dfs(TreeNode root, int level, List<Long> result) {
        if (root == null) {
            return;
        }
        if (result.size() <= level) {
            result.add(0L);
        }
        result.set(level, result.get(level) + root.val);
        dfs(root.left, level + 1, result);
        dfs(root.right, level + 1, result);
    }

}
