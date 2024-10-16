package com.code.problemset.problem_1813;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author huhongtao
 * @date 2024-10-08
 */
public class AreSentencesSimilar {

    /**
     * 可使用两个双端队列，
     * 将 sentence1 和 sentence2 放入队列中，前缀或后缀相等，则出队
     *
     * sentence1 或 sentence2 所在队列为空，则两个字符串是相似的
     */
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] split1 = sentence1.split(" ");
        Deque<String> d1 = new ArrayDeque<>();
        for (String s : split1) {
            d1.push(s);
        }
        String[] split2 = sentence2.split(" ");
        Deque<String> d2 = new ArrayDeque<>();
        for (String s : split2) {
            d2.push(s);
        }
        // 判断前缀
        while (!d1.isEmpty() && !d2.isEmpty() && d1.peekFirst().equals(d2.peekFirst())) {
            d1.pollFirst();
            d2.pollFirst();
        }
        // 判断后缀
        while (!d1.isEmpty() && !d2.isEmpty() && d1.peekLast().equals(d2.peekLast())) {
            d1.pollLast();
            d2.pollLast();
        }
        return d2.isEmpty() || d1.isEmpty();
    }


    /**
     * 可以使用双指针，分别处理前缀和后缀
     */
    public boolean areSentencesSimilarV2(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        // 可减少循环次数
        if (s1.length > s2.length) {
            return areSentencesSimilarV2(sentence2, sentence1);
        }
        int start = 0;
        int end1 = s1.length - 1;
        int end2 = s2.length - 1;
        // 处理前缀
        while (start < s1.length && s1[start].equals(s2[start])) {
            start++;
        }
        // 处理后缀
        while (end1 >= 0 && s1[end1].equals(s2[end2])) {
            end1--;
            end2--;
        }
        // start 遍历完成
        return end1 < start;
    }

}
