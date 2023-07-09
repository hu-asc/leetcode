package com.code.problem_22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Constraints:
 * 1 <= n <= 8
 */
public class GenerateParenthesis {

    /**
     * 得到所有的组合，然后判断括号是否合法
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateAll(0, 2 * n, "", result);
        return result;
    }

    private void generateAll(int pos, int max, String s, List<String> result) {
        if (pos == max) {
            if (valid(s)) {
                result.add(s);
            }
            return;
        }
        generateAll(pos + 1, max, s + "(", result);
        generateAll(pos + 1, max, s + ")", result);
    }

    private boolean valid(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }


    /**
     * 在序列有效时添加'('或')'
     */
    public List<String> generateParenthesisV2(int n) {
        List<String> result = new ArrayList<>();
        generate(0, 0, n, "", result);
        return result;
    }

    private void generate(int left, int right, int n, String s, List<String> result) {
        if (left == n && right == n) {
            result.add(s);
            return;
        }
        // 左括号小于n,则可以添加"("
        if (left < n) {
            generate(left + 1, right, n, s + "(", result);
        }
        // 左括号数量大于右括号数量,则可以添加")"
        if (left > right && right < n) {
            generate(left, right + 1, n, s + ")", result);
        }
    }

}
