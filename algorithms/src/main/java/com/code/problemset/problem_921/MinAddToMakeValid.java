package com.code.problemset.problem_921;

import java.util.Stack;

/**
 * @author huhongtao
 * @date 2024-10-09
 */
public class MinAddToMakeValid {

    /**
     * 当字符为 ( ，则 openBrackets++
     * 当字符为 ) ，如果 openBrackets > 0，则说明可以匹配一个 ( ，openBrackets--，反之则需要增加次数
     */
    public int minAddToMakeValid(String s) {
        int openBrackets = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openBrackets++;
            } else {
                if (openBrackets > 0) {
                    openBrackets--;
                } else {
                    count++;
                }
            }
        }
        return openBrackets + count;
    }

    /**
     * 使用 stack
     * 当字符为 ( ，则入栈，如果当前字符为 ) 且栈顶元素为 (，则出栈
     * 否则统计需要插入括号的次数
     * 结果为 次数 + 栈大小
     */
    public int minAddToMakeValidV2(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (!stack.isEmpty() && c == ')' && '(' == stack.peek()) {
                stack.pop();
            } else {
                count++;
            }
        }
        return count + stack.size();
    }

}
