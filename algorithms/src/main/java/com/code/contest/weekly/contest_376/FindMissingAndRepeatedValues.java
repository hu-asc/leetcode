package com.code.contest.weekly.contest_376;

import java.util.HashMap;
import java.util.Map;

public class FindMissingAndRepeatedValues {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] array : grid) {
            for (int i : array) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
            }
        }
        map.entrySet().stream().filter(e -> e.getValue() == 2).forEach(e -> ans[0] = e.getKey());
        for (int i = 1; i <= grid.length * grid.length; i++) {
            if (!map.containsKey(i)) {
                ans[1] = i;
            }
        }
        return ans;
    }

    public int[] findMissingAndRepeatedValuesV2(int[][] grid) {
        int[] ans = new int[2];
        double pow = Math.pow(grid.length, 2);
        int tmp = (int) (pow + 1);
        for (int[] array : grid) {
            for (int i : array) {
                if ((tmp = (tmp ^ i)) == 0) {
                    ans[0] = i;
                }
                ans[1] = i;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= grid.length * grid.length; i++) {
            if (!map.containsKey(i)) {
                ans[1] = i;
            }
        }
        return ans;
    }
}
