package org.zealot.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.ds.linkedlist.ListNode;

public class LinkedListReversalTest {
    @Test
    void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = null;

        System.out.println("Before reversal:");
        LinkedListReversal.printList(head);
        ListNode newHead = LinkedListReversal.reverse(head);
        System.out.println("After reversal:");
        LinkedListReversal.printList(newHead);
    }
}
