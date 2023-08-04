package org.zealot.ds.tree;

import org.zealot.ds.heap.HeapUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.zealot.ds.heap.HeapUtils.EMPTY_MARKER;

public class BinaryTreeUtils {
    public static enum TREE_TYPE {
        NORMAL,
        COMPLETE,
        FULL
    }
    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        if ((root.left == null) & (root.right == null)) return 1;
        if (root.left == null) {
            return 1 + countNodes(root.right);
        } else {
            if (root.right == null) {
                return  1 + countNodes(root.left);
            } else {
                return 1 + countNodes(root.left) + countNodes(root.right);
            }
        }
    }

    public static List<Integer> traverseBreadth(TreeNode root) {
        if (root == null) return null;

        List<Integer> arrayTree = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.isEmpty() == false) {
            int fetchCount = queue.size();

            // Pick all nodes for a level and put inside the list
            // Any empty node is marked as -1.
            for(int i=0; i<fetchCount; i++) {
                TreeNode currNode = queue.remove();
                arrayTree.add(currNode.val);
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }

                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }

        return  arrayTree;
    }

    public static TREE_TYPE treeType(TreeNode root) {
        List<Integer> array = traverseBreadthCompletely(root);

        for(int i=0; i<array.size()-1; i++) {
            if (array.get(i) == EMPTY_MARKER) return TREE_TYPE.NORMAL;
        }

        if (array.get(array.size()-1) == EMPTY_MARKER) {
            return  TREE_TYPE.COMPLETE;
        }

        return TREE_TYPE.FULL;
    }

    public static List<Integer> traverseBreadthCompletely(TreeNode root) {
        if (root == null) return null;

        List<Integer> arrayTree = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.isEmpty() == false) {
            int fetchCount = queue.size();

            // Pick all nodes for a level and put inside the list
            // Any empty node is marked as -1.
            for(int i=0; i<fetchCount; i++) {
                TreeNode currNode = queue.remove();
                if (currNode == null) {
                    arrayTree.add(EMPTY_MARKER);
                    continue;
                } else {
                    arrayTree.add(currNode.val);
                }

                // if it is not a pure leaf node then add else skip
                if ((currNode.left != null) || (currNode.right != null)){
                    queue.add(currNode.left);
                    queue.add(currNode.right);
                }
            }
        }

        return  arrayTree;
    }
}
