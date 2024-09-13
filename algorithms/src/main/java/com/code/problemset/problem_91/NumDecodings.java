package com.code.problemset.problem_91;

public class NumDecodings {

    /**
     * dp[i]表示字符串中前 i 个字符的编码总数
     * dp[i] = dp[i - 1], s[i] != '0'
     * dp[i] += dp[i - 2], s[i-1] != '0' 且 s[i-1] 和 s[i] 组成的数字 <= 26
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

}
