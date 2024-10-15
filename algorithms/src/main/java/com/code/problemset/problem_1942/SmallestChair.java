package com.code.problemset.problem_1942;

import java.util.*;

/**
 * @author huhongtao
 * @date 2024-10-11
 */
public class SmallestChair {

    /**
     * 根据到达时间排序
     *
     * chairTime 标记数组
     * chairTime[i] == 0时，表示第 i 把椅子空闲
     * chairTime[i] != 0时，表示第 chairTime[i] 时变为空闲
     *
     */
    public int smallestChair(int[][] times, int targetFriend) {
        int[] target = times[targetFriend];
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int[] chairTime = new int[times.length];
        for (int[] time : times) {
            for (int i = 0; i < times.length; i++) {
                // 如果离开时间小于等于到达时间，则更新椅子编号的空闲时间
                // 表示上一个人离开，下一个人可以直接选择该椅子，就需要更新该椅子的空闲时间
                if (chairTime[i] <= time[0]) {
                    chairTime[i] = time[1];
                    if (Arrays.equals(time, target)) {
                        return i;
                    }
                    break;
                }
            }
        }
        return 0;
    }


    /**
     * 使用最小堆
     * 将朋友的到达和离开作为事件，模拟整个流程
     *
     * 当朋友离开，则占用椅子出堆
     * 当朋友到达，则占用椅子入堆，并标记椅子被占用
     */
    public int smallestChairV2(int[][] times, int targetFriend) {
        List<int[]> events = new ArrayList<>();
        for (int i = 0; i < times.length; i++) {
            events.add(new int[]{times[i][0], i});
            events.add(new int[]{times[i][1], -i});
        }
        Collections.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> chairQueue = new PriorityQueue<>();
        PriorityQueue<int[]> usedChairQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // 初始化椅子编号
        for (int i = 0; i < times.length; i++) {
            chairQueue.add(i);
        }
        for (int[] event : events) {
            int time = event[0];
            int index = event[1];
            // 朋友离开
            while (!usedChairQueue.isEmpty() && usedChairQueue.peek()[0] <= time) {
                chairQueue.add(usedChairQueue.poll()[1]);
            }
            // 朋友到达
            if (index >= 0) {
                int chair = chairQueue.poll();
                if (index == targetFriend) {
                    return chair;
                }
                usedChairQueue.add(new int[]{times[index][1], chair});
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        SmallestChair smallestChair = new SmallestChair();
        int[][] times = new int[][]{{1,4},{2,3},{4,6}};
        int targetFriend = 1;
        int i = smallestChair.smallestChair(times, targetFriend);
        System.out.println(i);
        times = new int[][]{{1,4},{2,3},{4,6}};
        i = smallestChair.smallestChairV2(times, targetFriend);
        System.out.println(i);

        times = new int[][]{{3,10},{1,5},{2,6}};
        targetFriend = 0;
        i = smallestChair.smallestChair(times, targetFriend);
        System.out.println(i);
        times = new int[][]{{3,10},{1,5},{2,6}};
        i = smallestChair.smallestChairV2(times, targetFriend);
        System.out.println(i);
    }

}
