package org.zealot.algorithm.dft;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.zealot.ds.tree.TreeNode;

public class TraverseBinaryTreeTest {
    private static TreeNode binaryTreeRoot;

    @BeforeAll
    static void setup() {
        binaryTreeRoot = new TreeNode(12);
        binaryTreeRoot.left = new TreeNode(7);
        binaryTreeRoot.right = new TreeNode(1);
        binaryTreeRoot.left.left = new TreeNode(9);
        binaryTreeRoot.right.left = new TreeNode(10);
        binaryTreeRoot.right.right = new TreeNode(5);
    }
    @Test
    void inorder() {
        System.out.println("Inorder traversal:");
        TraverseBinaryTree.inorder(binaryTreeRoot);
        System.out.println("---------------------------------");
    }

    @Test
    void preorder() {
        System.out.println("Preorder traversal:");
        TraverseBinaryTree.preorder(binaryTreeRoot);
        System.out.println("---------------------------------");
    }

    @Test
    void postorder() {
        System.out.println("Postorder traversal:");
        TraverseBinaryTree.postorder(binaryTreeRoot);
        System.out.println("---------------------------------");
    }
}
