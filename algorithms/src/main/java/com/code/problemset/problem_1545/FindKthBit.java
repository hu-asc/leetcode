package com.code.problemset.problem_1545;

/**
 * @author huhongtao
 * @date 2024-10-19
 */
public class FindKthBit {

    /**
     * n 的规模较小，可以暴力模拟出来
     */
    public char findKthBit(int n, int k) {
        StringBuilder builder = new StringBuilder("0");
        for (int i = 0; i < n; i++) {
            String tmp = builder.toString();
            builder.append("1");
            for (int j = tmp.length() - 1; j >= 0; j--) {
                char c = tmp.charAt(j);
                if (c == '0') {
                    builder.append("1");
                } else {
                    builder.append("0");
                }
            }
        }
        System.out.println(builder.toString());
        return builder.charAt(k - 1);
    }


    /**
     * 递归
     */
    public char findKthBitV2(int n, int k) {
        String str = getStr(n);
        return str.charAt(k - 1);
    }

    private String getStr(int index) {
        if (index == 0) {
            return "0";
        }
        String prevStr = getStr(index - 1);
        StringBuilder builder = new StringBuilder(prevStr);
        builder.append("1");
        for (int j = prevStr.length() - 1; j >= 0; j--) {
            builder.append(prevStr.charAt(j) == '1' ? '0' : '1');
        }
        return builder.toString();
    }


    /**
     * 递归可以优化
     * Sn 由左半部分（Sn-1）, 1 和 反转的右半部分(反转的 Sn-1 )
     *
     * 判断 k 所处的位置
     * 如果在左半部分，则在 Sn-1 查找，
     * 如果在右半部分，则在反转的 Sn-1 查找
     */
    public char findKthBitV3(int n, int k) {
        if (n == 1) {
            return '0';
        }
        // Sn 的真实长度为 2^n - 1， 也可以使用这个，题目第 k 位下标表示从 0 开始，所以此处使用了2^n
        int len = 1 << n;
        if (k < len / 2) {
            return findKthBitV3(n - 1, k);
        } else if (k == len / 2) {
            return '1';
        } else {
            char c = findKthBitV3(n - 1, len - k);
            return c == '1' ? '0' : '1';
        }
    }

}
