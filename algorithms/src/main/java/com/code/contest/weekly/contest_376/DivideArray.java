package com.code.contest.weekly.contest_376;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivideArray {

    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i = i + 3) {
            int min = nums[i];
            int max = nums[i + 2];
            if (max - min <= k) {
                list.add(new int[]{nums[i], nums[i + 1], nums[i + 2]});
            } else {
                return new int[0][];
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
