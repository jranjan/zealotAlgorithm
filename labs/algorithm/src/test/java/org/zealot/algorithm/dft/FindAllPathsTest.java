package org.zealot.algorithm.dft;

import org.junit.jupiter.api.Test;
import org.zealot.ds.tree.TreeNode;

import java.util.List;

public class FindAllPathsTest {
    @Test
    void prtinAllPaths() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.left.right = new TreeNode(10);
        root.right.left.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(51);
        root.right.right = new TreeNode(51);
        List<List<Integer>>  allPaths = FindAllPaths.findPaths(root);
        System.out.println((String.format("Path count=%d", allPaths.size())));
        System.out.println(allPaths.toString());
    }
}
