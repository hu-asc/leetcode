package com.code.problemset.problem_1106;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huhongtao
 * @date 2024-10-20
 */
public class ParseBoolExprTest {

    @Test
    public void test() {
        ParseBoolExpr parseBoolExpr = new ParseBoolExpr();

        String expression = "&(|(f))";
        boolean expected = false;
        boolean result = parseBoolExpr.parseBoolExpr(expression);
        Assert.assertEquals(expected, result);
        result = parseBoolExpr.parseBoolExprV2(expression);
        Assert.assertEquals(expected, result);
        result = parseBoolExpr.parseBoolExprV3(expression);
        Assert.assertEquals(expected, result);

        expression = "|(f,f,f,t)";
        expected = true;
        result = parseBoolExpr.parseBoolExpr(expression);
        Assert.assertEquals(expected, result);
        ParseBoolExpr.index = 0;
        result = parseBoolExpr.parseBoolExprV2(expression);
        Assert.assertEquals(expected, result);
        result = parseBoolExpr.parseBoolExprV3(expression);
        Assert.assertEquals(expected, result);

        expression = "!(&(f,t))";
        expected = true;
        result = parseBoolExpr.parseBoolExpr(expression);
        Assert.assertEquals(expected, result);
        ParseBoolExpr.index = 0;
        result = parseBoolExpr.parseBoolExprV2(expression);
        Assert.assertEquals(expected, result);
        result = parseBoolExpr.parseBoolExprV3(expression);
        Assert.assertEquals(expected, result);
    }
}
