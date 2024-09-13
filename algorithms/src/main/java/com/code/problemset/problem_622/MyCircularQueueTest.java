package com.code.problemset.problem_622;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MyCircularQueueTest {

    @Test
    public void test() {
        MyCircularQueue solution = new MyCircularQueue(8);
        List<String> result = new ArrayList<>();
        result.add(solution.enQueue(3) + "");
        result.add(solution.enQueue(9) + "");
        result.add(solution.enQueue(5) + "");
        result.add(solution.enQueue(0) + "");
        result.add(solution.deQueue() + "");
        result.add(solution.deQueue() + "");
        result.add(solution.isEmpty() + "");
        result.add(solution.isEmpty() + "");
        result.add(solution.Rear() + "");
        result.add(solution.Rear() + "");
        result.add(solution.deQueue() + "");

        String[] expected = new String[]{"true", "true", "true", "true", "true", "true", "false",
                "false", "0", "0", "true"};
        Assert.assertArrayEquals(expected, result.toArray(new String[result.size()]));

        MyCircularQueue solutionV2 = new MyCircularQueue(8);
        result = new ArrayList<>();
        result.add(solutionV2.enQueue(3) + "");
        result.add(solutionV2.enQueue(9) + "");
        result.add(solutionV2.enQueue(5) + "");
        result.add(solutionV2.enQueue(0) + "");
        result.add(solutionV2.deQueue() + "");
        result.add(solutionV2.deQueue() + "");
        result.add(solutionV2.isEmpty() + "");
        result.add(solutionV2.isEmpty() + "");
        result.add(solutionV2.Rear() + "");
        result.add(solutionV2.Rear() + "");
        result.add(solutionV2.deQueue() + "");
        Assert.assertArrayEquals(expected, result.toArray(new String[result.size()]));
    }
}
