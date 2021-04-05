package com.code.problem_66;

/**
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Constraints:
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class PlusOne {

    /**
     * 新增数组保留每位相加的值
     * +1后可能会有进位，如果最后进位不为0,则返回的数组长度都为n+1
     */
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int add = i == digits.length - 1 ? 1 : 0;
            int m = carry + digits[i] + add;
            digits[i] = m % 10;
            carry = m / 10;
        }
        int n = digits.length;
        int length = carry > 0 ? n + 1 : n;
        int[] result = new int[length];
        System.arraycopy(digits, 0, result, length > n ? 1 : 0, n);
        if (carry > 0) {
            result[0] = digits[0] + carry;
        }
        return result;
    }


    /**
     * 无进位则直接最后一位+1
     * 有进位且进位有停止，则停止处+1
     * 有进位且循环结束也没有停止进位，则返回的数组长度须+1,且首位为1
     */
    public int[] plusOneV2(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }

}
