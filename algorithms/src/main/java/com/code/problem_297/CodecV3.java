package com.code.problem_297;

import com.code.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

public class CodecV3 {

    private final String nil = "x";

    private final String splitter = ",";

    /**
     * recursive preorder
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        buildString(root, builder);
        return builder.toString();
    }

    private void buildString(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append(nil).append(splitter);
        } else {
            builder.append(root.val).append(splitter);
            buildString(root.left, builder);
            buildString(root.right, builder);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        LinkedList<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        TreeNode root = buildTree(queue);
        return root;
    }

    private TreeNode buildTree(LinkedList<String> queue) {
        String val = queue.poll();
        if (nil.equals(val)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }

}
