package com.code.problemset.problem_589;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal.
 * Each group of children is separated by the null value (See examples)
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 10^4].
 * 0 <= Node.val <= 10^4
 * The height of the n-ary tree is less than or equal to 1000.
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class Preorder {


    /**
     * 借鉴二叉树前序遍历
     */
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(Node root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            if (root.children != null) {
                for (Node child : root.children) {
                    helper(child, result);
                }
            }
        }
    }


    public List<Integer> preorderV2(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            if (pop != null) {
                result.add(pop.val);
                if (pop.children != null) {
                    for (int i = pop.children.size() - 1; i >= 0; i--) {
                        stack.push(pop.children.get(i));
                    }
                }
            }
        }
        return result;
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