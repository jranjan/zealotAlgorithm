package org.zealot.algorithm.scratchpad.one;

import org.zealot.algorithm.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/******************************************************************************************************
 * Analysis Syntax =  Readiness | Popularity | Code Knowledge | Analysis Knowledge | Strategy
 * Analysis = RUN | HIGH | EXCELLENT | UGLY | REFRESH
 *****************************************************************************************************/
public class BinaryTreeBreadthFirstTraversal {
    public static List<Integer> traverse(TreeNode root) {
        if (root == null) return null;

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {
            int currQueueSize = q.size();;

            // fetch all and put in linked list as it is the number of nodes in first level
            for (int i = 0; i < currQueueSize; i++) {
                TreeNode n = q.remove();
                result.add(n.val);
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
        }

        return result;
    }
}
