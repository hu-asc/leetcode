package com.code.problemset.problem_155;

import java.util.Stack;

public class MinStackV2 {

    private Stack<Node> stack;

    /**
     * 新增node类来同时保存值和最小值
     */
    public MinStackV2() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Node(val, val));
        } else {
            stack.push(new Node(val, Math.min(val, stack.peek().min)));

        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }

    static class Node {

        int val;

        int min;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

}
