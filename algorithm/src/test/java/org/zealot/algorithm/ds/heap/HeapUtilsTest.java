package org.zealot.algorithm.ds.heap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.zealot.algorithm.ds.heap.HeapUtils;
import org.zealot.algorithm.ds.tree.TreeNode;

import java.util.Arrays;

public class HeapUtilsTest {
    private static TreeNode maxHeap;
    private static TreeNode maxHeapList;

    @BeforeAll
    static void setup() {
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
    void validateHeapProperty(){
        System.out.println("Max heap tree's heap properties:" + HeapUtils.isTreeHeap(maxHeap));
        System.out.println("Max heapList tree's heap properties:" + HeapUtils.isTreeHeap(maxHeapList));
    }

    @Test
    void validateHeapPropertyArray(){
        System.out.println("Max heap tree's heap properties:" + HeapUtils.isTreeHeapArrayWise(maxHeap));
        System.out.println("Max heapList tree's heap properties:" + HeapUtils.isTreeHeapArrayWise(maxHeapList));
    }

    @Test
    void checkArrayForHeapProperties(){
        int[] nums1 = new int[]{90, 15, 10, 7, 12, 2};
        System.out.println(Arrays.toString(nums1) + " : heap = " + HeapUtils.isArraySatisfyHeap(nums1));
        int[] nums2 = new int[]{9, 15, 10, 7, 12, 11};
        System.out.println(Arrays.toString(nums2) + " : heap = " + HeapUtils.isArraySatisfyHeap(nums2));
    }

    @Test
    void makeHeap(){
        int nums1[] = {10, 20, 15, 17, 9, 21};
        System.out.println("Array before creating heap = " + Arrays.toString(nums1));
        HeapUtils.createHeap(nums1);
        System.out.println("Array before creating heap = " + Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums1) + " : Check array after creating heap = " + HeapUtils.isArraySatisfyHeap(nums1));
    }

    @Test
    void heapify(){
        int nums1[] = {10, 20, 15, 17, 9, 21};
        System.out.println("Array before heapify = " + Arrays.toString(nums1));
        HeapUtils.heapify(nums1);
        System.out.println("Array after heapify = " + Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums1) + " : Check array after heapify = " + HeapUtils.isArraySatisfyHeap(nums1));
    }

    @Test
    void insert(){
        int nums1[] = {10, 20, 15, 17, 9, 21};
        HeapUtils.heapify(nums1);
        System.out.println("Heap before insertion = " + Arrays.toString(nums1));
        int nums2[] = HeapUtils.insert(nums1, 60);
        System.out.println("Heap after insertion = " + Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums2) + " : Check array after insertion = " + HeapUtils.isArraySatisfyHeap(nums2));
        int nums3[] = HeapUtils.insert(nums2, 19);
        System.out.println("Heap after insertion = " + Arrays.toString(nums3));
        System.out.println(Arrays.toString(nums3) + " : Check array after insertion = " + HeapUtils.isArraySatisfyHeap(nums3));
    }

    @Test
    void delete(){
        int nums1[] = {10, 20, 15, 17, 9, 21};
        HeapUtils.heapify(nums1);
        System.out.println("Heap before deletion = " + Arrays.toString(nums1));
        int nums2[] = HeapUtils.delete(nums1);
        System.out.println("Heap after deletion = " + Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums2) + " : Check array after deletion = " + HeapUtils.isArraySatisfyHeap(nums2));
        int nums3[] = HeapUtils.delete(nums2);
        System.out.println("Heap after deletion = " + Arrays.toString(nums3));
        System.out.println(Arrays.toString(nums3) + " : Check array after deletion = " + HeapUtils.isArraySatisfyHeap(nums3));
    }
    @Test
    void sort(){
        int nums1[] = {10, 20, 15, 17, 9, 21};
        System.out.println(Arrays.toString(nums1));
        HeapUtils.createHeap(nums1);
        System.out.println("Heap = " + Arrays.toString(nums1));
        HeapUtils.sortHeap(nums1);
        System.out.println("Sorted Heap = " + Arrays.toString(nums1));
    }
}
