package org.zealot.algorithm.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.ds.linkedlist.ListNode;
import org.zealot.algorithm.scratchpad.one.LinkedListFindCycle;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListCycleTest {
   @Test
   void checkCycle(){
       System.out.println("****** test count : 1 *********");
       ListNode head = new ListNode(1);
       head.next = new ListNode(10);
       head.next.next = new ListNode(20);
       head.next.next = head.next;
       System.out.println(String.format("List should have cycle, result = %b",
               LinkedListFindCycle.verify(head)));

       head = new ListNode(1);
       head.next = new ListNode(10);
       head.next.next = new ListNode(20);
       head.next.next.next = new ListNode(30);
       head.next.next.next.next = null;
       System.out.println(String.format("List should NOT have cycle, result = %b",
               LinkedListFindCycle.verify(head)));
   }

    @Test
    void cycleCount(){
        System.out.println("****** test count : 2 *********");
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("Cycle length=" + LinkedListFindCycle.cycleLength(head));

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = null;
        System.out.println("Cycle length=" + LinkedListFindCycle.cycleLength(head));

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = null;
        System.out.println("Cycle length=" + LinkedListFindCycle.cycleLength(head));

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        System.out.println("Cycle length=" + LinkedListFindCycle.cycleLength(head));

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head.next;
        System.out.println("Cycle length=" + LinkedListFindCycle.cycleLength(head));
    }

    @Test
    void getCycleFirstNode(){
        System.out.println("****** test count : 3 *********");
        ListNode head = new ListNode(1);
        head.next = head;
        System.out.println(String.format("List has cycle = %b", LinkedListFindCycle.verify(head)));
        System.out.println(String.format("Cycle length=%d", LinkedListFindCycle.cycleLength(head)));
        System.out.println(String.format("Cycle first node=%d", LinkedListFindCycle.getFirstCycleNode(head).val));

        System.out.println("-----------");

        head.next = new ListNode(2);
        head.next.next = head;
        System.out.println(String.format("List has cycle = %b", LinkedListFindCycle.verify(head)));
        System.out.println(String.format("Cycle length=%d", LinkedListFindCycle.cycleLength(head)));
        System.out.println(String.format("Cycle first node=%d", LinkedListFindCycle.getFirstCycleNode(head).val));

        head.next.next = head.next;
        System.out.println(String.format("List has cycle = %b", LinkedListFindCycle.verify(head)));
        System.out.println(String.format("Cycle length=%d", LinkedListFindCycle.cycleLength(head)));
        System.out.println(String.format("Cycle first node=%d", LinkedListFindCycle.getFirstCycleNode(head).val));

        System.out.println("-----------");

        head.next.next = new ListNode(3);
        head.next.next.next = head;
        System.out.println(String.format("List has cycle = %b", LinkedListFindCycle.verify(head)));
        System.out.println(String.format("Cycle length=%d", LinkedListFindCycle.cycleLength(head)));
        System.out.println(String.format("Cycle first node=%d", LinkedListFindCycle.getFirstCycleNode(head).val));

        head.next.next.next = head.next.next;
        System.out.println(String.format("List has cycle = %b", LinkedListFindCycle.verify(head)));
        System.out.println(String.format("Cycle length=%d", LinkedListFindCycle.cycleLength(head)));
        System.out.println(String.format("Cycle first node=%d", LinkedListFindCycle.getFirstCycleNode(head).val));

        System.out.println("-----------");
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println(String.format("Cycle first node=%d", LinkedListFindCycle.getFirstCycleNode(head).val));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println(String.format("Cycle first node=%d", LinkedListFindCycle.getFirstCycleNode(head).val));

        head.next.next.next.next.next.next = head;
        System.out.println(String.format("Cycle first node=%d", LinkedListFindCycle.getFirstCycleNode(head).val));
    }
}
