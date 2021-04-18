package com.code.problem_590;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostorderTest {

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

        Postorder solution = new Postorder();
        List<Integer> expect = Arrays.asList(5, 6, 3, 2, 4, 1);
        List<Integer> result = solution.postorder(root);
        Assert.assertEquals(result, expect);
        result = solution.postorderV2(root);
        Assert.assertEquals(result, expect);
        result = solution.postorderV3(root);
        Assert.assertEquals(result, expect);
    }
}
