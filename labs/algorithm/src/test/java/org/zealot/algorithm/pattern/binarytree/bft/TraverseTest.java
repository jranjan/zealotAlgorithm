package org.zealot.algorithm.pattern.binarytree.bft;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.pattern.binarytree.search.bft.Traverse;
import org.zealot.algorithm.ds.tree.TreeNode;

import java.util.List;

public class TraverseTest {
    @Test
    void traverse() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> list = Traverse.traverse(root);
        System.out.println(list.toString());
    }

    @Test
    void traverseClean() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        List<List<Integer>> list = Traverse.traverseClean(root);
        System.out.println(list.toString());
    }
}
