package org.zealot.ds.heap;

import org.zealot.ds.tree.BinaryTreeUtils;
import org.zealot.ds.tree.TreeNode;

import java.util.Arrays;
import java.util.List;

public class HeapUtils {

    public static int EMPTY_MARKER = -1;

    public static boolean isTreeHeap(TreeNode root) {
        if (root == null) return true;
        if ((root.left == null) && (root.right == null)) return true;
        if (root.left != null) {
            if (root.val < root.left.val) return false;
            if (root.right != null) {
                if (root.val < root.right.val) return false;
            }
            return  isTreeHeap(root.left) && isTreeHeap(root.right);
        } else {
            if (root.right != null) {
                return false;
            }
        }
        return false;
    }

    public static boolean isTreeHeapArrayWise(TreeNode root) {
        List<Integer> list = BinaryTreeUtils.traverseBreadthCompletely(root);
        int i = 0;
        boolean bContinue = true;
        while(((2*i+2) < list.size())) {
            // Fetch nodes
            int curr = list.get(i);
            int leftChild = list.get(2*i+1);
            int rightChild = list.get(2*i+2);

            if (curr != EMPTY_MARKER) {
                // Check left child properties
                if (leftChild != EMPTY_MARKER) {
                    if (leftChild < curr) {
                        // Right child can be empty
                        if (rightChild != EMPTY_MARKER) {
                            if (rightChild > curr) return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    if (rightChild != EMPTY_MARKER) return false;
                }
            }

            i++;
        }

        return true;
    }

    public static boolean isArraySatisfyHeap(int[] arr){
        int curr, leftChild, rightChild;
        for(int i=0; (2*i+2)<arr.length; i++){
            curr = arr[i];
            leftChild = arr[2*i+1];
            rightChild = arr[2*i+2];
            if ((curr < leftChild) || (curr < rightChild)) {
                return false;
            }
        }
        return true;
    }

    public static void createHeap(int[] arr){
       for(int i=0; i<arr.length; i++){
           int childPos = i;
           int parentPos = (i - 1)/ 2;
           while(arr[parentPos] < arr[childPos]) {
               swap(arr, parentPos, childPos);
               childPos = parentPos;
               parentPos = (childPos -1)/2;
           }
       }
    }

    public static void heapify(int[] arr) {
        if (arr.length <= 1) return;
        for(int i=arr.length-1; i > 0; i--) {
            shiftUp(arr, 0, arr.length, i);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i]=a[j];
        a[j] = temp;
    }

    public static void sortHeap(int[] arr) {
        int start = 0, end = arr.length-1;
        for(int i=0; i<arr.length; i++) {
            start = 0;

            // fetch the maximum element, swap with last nod
            swap(arr, start, end);
            // shift parent down to best of extent
            start = shiftDown(arr, start, end-1, start);
            while(start != -1) {
                // we swapped, so we need to pay attention
                start = shiftDown(arr, start, end-1, start);
            }

            end = end - 1;
        }
    }

    public static int[] delete(int[] arr) {
        int start = 0, end = arr.length-1;
        // fetch the maximum element, swap with last nod
        swap(arr, start, end);
        // shift parent down to best of extent
        start = shiftDown(arr, start, end-1, start);
        while(start != -1) {
            // we swapped, so we need to pay attention
            start = shiftDown(arr, start, end-1, start);
        }

        int[] newArr = Arrays.copyOf(arr, arr.length-1);
        return newArr;
    }

    public static int[] insert(int[] arr, int val) {
        int[] newArr = Arrays.copyOf(arr, arr.length+1);
        newArr[newArr.length-1] = val;

        int pos = newArr.length-1;
        while(pos > 0) {
            shiftUp(newArr, 0, newArr.length-1, pos);
            pos = (pos - 1)/ 2;
        }
        return newArr;
    }

    private static int shiftUp(int[] arr, int start, int end, int childPos) {
        int parentPos = (childPos - 1)/2;
        if ((parentPos >= start) && (childPos <= end)){
            if (arr[parentPos] < arr [childPos]) swap(arr, parentPos, childPos);
            return parentPos;
        }
        return -1;
    }

    private static int shiftDown(int[] arr, int start, int end, int parentPos) {
        if (start > end) {
            return -1;
        }
        int leftChildPos = 2*parentPos+1;
        int rightChildPos = 2*parentPos+2;
        if ((leftChildPos <= end) && (rightChildPos <= end)) {
            int maxPos = (arr[leftChildPos] > arr[rightChildPos]) ? leftChildPos : rightChildPos;
            if (arr[parentPos] < arr [leftChildPos]) {
                swap(arr, maxPos, parentPos);
                return maxPos;
            }
        } else {
            if (leftChildPos <= end){
                if (arr[parentPos] < arr [leftChildPos]) {
                    swap(arr, parentPos, leftChildPos);
                    return leftChildPos;
                }
            } else if (rightChildPos <= end) {
                if (arr[parentPos] < arr [rightChildPos]) {
                    swap(arr, parentPos, rightChildPos);
                    return rightChildPos;
                }
            }
        }

        return -1;
    }
}
