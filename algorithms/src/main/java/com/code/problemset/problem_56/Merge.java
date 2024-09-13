package com.code.problemset.problem_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {

    /**
     * 1.按照左端点排序
     * 2.遍历排序后的区间，如果当前区间的左端点大于等于上一个区间的右端点，则将当前区间合并到上一个区间中，否则将当前区间加入到结果数组中
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (result.size() == 0 || left > result.get(result.size() - 1)[1]) {
                result.add(new int[]{left, right});
            } else {
                // 合并区间
                int maxRight = result.get(result.size() - 1)[1];
                result.get(result.size() - 1)[1] = Math.max(right, maxRight);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

}
