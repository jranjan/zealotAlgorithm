package org.zealot.algorithm.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.ds.tree.TreeNode;
import org.zealot.algorithm.scratchpad.one.BinaryTreeSpiralTraversal;

public class BinaryTreeSpiralTraversalTest {

    @Test
    void traverse() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(20);
        root.right = new TreeNode(21);
        root.left.left = new TreeNode(100);
        root.left.right = new TreeNode(101);
        root.right.left = new TreeNode(102);
        root.right.right = new TreeNode(103);
        root.left.left.left = new TreeNode(1000);
        root.left.left.right = new TreeNode(1001);
        root.left.right.left = new TreeNode(1002);
        root.left.right.right = new TreeNode(1003);
        root.right.left.left = new TreeNode(1004);
        root.right.left.right = new TreeNode(1005);
        root.right.right.left = new TreeNode(1006);
        root.right.right.right = new TreeNode(1007);

        System.out.println("Breadth First Traversal=%s".format(BinaryTreeSpiralTraversal.traverse(root).toString()));
    }
}
