package com.code.problem_169;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    /**
     * map存储数字出现的次数
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int max = 0;
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }


    /**
     * 分治思想
     * @param nums
     * @return
     */
    public int majorityElementV2(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1);
    }

    private int majorityElement(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int mid = start + (end - start) / 2;
        int left = majorityElement(nums, start, mid);
        int right = majorityElement(nums, mid + 1, end);
        if (left == right) {
            return left;
        }
        // 统计每个元素出现的次数
        int leftCount = count(nums, left, start, end);
        int rightCount = count(nums, right, start, end);
        return leftCount > rightCount ? left : right;
    }

    private int count(int[] nums, int val, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == val) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();
        int[] nums = new int[]{3, 2, 3};
        int i = solution.majorityElement(nums);
        System.out.println(i);
    }

}
