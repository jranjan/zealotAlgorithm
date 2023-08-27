package org.zealot.algorithm.pattern.binarytree.search.dft;

import org.zealot.algorithm.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindPathsWithMaximumSum {

    public static List<Integer> findPaths(TreeNode root) {
        List<Integer> currentPath = new ArrayList<Integer>();
        List<Integer> maximumPath = new ArrayList<Integer>();
        findMaximumSumPathsRecursive(root, currentPath, maximumPath);
        return maximumPath;
    }

    private static void findMaximumSumPathsRecursive(TreeNode root, List<Integer> currPath, List<Integer> maximumPath){
        if (root == null) {
            return;
        }

        // Add the node, needed if we do not do comparison
        currPath.add(root.val);
        if ((root.left == null) && (root.right == null)) {
            // Hit the leaf, find sum of path
            if (findSum(currPath) > findSum(maximumPath)) {
                maximumPath.clear();
                maximumPath.addAll(currPath);
            }
         } else {
            findMaximumSumPathsRecursive(root.left, currPath, maximumPath);
            findMaximumSumPathsRecursive(root.right, currPath, maximumPath);
        }

        // chop the node as we are unwinding the tree
        currPath.remove(currPath.size() -1);
    }

    private  static int findSum(List<Integer> list) {
        int sum = 0;
        for (int n: list) {
            sum = sum + n;
        }
        return sum;
    }
}
