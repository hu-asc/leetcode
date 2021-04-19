package com.code;

import java.util.ArrayList;
import java.util.List;

public final class Utils {

    private Utils() {}

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public static List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        inorderHelper(root, result);
        return result;
    }

    private static void inorderHelper(TreeNode root, List<Integer> result) {
        if (root != null) {
            inorderHelper(root.left, result);
            result.add(root.val);
            inorderHelper(root.right, result);
        }
    }

}
