package com.code.problemset.problem_1684;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huhongtao
 * @date 2024-10-20
 */
public class CountConsistentStrings {

    /**
     * 将 allowed 的字符放入 hashset
     */
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            count++;
            String str = words[i];
            for (int j = 0; j < str.length(); j++) {
                if (!set.contains(str.charAt(j))) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}
