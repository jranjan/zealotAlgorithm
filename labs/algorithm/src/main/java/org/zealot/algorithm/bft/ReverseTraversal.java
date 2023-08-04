package org.zealot.algorithm.bft;

import org.zealot.ds.tree.TreeNode;

import java.util.*;

public class ReverseTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> allLevels = new Stack<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.isEmpty() == false) {
            // fetch the size
            int size = queue.size();
            // fetch as many as equal to size of queue
            List<Integer> currList = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode n = queue.remove();
                currList.add(n.val);
                if (n.left != null) {
                    queue.add(n.left);
                }
                if (n.right != null) {
                    queue.add(n.right);
                }
            }
            allLevels.add(currList);
        }

        List<List<Integer>> reverseAllLevels = new Stack<List<Integer>>();
        for(int i=allLevels.size()-1; i>=0; i--) {
            reverseAllLevels.add(allLevels.get(i));
        }
        return reverseAllLevels;
    }

    public static List<List<Integer>> traverseSmart(TreeNode root) {
        List<List<Integer>> allLevels = new Stack<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.isEmpty() == false) {
            // fetch the size
            int size = queue.size();
            // fetch as many as equal to size of queue
            List<Integer> currList = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode n = queue.remove();
                currList.add(n.val);
                if (n.left != null) {
                    queue.add(n.left);
                }
                if (n.right != null) {
                    queue.add(n.right);
                }
            }
            allLevels.add(0, currList);
        }

        return allLevels;
    }
}
