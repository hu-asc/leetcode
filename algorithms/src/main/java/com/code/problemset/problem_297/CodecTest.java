package com.code.problemset.problem_297;

import com.code.problemset.TreeNode;
import com.code.problemset.Utils;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CodecTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        List<Integer> expectTree = Utils.inorder(root);
        Codec codec1 = new Codec();
        String data1 = codec1.serialize(root);
        TreeNode tree = codec1.deserialize(data1);
        String expect1 = "1,x,2,x,x,";
        List<Integer> inorder = Utils.inorder(tree);
        Assert.assertEquals(expect1, data1);
        Assert.assertEquals(expectTree, inorder);

        CodecV2 codec2 = new CodecV2();
        String data2 = codec2.serialize(root);
        tree = codec2.deserialize(data2);
        String expect2 = "1,x,2,x,";
        inorder = Utils.inorder(tree);
        Assert.assertEquals(expect2, data2);
        Assert.assertEquals(expectTree, inorder);

        CodecV3 codec3 = new CodecV3();
        String data3 = codec3.serialize(root);
        tree = codec3.deserialize(data3);
        String expect3 = "1,x,2,x,x,";
        inorder = Utils.inorder(tree);
        Assert.assertEquals(expect3, data3);
        Assert.assertEquals(expectTree, inorder);
    }
}
