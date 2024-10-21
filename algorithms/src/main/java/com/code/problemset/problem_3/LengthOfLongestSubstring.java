package com.code.problemset.problem_3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huhongtao
 * @date 2024-10-21
 */
public class LengthOfLongestSubstring {

    /**
     *
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int max = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        for (right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                max = Math.max(max, right - left);
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
        }
        // 需要判断下 max 和 set.size，如果字符都不重复，则 max = 0
        max = Math.max(max, set.size());
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
