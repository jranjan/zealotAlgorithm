package org.zealot.algorithm.pattern.binarytree.bft;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.pattern.binarytree.search.bft.ReverseTraversal;
import org.zealot.algorithm.ds.tree.TreeNode;

import java.util.List;

public class ReverseTraversalTest {
    @Test
    void traverse(){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        List<List<Integer>> list = ReverseTraversal.traverse(root);
        System.out.println(list.toString());
    }

    @Test
    void traverseSmart(){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        List<List<Integer>> list = ReverseTraversal.traverseSmart(root);
        System.out.println(list.toString());
    }
}
