package org.zealot.algorithm.pattern.binarytree.search.bft;

import org.zealot.algorithm.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Traverse {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> allLevels = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        traverseUtils(root, queue, allLevels);
        return allLevels;
    }

    public static List<List<Integer>> traverseClean(TreeNode root) {
        List<List<Integer>> allLevels = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.isEmpty() == false) {
            // pop the elements till its empty to make it a new list
            List<Integer> currLevel = new ArrayList<>();
            // Fetch as many as required
            int fetchCount = queue.size();
            for(int i=0; i<fetchCount; i++) {
                TreeNode n = queue.remove();
                currLevel.add(n.val);
                if (n.left != null) {
                    queue.add(n.left);
                }
                if (n.right != null) {
                    queue.add(n.right);
                }
            }
            allLevels.add(currLevel);
        }
        return allLevels;
    }


    private static void traverseUtils(TreeNode root, Queue<TreeNode> queue, List<List<Integer>> allLevels) {
        while (queue.isEmpty() == false) {
            // pop the elements till its empty to make it a new list
            List<Integer> currLevel = new ArrayList<>();
            // Fetch as many as required
            int fetchCount = queue.size();
            for(int i=0; i<fetchCount; i++) {
                TreeNode n = queue.remove();
                currLevel.add(n.val);
                if (n.left != null) {
                    queue.add(n.left);
                }
                if (n.right != null) {
                    queue.add(n.right);
                }
            }
            allLevels.add(currLevel);
        }
    }
}
