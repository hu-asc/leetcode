package com.code.problemset.problem_567;

import java.util.Arrays;

/**
 * @author huhongtao
 * @date 2024-10-08
 */
public class CheckInclusion {

    /**
     * 判断字符串的全排列是否为另一个字符串的字串：
     * 全排列不会改变每个字符的个数，当两个字符串的每个字符的个数相等时，一个字符串是另一个字符串的排列
     *
     * 滑动窗口方法
     * 维护 s1 长度的固定窗口，判断 s2 中相同长度的每个字符是否相等
     * 每向右滑动，则增加进入窗口的字符次数，减少离开窗口的字符次数
     *
     */
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        // 初始化窗口
        for (int i = 0; i < n; i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = n; i < m; i++) {
            cnt2[s2.charAt(i) - 'a'] ++;
            cnt2[s2.charAt(i - n) - 'a'] --;
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 双指针方法
     *
     * 初始化 s1 对应的次数，（小于0）
     *
     * 初始化 left，right
     * 遍历 s2
     * 累加同一字符次数，如果次数大于 0，则说明同一个字符出现次数不匹配，需要向右移动 left，并且移除 left 对应的字符的次数
     *
     * 判断是否存在次数为 0 且区间长度等于 s1 长度
     */
    public boolean checkInclusionV2(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s1.charAt(i) - 'a']--;
        }
        int left = 0;
        for (int right = 0; right < m; right++) {
            int x = s2.charAt(right) - 'a';
            cnt[x]++;
            while (cnt[x] > 0) {
                cnt[s2.charAt(left) - 'a']--;
                left++;
            }
            if (right - left + 1 == n) {
                return true;
            }
        }
        return false;
    }

}
