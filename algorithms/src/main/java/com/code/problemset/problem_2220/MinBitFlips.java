package com.code.problemset.problem_2220;

/**
 * @author huhongtao
 * @date 2024-10-20
 */
public class MinBitFlips {

    /**
     * start 和 goal 的二进制表示的对应的 i 值不相等，就需要反转
     * 两数异或后，在判断结果的二进制的 1 的个数即为反转总数
     *
     * 判断 int 的二进制 1 的个数可以让每位数字 & 1
     *
     */
    public int minBitFlips(int start, int goal) {
        int xorResult = start ^ goal;
        int count = 0;
        while (xorResult > 0) {
            if ((xorResult & 1) == 1) {
                count++;
            }
            xorResult >>= 1;
        }
        return count;
    }

    /**
     * 暴力
     * 判断 start 和 goal 的最后一位，如果不等，则 count+1
     * 然后右移判断下一位
     */
    public int minBitFlipsV2(int start, int goal) {
        int count = 0;
        while (start > 0 || goal > 0) {
            if ((start & 1) != (goal & 1)) {
                count++;
            }
            start >>= 1;
            goal >>= 1;
        }
        return count;
    }

    /**
     * 递归思想
     * 判断最后一位，然后在判断前一位的结果，所以递归可实现
     */
    public int minBitFlipsV3(int start, int goal) {
        if (start == 0 && goal == 0) {
            return 0;
        }
        int flip = (start & 1) != (goal & 1) ? 1 : 0;
        return flip + minBitFlipsV3(start >> 1, goal >> 1);
    }
}
