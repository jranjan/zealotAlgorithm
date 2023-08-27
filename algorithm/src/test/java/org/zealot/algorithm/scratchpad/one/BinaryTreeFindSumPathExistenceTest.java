package org.zealot.algorithm.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.ds.tree.TreeNode;
import org.zealot.algorithm.scratchpad.one.BinaryTreeFindSumPathExistence;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreeFindSumPathExistenceTest {

    @Test
    void findSumPathExists() {
        System.out.println("****** test count = 1");
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        int sum = 23;
        System.out.println(String.format("Sum path=%d exists? [%b]", sum, BinaryTreeFindSumPathExistence.findSumPathExists(root, sum)));
        sum = 16;
        System.out.println(String.format("Sum path=%d exists? [%b]", sum, BinaryTreeFindSumPathExistence.findSumPathExists(root, sum)));
    }
}
