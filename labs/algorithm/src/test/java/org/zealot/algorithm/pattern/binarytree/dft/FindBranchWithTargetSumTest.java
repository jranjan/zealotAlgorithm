package org.zealot.algorithm.pattern.binarytree.dft;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.pattern.binarytree.search.dft.FindBranchWithTargetSum;
import org.zealot.algorithm.ds.tree.TreeNode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindBranchWithTargetSumTest {
    @Test
    void validateBranchExists() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        assertTrue(FindBranchWithTargetSum.findBranch(root, 23));
        assertFalse(FindBranchWithTargetSum.findBranch(root, 16));
    }
}
