package com.code.problemset.problem_1945;

/**
 * @author huhongtao
 * @date 2024-10-17
 */
public class GetLucky {

    /**
     * 先将 s 中的每个字符转成数字，变成字符串
     * 然后做 k 次转换，每个位数相加
     */
    public int getLucky(String s, int k) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.toCharArray().length; i++) {
            builder.append(26 - ('z' - s.charAt(i)));
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum = 0;
            for (int j = 0; j < builder.length(); j++) {
                sum += builder.charAt(j) - '0';
            }
            builder = new StringBuilder(String.valueOf(sum));
        }
        return sum;
    }
}
