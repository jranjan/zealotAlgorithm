package org.zealot.algorithm.pattern.haretortoise;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.pattern.linkedlist.haretortoise.FindCycleLength;
import org.zealot.algorithm.ds.linkedlist.ListNode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindCycleLengthTest {
   @Test
   void hasCycle(){
       ListNode head = new ListNode(1);
       head.next = new ListNode(2);
       head.next.next = new ListNode(3);
       head.next.next.next = new ListNode(4);
       head.next.next.next.next = new ListNode(5);
       head.next.next.next.next.next = new ListNode(6);
       head.next.next.next.next.next.next = head.next.next.next;
       System.out.println("Cycle length=" + FindCycleLength.findCycleLength(head));
   }
}