package org.zealot.algorithm.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.ds.tree.TreeNode;
import org.zealot.algorithm.scratchpad.one.BinaryTreeFindSumPathAll;

public class BinaryTreeFindSumPathAllTest {
    @Test
    void findSumPathAll() {
        System.out.println("****** test count = 1");
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        int sum = 23;
        System.out.println(String.format("TargetSum=%d, all paths=%s",
                sum, BinaryTreeFindSumPathAll.findSumPathAll(root, sum)));
        sum = 0;
        System.out.println(String.format("TargetSum=%d, all paths=%s",
                sum, BinaryTreeFindSumPathAll.findSumPathAll(root, sum)));
    }
}
