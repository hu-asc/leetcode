package com.code.problemset.problem_1593;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huhongtao
 * @date 2024-10-21
 */
public class MaxUniqueSplit {


    /**
     * 回溯
     * 判断每个字串是否与之前的相同（用哈希表判断）
     * 如果不同，则拆分剩下的字串
     */
    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        return backtrack(s, 0, set);
    }

    private int backtrack(String s, int start, Set<String> set) {
        if (start == s.length()) {
            return 0;
        }
        int count = 0;
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (!set.contains(substring)) {
                set.add(substring);
                count = Math.max(count, backtrack(s, end, set) + 1);
                set.remove(substring);
            }
        }
        return count;
    }


    int maxCount = 1;

    /**
     * 剪枝
     */
    public int maxUniqueSplitV2(String s) {
        Set<String> set = new HashSet<>();
        backtrack(s, 0, set, 0);
        return maxCount;
    }

    private void backtrack(String s, int start, Set<String> set, int split) {
        if (start == s.length()) {
            maxCount = Math.max(maxCount, split);
            return;
        }
        // 剪枝：如果剩下的字符串每个都是一个一个划分，仍然小于 maxCount，可直接返回
        if (set.size() + s.length() - start < maxCount) {
            return;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (!set.contains(substring)) {
                set.add(substring);
                backtrack(s, end, set, split + 1);
                set.remove(substring);
            }
        }
    }

}
