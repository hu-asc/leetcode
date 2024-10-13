package com.code.problemset.problem_632;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @author huhongtao
 * @date 2024-10-13
 */
public class SmallestRange {


    /**
     * 暴力
     *
     * 找到最小的区间相当于找到 nums 列表中最大和最小值的最小差值
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        int[] indices = new int[n];
        int[] range = new int[]{0, Integer.MAX_VALUE};
        while (true) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int minIndex = 0;
            for (int i = 0; i < n; i++) {
                int curr = nums.get(i).get(indices[i]);
                if (curr < min) {
                    min = curr;
                    minIndex = i;
                }
                if (curr > max) {
                    max = curr;
                }
            }
            if (max - min < range[1] - range[0]) {
                range[0] = min;
                range[1] = max;
            }
            if (++indices[minIndex] == nums.get(minIndex).size()) {
                break;
            }
        }
        return range;
    }


    /**
     * 可以使用优先队列
     *
     */
    public int[] smallestRangeV2(List<List<Integer>> nums) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            heap.offer(new int[]{nums.get(i).get(0), i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        int[] range = new int[]{0, Integer.MAX_VALUE};
        while (true) {
            int[] curr = heap.poll();
            int min = curr[0], listIndex = curr[1], elementIndex = curr[2];
            // 更新最小区间
            if ((max - min < range[1] - range[0])
                    || (max - min == range[1] - range[0] && min < range[0])) {
                range[0] = min;
                range[1] = max;
            }
            // 放入下一个元素
            if (elementIndex + 1 < nums.get(listIndex).size()) {
                int nextVal = nums.get(listIndex).get(elementIndex + 1);
                heap.offer(new int[]{nextVal, listIndex, elementIndex + 1});
                max = Math.max(max, nextVal);
            } else {
                // 因为值必须在每个列表中，只要有一个遍历完成就算结束
                break;
            }
        }
        return range;
    }

}
