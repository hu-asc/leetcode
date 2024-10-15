package com.code.problemset.problem_2696;

import java.util.Stack;

/**
 * @author huhongtao
 * @date 2024-10-15
 */
public class MinLength {

    /**
     * 暴力方法
     *
     * 找到可移除的字符串（匹配 AB 或 CD），直接替换，直到匹配不到为止
     */
    public int minLength(String s) {
        while (s.contains("AB") || s.contains("CD")) {
            if (s.contains("AB")) {
                s = s.replace("AB", "");
            } else if (s.contains("CD")) {
                s = s.replace("CD", "");
            }
        }
        return s.length();
    }


    /**
     * 可以使用栈，判断当前字符和栈顶元素，如果匹配了 AB 或 CD，则弹出栈顶元素，否则将元素入栈
     * 栈的大小即为最终结果
     */
    public int minLengthV2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (c == 'B' && stack.peek() == 'A' || (c == 'D' && stack.peek() == 'C')) {
                stack.pop();
            } else {
                stack.push(c);
            }

        }
        return stack.size();
    }



    /**
     * 可以使用双指针 readPtr（用于遍历） 和 writePtr（写入位置）
     * 当匹配到字符串 AB 或 CD，则 writePtr--，否则 writePtr++
     * writePtr即为最终结果
     */
    public int minLengthV3(String s) {
        int writePtr = 0;
        char[] charArray = s.toCharArray();
        for (int readPtr = 0; readPtr < s.length(); readPtr++) {
            charArray[writePtr] = charArray[readPtr];
            if (writePtr > 0 && ((charArray[writePtr - 1] == 'A' && charArray[writePtr] == 'B')
                || (charArray[writePtr - 1] == 'C' && charArray[writePtr] == 'D'))) {
                writePtr--;
            } else {
                writePtr++;
            }
        }
        return writePtr;
    }

    public static void main(String[] args) {
        String s = "ABFCACDB";
        MinLength minLength = new MinLength();
        int i = minLength.minLength(s);
        System.out.println(i);
        i = minLength.minLengthV2(s);
        System.out.println(i);
        i = minLength.minLengthV3(s);
        System.out.println(i);

        s = "ACBBD";
        i = minLength.minLength(s);
        System.out.println(i);
        i = minLength.minLengthV2(s);
        System.out.println(i);
        i = minLength.minLengthV3(s);
        System.out.println(i);
    }

}
