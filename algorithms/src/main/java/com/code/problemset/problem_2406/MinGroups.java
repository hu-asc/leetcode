package com.code.problemset.problem_2406;

import java.util.*;

/**
 * @author huhongtao
 * @date 2024-10-12
 */
public class MinGroups {

    /**
     * 返回最小的没有重叠的区间也就是返回某点最大的有重叠的区间
     *
     * 使用有序列表，模拟整体流程，
     * left 表示进入事件， right 表示离开事件
     * 按照 left 排序，如果 left 相等，则按照 right 排序
     *
     * 判断某点的最大重叠区间可以使用前缀和
     *
     */
    public int minGroups(int[][] intervals) {
        List<int[]> events = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            events.add(new int[]{interval[0], 1});
            events.add(new int[]{interval[1] + 1, -1});
        }

        Collections.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        int max = 0;
        int curr = 0;
        for (int[] event : events) {
            curr += event[1];
            max = Math.max(curr, max);
        }
        return max;
    }

    /**
     * 最小堆
     *
     * 当堆顶元素大于于当前区间，需要创建新分组
     * 当堆顶元素小于当前区间，将当前区间拼接至分组末尾，并更新最小堆的值
     */
    public int minGroupsV2(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (!queue.isEmpty() && queue.peek() < interval[0]) {
                queue.poll();
            }
            queue.offer(interval[1]);
        }
        return queue.size();
    }

}
