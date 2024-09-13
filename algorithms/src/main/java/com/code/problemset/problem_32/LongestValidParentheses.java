package com.code.problemset.problem_32;

public class LongestValidParentheses {

    /**
     * dp[i]表示以下标 i 结尾的最长有效括号的长度
     * 1.当s[i] = '(',则 dp[i] = 0
     * 2.当s[i] = ')'
     *   当s[i-1] = '(',则dp[i] = dp[i-2] + 2
     *   当s[i-1] = ')'且s[i-dp[i-1]-1] = '(',则dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            }
            if (s.charAt(i) == ')') {
                // 需要判断i - 2的下标
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                // 需要判断i - dp[i - 1]的下标
                if (s.charAt(i - 1) == ')' && i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
