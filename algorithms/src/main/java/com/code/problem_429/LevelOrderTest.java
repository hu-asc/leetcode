package com.code.problem_429;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelOrderTest {

    @Test
    public void test() {
        Node root = new Node(1);
        Node first = new Node(3);
        Node sec = new Node(2);
        Node third = new Node(4);
        List<Node> children = new ArrayList<>();
        children.add(first);
        children.add(sec);
        children.add(third);
        root.children = children;
        List<Node> thirdChildren = new ArrayList<>();
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        thirdChildren.add(fifth);
        thirdChildren.add(sixth);
        first.children = thirdChildren;

        LevelOrder solution = new LevelOrder();
        List<List<Integer>> result = solution.levelOrder(root);
        List<List<Integer>> expect = Arrays.asList(Arrays.asList(1), Arrays.asList(3, 2, 4), Arrays.asList(5, 6));
        Assert.assertEquals(expect, result);
        result = solution.levelOrderV2(root);
        Assert.assertEquals(expect, result);
    }
}
