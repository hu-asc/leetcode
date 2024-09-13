package com.code.problemset.problem_20;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * Constraints:
 * 1 <= s.length <= 10^4
 * s consists of parentheses only '()[]{}'.
 */
public class IsValid {


    /**
     * 暴力
     * 比较相邻元素，如果匹配则置为空，然后重新遍历，如果最终字符为空，则是合法的
     */
    public boolean isValid(String s) {
        StringBuilder builder = new StringBuilder(s);
        int count = s.length() / 2;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < builder.length() - 1; j++) {
                char c1 = builder.charAt(j);
                char c2 = builder.charAt(j + 1);
                if ((c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}')) {
                    builder.delete(j, j + 2);
                    break;
                }
            }
        }
        return builder.length() == 0;
    }


    /**
     * 上面方法会重复遍历元素，所以用栈来保存元素，遍历到右括号则和栈顶元素匹配，如果不符合则字符不合法，
     * 直到遍历结束，判断栈是否为空
     */
    public boolean isValidV2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (!((pop == '(' && c == ')') || (pop == '[' && c ==']') || (pop == '{' && c == '}'))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
