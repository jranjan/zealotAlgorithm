package org.zealot.algorithm.pattern.reverse;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.pattern.linkedlist.reverse.ReverseLinkedList;
import org.zealot.algorithm.ds.linkedlist.ListNode;
import org.zealot.algorithm.ds.linkedlist.LinkedListUtils;

public class ReverseLinkedListTest {
    @Test
    void reverse(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = null;
        LinkedListUtils.display(head);
        ListNode newHead = ReverseLinkedList.reverse(head);
        LinkedListUtils.display(newHead);
    }
}
