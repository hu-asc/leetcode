package com.code.problemset.problem_30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huhongtao
 * @date 2024-10-21
 */
public class FindSubstring {

    /**
     * 滑动窗口
     *
     * 统计出 words 数组对应的 countMap
     * 判断每个子串中的单词是否跟 countMap 的一致
     */
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        int n = s.length(), num = words.length, wordLen = words[0].length();
        for (int i = 0; i <= n - num * wordLen; i++) {
            String substring = s.substring(i, i + num * wordLen);
            if (check(substring, countMap, wordLen)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean check(String substring, Map<String, Integer> countMap, int wordLen) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < substring.length(); i += wordLen) {
            String sWord = substring.substring(i, i + wordLen);
            map.put(sWord, map.getOrDefault(sWord, 0) + 1);
        }
        return countMap.equals(map);
    }

}
