package com.code.problemset.problem_125;

/**
 * @author huhongtao
 * @date 2024-10-21
 */
public class IsPalindrome {

    /**
     * 双指针
     */
    public boolean isPalindrome(String s) {
        int left = 0;
        String newS = s.toLowerCase();
        int right = newS.length() - 1;
        while (left <= right) {
            char c = newS.charAt(left);
            // 其他字符跳过循环
            if (!Character.isLetterOrDigit(c)) {
                left++;
                continue;
            }
            char r = newS.charAt(right);
            if (!Character.isLetterOrDigit(r)) {
                right--;
                continue;
            }
            if (c != r) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
