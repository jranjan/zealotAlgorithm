package org.zealot.algorithm.pattern.binarytree.search.dft;

import org.zealot.algorithm.ds.tree.TreeNode;

public class FindBranchWithTargetSum {
    public static boolean findBranch(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        // See if both left and right tree are null then it means that we need to check only one
        if ((root.left == null) && (root.right == null)) {
            return  (sum == root.val) ? true : false;
        }

        // At least one sub-tree is not null
        return findBranch(root.left, sum-root.val) || (findBranch(root.right, sum- root.val));
    }
}
