package org.zealot.algorithm.dft;

import org.junit.jupiter.api.Test;
import org.zealot.ds.tree.TreeNode;

import java.util.List;

public class FindAllBranchWithTargetSumTest {
    @Test
    void validateBranchExists() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>>  allPaths = FindAllBranchWithTargetSum.findPaths(root, 23);
        System.out.println((String.format("Path count=%d", allPaths.size())));
        System.out.println(allPaths.toString());
    }
}
