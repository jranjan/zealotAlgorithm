package org.zealot.algorithm.scratchpad.one;

import org.zealot.algorithm.ds.tree.TreeNode;

/******************************************************************************************************
 * Analysis Syntax =  Readiness | Popularity | Code Knowledge | Analysis Knowledge | Strategy
 * Analysis = RUN | HIGH | EXCELLENT | UGLY | REFRESH
 *****************************************************************************************************/
public class BinaryTreeFindSumPathExistence {
    public static boolean findSumPathExists(TreeNode root, int sum) {
        if (root == null) return false;
        if ((root.left == null) || (root.right == null)) {
            return (root.val == sum) ? true : false;
        }

        return findSumPathExists(root.left, sum - root.val) ||
                (findSumPathExists(root.right, sum - root.val));
    }
}
