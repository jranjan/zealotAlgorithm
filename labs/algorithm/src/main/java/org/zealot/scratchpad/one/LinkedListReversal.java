package org.zealot.scratchpad.one;

import org.zealot.ds.linkedlist.ListNode;


/******************************************************************************************************
 * Analysis Syntax =  Readiness | Popularity | Code Knowledge | Analysis Knowledge | Strategy
 * Analysis = RUN | HIGH | EXCELLENT | EXCELLENT | REFRESH
 *****************************************************************************************************/
public class LinkedListReversal {
    public static ListNode reverse(ListNode head) {
        if ((head == null) || (head.next == null)) return head;

        ListNode newHead = head;
        head = head.next;
        newHead.next = null;
        while (head != null) {
            // fetch one node
            ListNode fetchedNode = head;
            head = head.next;

            // Plant fetched new node at the front
            fetchedNode.next = newHead;
            newHead = fetchedNode;
        }

        return newHead;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
