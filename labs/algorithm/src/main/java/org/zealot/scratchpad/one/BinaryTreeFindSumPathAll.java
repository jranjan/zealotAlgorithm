package org.zealot.scratchpad.one;

import org.zealot.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/******************************************************************************************************
 * Analysis Syntax =  Readiness | Popularity | Code Knowledge | Analysis Knowledge | Strategy
 * Analysis = RUN | HIGH | OK | UGLY | REVISIT
 *****************************************************************************************************/
public class BinaryTreeFindSumPathAll {
    public static List<List<Integer>> findSumPathAll(TreeNode root, int sum) {
        // If root is null then nothing do. So, go back!
        if (root == null) return null;

        // Create list of list to store all possible paths meeting the criteria which we
        // will eventually return to caller
        List<List<Integer>> l = new ArrayList<>();

        // Create a list which we will use an utility as we traverse through all nodes
        List<Integer> nl = new ArrayList<>();

        // Invoke the helper
        findPath(root, sum, l, nl);

        // Return the result
        return l;
    }

    public static void findPath(TreeNode root, int sum, List<List<Integer>> l, List<Integer> nl) {
        // Take care of case where leaf node invoke its children
        if (root == null) return;

        // Keep adding the node to current list
        nl.add(root.val);

        // If we are here then we have hit the leaf node, either we meet the arget or miss the target
        if ((root.left == null) && (root.right == null)) {
            if (sum == root.val) {
                // We meet the target, create a copy of list and add it to bigger bucket
                // We should clone current as we will be unwinding as we move stack. So, adding it
                // as it is will lose information. Hope, you remember pass by reference.
                l.add(new ArrayList<Integer>(nl));
            }
        } else {
            // Search in left side
            findPath(root.left, sum - root.val, l, nl);
            // Search in right side
            findPath(root.right, sum - root.val, l, nl);
        }

        // If we are here then it means we hit the leaf, now trying to unwrap!
        // Hey, we do not want to clean the list, we want to remove the latest node as rest
        // of elements still have possibility of seeing a new path. So, never clear it.
        // Its depth first (recursion, little difficult to visualise, isn't it?)
        nl.remove(nl.size() - 1);
    }
}
