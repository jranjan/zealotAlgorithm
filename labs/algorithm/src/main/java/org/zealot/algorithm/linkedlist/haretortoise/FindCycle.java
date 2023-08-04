package org.zealot.algorithm.linkedlist.haretortoise;

import org.zealot.ds.linkedlist.ListNode;

public class FindCycle {
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while((fast != null) && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
