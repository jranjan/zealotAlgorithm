package org.zealot.algorithm.pattern.binarytree.search.dft;

import org.zealot.algorithm.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindAllBranchWithTargetSum {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<Integer>();
        findPathsRecursive(root, sum, currentPath, allPaths);
        return allPaths;
    }

    private static void findPathsRecursiveBook(TreeNode currentNode, int sum,
                                           List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (currentNode == null)
            return;

        // add the current node to the path
        currentPath.add(currentNode.val);

        // if the current node is a leaf and its value is equal to sum, save the current path
        if (currentNode.val == sum && currentNode.left == null
                && currentNode.right == null) {
            allPaths.add(new ArrayList<Integer>(currentPath));
        } else {
            // traverse the left sub-tree
            findPathsRecursiveBook(currentNode.left, sum - currentNode.val, currentPath, allPaths);
            // traverse the right sub-tree
            findPathsRecursiveBook(currentNode.right, sum - currentNode.val,
                    currentPath, allPaths);
        }

        // remove the current node from the path to backtrack,
        // we need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() - 1);
    }

    static void findPathsRecursive(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (root == null) {
            return;
        }

        // This ensures that we add the node which we are at while executing this code
        currentPath.add(root.val);

        if ((root.left == null) && (root.right == null)) {
            // We hit bulls eye
            if (root.val == sum) {
                // Add list which we prepared recursively to overall list
                allPaths.add(new ArrayList<Integer>(currentPath));
            }
        } else {
            // traverse the left sub-tree, find more
            findPathsRecursive(root.left, sum - root.val, currentPath, allPaths);
            // traverse the right sub-tree, find more
            findPathsRecursive(root.right, sum - root.val, currentPath, allPaths);
        }

        // remove the current node from the path to backtrack,
        // we need to remove the current node while we are going up the recursive call stack.
        // why am I now getting this?

        // Hey this is unwinding the tree from leaf to root! If you do not do then all the nodes
        // which were traversed earlier gets added up. So, you get traces of earlier traversal.
        // So, think like adding token of previous traversal. By the way, this dos not have any
        // impact in actual result as we do add them as we hit the bulls eye.
        currentPath.remove(currentPath.size() - 1);
    }
}
