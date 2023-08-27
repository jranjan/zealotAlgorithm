package org.zealot.algorithm.pattern.linkedlist.haretortoise;

import org.zealot.algorithm.ds.linkedlist.ListNode;

public class FindCycleLength {
    public static int findCycleLength(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while((fast != null) || (fast.next !=null)){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                // Got the cycle
                int length = 0;
                fast = slow;
                do {
                    length++;
                    fast = fast.next;
                }while(slow != fast);
                return length;
            }
        }

        return 0;
    }
}
