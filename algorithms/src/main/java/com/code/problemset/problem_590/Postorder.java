package com.code.problemset.problem_590;

import java.util.*;

/**
 * Given the root of an n-ary tree, return the postorder traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 10^4].
 * 0 <= Node.val <= 10^4
 * The height of the n-ary tree is less than or equal to 1000.
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class Postorder {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(Node root, List<Integer> result) {
        if (root != null) {
            if (root.children != null) {
                for (Node child : root.children) {
                    helper(child, result);
                }
            }
            result.add(root.val);
        }
    }

    public List<Integer> postorderV2(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            if (pop != null) {
                if (pop.children != null) {
                    for (Node child : pop.children) {
                        stack.push(child);
                    }
                }
                result.addFirst(pop.val);
            }
        }
        return result;
    }

    public List<Integer> postorderV3(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            if (pop != null) {
                if (pop.children != null) {
                    for (Node child : pop.children) {
                        stack.push(child);
                    }
                }
                result.add(pop.val);
            }
        }
        Collections.reverse(result);
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