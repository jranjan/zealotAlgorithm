package org.zealot.scratchpad.one;

import org.zealot.ds.tree.TreeNode;

import java.util.*;


/******************************************************************************************************
 * Analysis Syntax =  Readiness | Popularity | Code Knowledge | Analysis Knowledge | Strategy
 * Analysis = RUN | HIGH | EXCELLENT | UGLY | REFRESH
 *****************************************************************************************************/
public class BinaryTreeBreadthFirstReverseTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        if (root == null) return null;

        LinkedList<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {
            int currQueueSize = q.size();;

            List<Integer> l = new ArrayList<>();

            // fetch all and put in linked list as it is the number of nodes in first level
            for (int i = 0; i < currQueueSize; i++) {
                TreeNode n = q.remove();
                l.add(n.val);
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }

            result.add(0, l);
        }

        return result;
    }
}
