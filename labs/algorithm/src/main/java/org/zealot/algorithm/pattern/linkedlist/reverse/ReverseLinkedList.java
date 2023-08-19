package org.zealot.algorithm.pattern.linkedlist.reverse;

import org.zealot.algorithm.ds.linkedlist.ListNode;

public class ReverseLinkedList {
    public static ListNode reverse(ListNode head) {
        if ((head == null) || (head.next == null)){
            return head;
        }

        // Peel out the first node
        ListNode newHead = head;
        head = head.next;
        newHead.next = null;

        // Start pulling one by one and adding to smaller list
        while(head != null) {
            // peel the current node
            ListNode curr = head;
            head = head.next;

            // Put current in front
            curr.next = newHead;
            newHead = curr;
        }

        return newHead;
    }
}
