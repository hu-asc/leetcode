package com.code.problemset.problem_670;

/**
 * @author huhongtao
 * @date 2024-10-17
 */
public class MaximumSwap {


    /**
     * 暴力方法
     * 交换后，判断最大值
     */
    public int maximumSwap(int num) {
        int max = num;
        char[] charArray = String.valueOf(num).toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            for (int j = i + 1; j < charArray.length; j++) {
                swap(charArray, i, j);
                max = Math.max(max, Integer.parseInt(new String(charArray)));
                swap(charArray, i, j);
            }
        }
        return max;
    }


    private void swap(char[] charArray, int i, int j) {
        char t = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = t;
    }



    /**
     * 贪心
     * 每一位数字应该不小于所有排它后面的数字，否则找最大的且排在最后面的数字交换
     *
     * 所以当遇到多个相同数字的时候，与最后一个相同数字交换
     *
     * 倒序遍历，找到最大值下标，
     * 当 charArray[i] < charArray[maxIndex]，需要交换
     */
    public int maximumSwapV2(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int maxIndex = charArray.length - 1;
        int p = -1, q = -1;
        for (int i = charArray.length - 2; i >= 0; i--) {
            if (charArray[i] > charArray[maxIndex]) {
                maxIndex = i;
            } else if (charArray[i] < charArray[maxIndex]) {
                // i 右侧有大于它的，满足交换条件，i 越靠近左侧越好
                p = i;
                q = maxIndex;
            }
        }
        if (p == -1) {
            return num;
        }
        swap(charArray, p, q);
        return Integer.parseInt(new String(charArray));
    }

}
