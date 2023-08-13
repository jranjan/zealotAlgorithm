package org.zealot.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.bft.Traverse;
import org.zealot.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeBreadthFirstTraversalTest {

    @Test
    void traverse() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(54);
        root.left.right = new TreeNode(55);
        root.right.left = new TreeNode(65);
        root.right.right = new TreeNode(75);

        System.out.println("Breadth First Traversal=%s".format(BinaryTreeBreadthFirstTraversal.traverse(root).toString()));
    }
}
