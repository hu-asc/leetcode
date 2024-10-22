package com.code.problemset.problem_392;

/**
 * @author huhongtao
 * @date 2024-10-21
 */
public class IsSubsequence {


    /**
     * 判断字符串 s 中的所有字符和 t 中相等的次数是否等于 s.length()
     */
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (j < t.length()) {
                char c1 = t.charAt(j++);
                if(c == c1) {
                    count++;
                    break;
                }
            }
        }
        return count == s.length();
    }

    /**
     * 双指针
     */
    public boolean isSubsequenceV2(String s, String t) {
        int sp = 0;
        int tp = 0;
        while (sp < s.length() && tp < t.length()) {
            if (s.charAt(sp) == t.charAt(tp)) {
                sp++;
            }
            tp++;
        }
        return sp == s.length();
    }
}
