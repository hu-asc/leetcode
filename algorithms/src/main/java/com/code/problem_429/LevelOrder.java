package com.code.problem_429;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 *
 * Constraints:
 * The height of the n-ary tree is less than or equal to 1000
 * The total number of nodes is between [0, 10^4]
 */
public class LevelOrder {

    /**
     * 广度遍历用队列
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                level.add(poll.val);
                if (poll.children != null) {
                    for (Node child : poll.children) {
                        queue.offer(child);
                    }
                }
            }
            result.add(level);
        }
        return result;
    }


    /**
     * 递归方式
     * 需要记录层数
     */
    public List<List<Integer>> levelOrderV2(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(root, 0, result);
        return result;
    }

    private void traverse(Node root, int level, List<List<Integer>> result) {
        if (root != null) {
            if (result.size() <= level) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(root.val);
            if (root.children != null) {
                for (Node child : root.children) {
                    traverse(child, level + 1, result);
                }
            }
        }
    }

}

class Node {

    public int val;

    public List<Node> children;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}