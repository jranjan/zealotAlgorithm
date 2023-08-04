package org.zealot.algorithm.dft;

import org.zealot.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindAllPaths {

    public static List<List<Integer>> findPaths(TreeNode root) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<Integer>();
        findPathsRecursive(root, currentPath, allPaths);
        return allPaths;
    }

    private static void findPathsRecursive(TreeNode root, List<Integer> currPath, List<List<Integer>> allPaths){
        if (root == null) {
            return;
        }

        // Add the node, needed if we do not do comparison
        currPath.add(root.val);
        if ((root.left == null) && (root.right == null)) {
            // Hit the leaf
            allPaths.add(new ArrayList<>(currPath));
        } else {
            findPathsRecursive(root.left, currPath, allPaths);
            findPathsRecursive(root.right, currPath, allPaths);
        }

        // chop the node as we are unwinding the tree
        currPath.remove(currPath.size() -1);
    }
}
