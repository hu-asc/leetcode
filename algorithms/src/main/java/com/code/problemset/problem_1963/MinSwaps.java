package com.code.problemset.problem_1963;

/**
 * @author huhongtao
 * @date 2024-10-08
 */
public class MinSwaps {

    /**
     * 遍历字符串 s，当 ] 的数量大于 [，则需要交换，和最后一个 ] 交换，
     * 然后判断是否平衡
     *
     * 上述方式会超时，我们只需要统计次数，不需要进行交换操作
     */
    public int minSwaps(String s) {
        int closed = 0;
        int open = 0;
        int count = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == ']') {
                closed++;
            } else {
                open++;
            }
            if (closed > open) {
                // swap
                count++;
                closed--;
                open++;
            }
        }
        return count;
    }

}
