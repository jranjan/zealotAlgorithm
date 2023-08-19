package org.zealot.algorithm.pattern.binarytree.search.dft;

import org.zealot.algorithm.ds.tree.TreeNode;

public class TraverseBinaryTree {
    public static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.val);
            inorder(root.right);
        }
    }

    public static void preorder(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            inorder(root.left);
            inorder(root.right);
        }
    }

    public static void postorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            inorder(root.right);
            System.out.println(root.val);
        }
    }
}
