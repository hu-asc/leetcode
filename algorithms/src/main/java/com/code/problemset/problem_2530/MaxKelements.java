package com.code.problemset.problem_2530;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author huhongtao
 * @date: 2024-10-14
 */
public class MaxKelements {


    /**
     * 最大堆
     *
     * 将所有数据放入堆中，每次取出最大值，累加 score，并将 ceil(nums[i] / 3) 放入堆中
     * 操作 k 次，即可得到最终结果 score
     */
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int num : nums) {
            maxHeap.offer(num);
        }
        long score = 0;
        while (k-- > 0) {
            Integer poll = maxHeap.poll();
            score += poll;
            // 两个 int 相除还是 int，需要强转
            double ceil = Math.ceil((double)poll / 3);
            maxHeap.offer(((int) ceil));
        }
        return score;
    }

}
