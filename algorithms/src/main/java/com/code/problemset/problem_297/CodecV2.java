package com.code.problemset.problem_297;

import com.code.problemset.TreeNode;

import java.util.Stack;

public class CodecV2 {

    private final String nil = "x";

    private final String spliter = ",";

    /**
     * 前序, 后序遍历都可实现
     * 迭代版本的前序
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                builder.append(root.val).append(spliter);
                root = root.left;
            } else {
                builder.append(nil).append(spliter);
                root = stack.pop();
                root = root.right;
            }
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        String[] values = data.split(spliter);
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int n = values.length;
        int i = 1;
        TreeNode x = root;
        while (i < n) {
            while (i < n && !nil.equals(values[i])) {
                x.left = new TreeNode(Integer.parseInt(values[i++]));
                x = x.left;
                stack.push(x);
            }
            while (i < n && nil.equals(values[i])) {
                x = stack.pop();
                i++;
            }
            if (i < n) {
                x.right = new TreeNode(Integer.parseInt(values[i++]));
                x = x.right;
                stack.push(x);
            }
        }
        return root;
    }

}
