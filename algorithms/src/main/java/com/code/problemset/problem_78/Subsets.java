package com.code.problemset.problem_78;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    /**
     * 回溯法
     * 选择index或者不选择index
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(nums, result, new ArrayList<>(), 0);
        return new ArrayList<>(result);
    }

    private void subsets(int[] nums, List<List<Integer>> result, List<Integer> list, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        // 不选index
        subsets(nums, result, list, index + 1);

        // 选择index
        list.add(nums[index]);
        subsets(nums, result, list, index + 1);

        list.remove(list.size() - 1);
    }


    /**
     * 迭代
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsV2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list = new ArrayList<>(result.get(i));
                list.add(num);
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> subsets1 = subsets.subsets(nums);
        System.out.println(subsets1.toString());
    }
}
