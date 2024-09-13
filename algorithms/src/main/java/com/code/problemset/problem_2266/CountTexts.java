package com.code.problemset.problem_2266;

import java.awt.image.ImagingOpException;
import java.util.Arrays;

public class CountTexts {


    /**
     * 先找出相同的字符串，然后递归获取次数（需要判断最多3次或者4次按键），最后每个字符串次数相乘
     *
     * @param pressedKeys
     * @return
     */

    public int countTexts(String pressedKeys) {
        int MOD = 1_000_000_007;
        int ans = 1;
        int count = 0;
        for (int i = 0; i < pressedKeys.length(); i++) {
            char c = pressedKeys.charAt(i);
            count++;
            if (i == pressedKeys.length() - 1 || c != pressedKeys.charAt(i + 1)) {
                ans =  ans * (dfs(count, c) % MOD);
                count = 0;
            }
        }
        return ans;
    }

    private int dfs(int count, char c) {
        int MOD = 1_000_000_007;
        if (count <= 0) {
            return 1;
        }
        int res = 0;
        if (count >= 1) {
            res += dfs(count - 1, c) % MOD;
        }
        if (count >= 2) {
            res += dfs(count - 2, c) % MOD;
        }
        if (count >= 3) {
            res += dfs(count - 3, c) % MOD;
        }
        if (count >= 4 && (c == '7' || c == '9')) {
            res += dfs(count - 4, c) % MOD;
        }
        return res;
    }


    public int countTextsV2(String pressedKeys) {
        int MOD = 1_000_000_007;
        int ans = 1;
        int count = 0;
        int[] memo1 = new int[100_001];
        int[] memo2 = new int[100_001];
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);
        for (int i = 0; i < pressedKeys.length(); i++) {
            char c = pressedKeys.charAt(i);
            count++;
            if (i == pressedKeys.length() - 1 || c != pressedKeys.charAt(i + 1)) {
                ans =  ans * (dfs(count, c, memo1, memo2) % MOD);
                count = 0;
            }
        }
        return ans;
    }


    private int dfs(int count, char c, int[] memo1, int[] memo2) {
        int MOD = 1_000_000_007;
        if (count <= 0) {
            return 1;
        }
        if (c == '7' || c == '9') {
            if (memo1[count] != -1) {
                return memo1[count];
            }
        } else {
            if (memo2[count] != -1) {
                return memo2[count];
            }
        }
        int res = 0;
        if (count >= 1) {
            res += dfs(count - 1, c, memo1, memo2) % MOD;
        }
        if (count >= 2) {
            res += dfs(count - 2, c, memo1, memo2) % MOD;
        }
        if (count >= 3) {
            res += dfs(count - 3, c, memo1, memo2) % MOD;
        }
        if (count >= 4 && (c == '7' || c == '9')) {
            res += dfs(count - 4, c, memo1, memo2) % MOD;
        }
        if (c == '7' || c == '9') {
            memo1[count] = res;
        } else {
            memo2[count] = res;
        }
        return res;
    }


    /**
     * dp[i]表示长度为 i 的只有一种字符的字符串对应的数量
     *
     * 对于字符不为 7 或 9， 则 dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
     * 对于字符为 7 或 9，则 dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4]
     * @param pressedKeys
     * @return
     */
    public int countTextsV3(String pressedKeys) {
        int MOD = 1_000_000_007;
        int[] dp3 = new int[100_001];
        int[] dp4 = new int[100_001];
        dp3[0] = dp4[0] = 1;
        dp3[1] = dp4[1] = 1;
        dp3[2] = dp4[2] = 2;
        dp3[3] = dp4[3] = 4;
        for (int i = 4; i < dp3.length; i++) {
            dp3[i] = (dp3[i - 1] + dp3[i - 2] + dp3[i - 3]) % MOD;
            dp4[i] = (dp3[i - 1] + dp3[i - 2] + dp3[i - 3] + dp4[i - 4]) % MOD;
        }
        int ans = 1;
        int count = 0;
        for (int i = 0; i < pressedKeys.length(); i++) {
            char c = pressedKeys.charAt(i);
            count++;
            if (i == pressedKeys.length() - 1 || c != pressedKeys.charAt(i + 1)) {
                if (c == '7' || c == '9') {
                    ans = ans * (dp4[count]) % MOD;
                } else {
                    ans = ans * (dp3[count]) % MOD;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        CountTexts countTexts = new CountTexts();
        String pressedKeys = "22233";
        System.out.println(countTexts.countTexts(pressedKeys));
        System.out.println(countTexts.countTextsV2(pressedKeys));
        System.out.println(countTexts.countTextsV3(pressedKeys));

        pressedKeys = "222222222222222222222222222222222222";
//        System.out.println(countTexts.countTexts(pressedKeys));
        System.out.println(countTexts.countTextsV2(pressedKeys));
        System.out.println(countTexts.countTextsV3(pressedKeys));
    }

}
