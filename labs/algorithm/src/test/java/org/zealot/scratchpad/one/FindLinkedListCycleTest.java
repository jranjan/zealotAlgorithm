package org.zealot.algorithm.linkedlist.haretortoise;

import org.junit.jupiter.api.Test;
import org.zealot.ds.linkedlist.ListNode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindCycleTest {
   @Test
   void hasCycle(){
       ListNode head = new ListNode(1);
       head.next = new ListNode(10);
       head.next.next = new ListNode(20);
       head.next.next = head.next;
       assertTrue(FindCycle.hasCycle(head));
   }

    @Test
    void hasNoCycle(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(10);
        head.next.next = new ListNode(20);
        head.next.next.next = new ListNode(30);
        head.next.next.next.next = null;
        assertFalse(FindCycle.hasCycle(head));
    }
}
