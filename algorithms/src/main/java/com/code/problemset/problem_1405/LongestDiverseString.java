package com.code.problemset.problem_1405;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author huhongtao
 * @date 2024-10-16
 */
public class LongestDiverseString {


    /**
     * 堆
     * 每次放置剩余当前字符最多的
     */
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        if (a > 0) {
            maxHeap.add(new int[]{a, 'a'});
        }
        if (b > 0) {
            maxHeap.add(new int[]{b, 'b'});
        }
        if (c > 0) {
            maxHeap.add(new int[]{c, 'c'});
        }
        StringBuilder builder = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            int count = curr[0];
            int character = curr[1];
            // 如果遇到跟前两个字符同样的情况，则弹出下一个数量最多的字符
            if (builder.length() >= 2 && builder.charAt(builder.length() - 1) == character &&
                    builder.charAt(builder.length() - 2) == character) {
                if (maxHeap.isEmpty()) {
                    break;
                }
                int[] poll = maxHeap.poll();
                builder.append((char)poll[1]);
                // 如果 count > 0,仍需要入堆
                if (poll[0] - 1 > 0) {
                    maxHeap.add(new int[]{poll[0] - 1, poll[1]});
                }
            } else {
                count--;
                builder.append((char)character);
            }
            if (count > 0) {
                maxHeap.add(new int[]{count, character});
            }
        }
        return builder.toString();
    }


    /**
     * 贪心算法
     * 只需要跟踪 3 个字符的计数，不需要使用优先队列
     * curra，currb，currc 来分别表示当前字符 a，b，c的计数判断是否连续添加字符
     *
     * 当某个计数器达到 2 时，停止添加该字符
     */
    public String longestDiverseStringV2(int a, int b, int c) {
        int total = a + b + c;
        int curra = 0, currb = 0, currc = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < total; i++) {
            if ((a >= b && a >= c && curra != 2) || (a > 0 && (currb == 2 || currc == 2))) {
                builder.append("a");
                a--;
                curra++;
                currb = 0;
                currc = 0;
            } else if ((b >= a && b >=c && currb != 2) || (b > 0 && (curra == 2 || currc == 2))){
                builder.append("b");
                b--;
                currb++;
                curra = 0;
                currc = 0;
            } else if ((c >= a && c >= b && currc != 2) || (c > 0 && (curra == 2 || currb == 2))) {
                builder.append("c");
                c--;
                currc++;
                curra = 0;
                currb = 0;
            }
        }
        return builder.toString();
    }

}
