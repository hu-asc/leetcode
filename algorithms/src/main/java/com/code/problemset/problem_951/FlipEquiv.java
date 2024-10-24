package com.code.problemset.problem_951;

import com.code.problemset.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huhongtao
 * @date 2024-10-24
 */
public class FlipEquiv {

    /**
     * 反转任意节点，所以需要判断反转与没有反转的两种情况
     * 反转需要判断 root1.left 与 root2.right 是否相等和 root1.right 与 root2.left 是否相等
     * 没有反转要判断 root1.left 与 root2.left 是否相等和 root1.right 与 root2.right 是否相等
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null && root2 != null) {
            return false;
        }
        if (root1 != null && root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        boolean swap = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        boolean noSwap = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        return swap || noSwap;
    }

    /**
     * 树的值是唯一的，所以可以使用遍历的方式
     * 数据按照从小到大排列
     */
    public boolean flipEquivV2(TreeNode root1, TreeNode root2) {
        List<Integer> val1 = new ArrayList<>();
        List<Integer> val2 = new ArrayList<>();
        dfs(root1, val1);
        dfs(root2, val2);
        System.out.println(val1.toString());
        System.out.println(val2.toString());
        return val1.equals(val2);
    }

    private void dfs(TreeNode root, List<Integer> val) {
        if (root == null) {
            return;
        }
        val.add(root.val);
        int l = root.left != null ? root.left.val : -1;
        int r = root.right != null ? root.right.val : -1;
        if (l < r) {
            dfs(root.left, val);
            dfs(root.right, val);
        } else{
            dfs(root.right, val);
            dfs(root.left, val);
        }
        // 不同深度的树可能有相同输出，需要加上这句话保证遍历的深度相同
        val.add(null);
    }
}
