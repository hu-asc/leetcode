package com.code.problemset.problem_46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permute {

    /**
     * 交换使用过的元素
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        int n = nums.length;
        dfs(n, output, result, 0);
        return result;
    }

    private void dfs(int n, List<Integer> output, List<List<Integer>> result, int index) {
        if (index == n) {
            result.add(new ArrayList<>(output));
            return;
        }
        for (int i = index; i < n; i++) {
            Collections.swap(output, index, i);
            dfs(n, output, result, index + 1);
            Collections.swap(output, index, i);
        }
    }


    /**
     * 判断元素是否添加过
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteV2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), nums);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            dfs(result, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }

}
