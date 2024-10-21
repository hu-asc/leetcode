package com.code.problemset.problem_76;

import java.util.*;

/**
 * @author huhongtao
 * @date 2024-10-21
 */
public class MinWindow {


    /**
     * 滑动窗口
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int left = 0, right = 0;
        // 要判断每个字符的数量，所以使用 map 保存
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int min = Integer.MAX_VALUE;
        // 存储字符以及对应的下标集合
        Map<Character, List<Integer>> windowMap = new HashMap<>();
        int start = 0;
        for (right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (tMap.containsKey(c)) {
                if (windowMap.containsKey(c)) {
                    windowMap.get(c).add(right);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(right);
                    windowMap.put(c, list);
                }
            }
            while (check(windowMap, tMap) && windowMap.size() == tMap.size()) {
                if (min > right - left + 1) {
                    start = left;
                    min = right - left + 1;
                }
                // 右移 left，需要删除集合中对应的下标，如果下标为空，则删除该 key
                List<Integer> indexList = windowMap.get(s.charAt(left));
                if (indexList != null && !indexList.isEmpty()) {
                    indexList.remove(Integer.valueOf(left));
                    if (indexList.size() == 0) {
                        windowMap.remove(s.charAt(left));
                    } else {
                        windowMap.put(s.charAt(left), indexList);
                    }
                }
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }

    /**
     * 判断是否可以滑动窗口
     * @param map
     * @param tMap
     * @return
     */
    private boolean check(Map<Character, List<Integer>> map, Map<Character, Integer> tMap) {
        boolean slide = true;
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            Character key = entry.getKey();
            if (entry.getValue().size() < tMap.get(key)) {
                slide = false;
            }
        }
        return slide;
    }

}
