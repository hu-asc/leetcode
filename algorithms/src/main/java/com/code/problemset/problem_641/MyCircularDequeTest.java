package com.code.problemset.problem_641;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MyCircularDequeTest {

    @Test
    public void test() {
        MyCircularDeque solution = new MyCircularDeque(3); // set the size to be 3
        List<String> result = new ArrayList<>();
        result.add(solution.insertLast(1) + "");
        result.add(solution.insertLast(2) + "");
        result.add(solution.insertFront(3) + "");
        result.add(solution.insertFront(4) + "");
        result.add(solution.getRear() + "");
        result.add(solution.isFull() + "");
        result.add(solution.deleteLast() + "");
        result.add(solution.insertFront(4) + "");
        result.add(solution.getFront() + "");
        String[] expected = new String[]{"true", "true", "true", "false", "2", "true", "true", "true", "4"};
        Assert.assertArrayEquals(result.toArray(new String[result.size()]), expected);
    }
}
