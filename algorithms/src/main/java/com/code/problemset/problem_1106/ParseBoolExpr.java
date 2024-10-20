package com.code.problemset.problem_1106;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author huhongtao
 * @date 2024-10-20
 */
public class ParseBoolExpr {

    /**
     * 先找到 expression 中的最后一个运算符，在获取后续的 (...) ，可以计算出子字符串的结果，
     * 然后在基于此方式，逐步将子字符串缩小，最后可得到最终结果
     */
    public boolean parseBoolExpr(String expression) {
        while (expression.length() > 1) {
            int start = Math.max(expression.lastIndexOf("!"),
                    Math.max(expression.lastIndexOf("&"), expression.lastIndexOf("|")));
            int end = expression.indexOf(")", start);
            String subStr = expression.substring(start, end + 1);
            char result = evaluate(subStr);
            expression = expression.substring(0, start) + result + expression.substring(end + 1);
        }
        return expression.charAt(0) == 'f' ? false : true;
    }

    private char evaluate(String subStr) {
        char op = subStr.charAt(0);
        String values = subStr.substring(2, subStr.length() - 1);
        if (op == '!') {
            return values.charAt(0) == 'f' ? 't' : 'f';
        }
        if (op == '&') {
            return values.contains("f") ? 'f' : 't';
        }
        if (op == '|') {
            return values.contains("t") ? 't' : 'f';
        }
        return 'f';
    }

    static int index = 0;

    /**
     * 递归
     */
    public boolean parseBoolExprV2(String expression) {
        return getResult(expression);
    }

    private boolean getResult(String expression) {
        char c = expression.charAt(index++);
        if (c == 't') {
            return true;
        }
        if (c == 'f') {
            return false;
        }
        // 处理操作符
        if (c == '!') {
            // 跳过 (
            index++;
            boolean result = !getResult(expression);
            index++;
            return result;
        }
        List<Boolean> values = new ArrayList<>();
        index++;
        while (expression.charAt(index) != ')') {
            if (expression.charAt(index) == ',') {
                index++;
            } else {
                values.add(getResult(expression));
            }
        }
        index++;
        if (c == '&') {
            for (Boolean value : values) {
                if (!value) {
                    return false;
                }
            }
            return true;
        }
        if (c == '|') {
            for (Boolean value : values) {
                if (value) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }


    /**
     * 使用栈
     * 当遇到 ) ，需要进行处理
     * 找到 ) 对应的 ( ，再加上前一个操作符，即可得到结果
     */
    public boolean parseBoolExprV3(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == ')') {
                // 需要处理表达式
                List<Character> values = new ArrayList<>();
                while (stack.peek() != '(') {
                    values.add(stack.pop());
                }
                stack.pop();
                char op = stack.pop();
                char result = evaluate(op, values);
                stack.push(result);
            } else if (c != ',') {
                stack.push(c);
            }
        }
        return stack.peek() == 't';
    }

    private char evaluate(char op, List<Character> values) {
        if (op == '!') {
            for (Character value : values) {
                if (value == 'f') {
                    return 't';
                }
            }
            return 'f';
        }
        if (op == '&') {
            for (Character value : values) {
                if (value == 'f') {
                    return 'f';
                }
            }
            return 't';
        }
        if (op == '|') {
            for (Character value : values) {
                if (value == 't') {
                    return 't';
                }
            }
            return 'f';
        }
        return 'f';
    }

}
