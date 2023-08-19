package org.zealot.algorithm.ds.tree;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.zealot.algorithm.ds.tree.BinaryTreeUtils;
import org.zealot.algorithm.ds.tree.TreeNode;

public class BinaryTreeUtilsTest {
   private static TreeNode simpleTree;
   private static TreeNode completeTree;
   private static TreeNode fullTree;
   private static TreeNode maxHeap;
   private static TreeNode maxHeapList;

   @BeforeAll
   static void setup() {
      simpleTree = new TreeNode(12);
      simpleTree.left = new TreeNode(7);
      simpleTree.right = new TreeNode(1);
      simpleTree.left.left = new TreeNode(9);
      simpleTree.right.left = new TreeNode(10);
      simpleTree.right.right = new TreeNode(5);

      completeTree = new TreeNode(12);
      completeTree.left = new TreeNode(7);
      completeTree.right = new TreeNode(1);
      completeTree.left.left = new TreeNode(9);
      completeTree.left.right = new TreeNode(10);
      completeTree.right.left = new TreeNode(5);

      fullTree = new TreeNode(12);
      fullTree.left = new TreeNode(7);
      fullTree.right = new TreeNode(1);
      fullTree.left.left = new TreeNode(9);
      fullTree.left.right = new TreeNode(10);
      fullTree.right.left = new TreeNode(5);
      fullTree.right.right = new TreeNode(20);

      maxHeap = new TreeNode(20);
      maxHeap.left = new TreeNode(10);
      maxHeap.right = new TreeNode(15);
      maxHeap.left.left = new TreeNode(9);
      maxHeap.left.right = new TreeNode(10);
      maxHeap.right.left = new TreeNode(5);

      maxHeapList = new TreeNode(20);
      maxHeapList.left = new TreeNode(19);
      maxHeapList.left.left = new TreeNode(15);
      maxHeapList.left.left.left = new TreeNode(9);
      maxHeapList.left.left.left.left = new TreeNode(9);
      maxHeapList.left.left.left.left.left = new TreeNode(5);
   }

   @Test
   void countNodes(){
      System.out.println(BinaryTreeUtils.countNodes(simpleTree));
   }
   @Test
   void convertBreathFirstArray(){
      System.out.println("Simple tree:");
      System.out.println(BinaryTreeUtils.traverseBreadth(simpleTree).toString());
      System.out.println("Complete tree:");
      System.out.println(BinaryTreeUtils.traverseBreadth(completeTree).toString());
      System.out.println("Full tree:");
      System.out.println(BinaryTreeUtils.traverseBreadth(fullTree).toString());
   }

   @Test
   void convertBreathFirstArrayIncludeEmpty(){
      System.out.println("Simple tree:");
      System.out.println(BinaryTreeUtils.traverseBreadthCompletely(simpleTree).toString());
      System.out.println("Complete tree:");
      System.out.println(BinaryTreeUtils.traverseBreadthCompletely(completeTree).toString());
      System.out.println("Full tree:");
      System.out.println(BinaryTreeUtils.traverseBreadthCompletely(fullTree).toString());
   }

   @Test
   void binaryTreeType(){
      System.out.println("Simple tree:" + BinaryTreeUtils.treeType(simpleTree));
      System.out.println("Complete tree:" + BinaryTreeUtils.treeType(completeTree));
      System.out.println("Full tree:" + BinaryTreeUtils.treeType(fullTree));
   }
}
