package org.zealot.scratchpad.one;


import org.zealot.ds.linkedlist.ListNode;

/******************************************************************************************************
 * Analysis Syntax =  Readiness | Popularity | Code Knowledge | Analysis Knowledge | Strategy
 * Analysis = RUN | HIGH | EXCELLENT | EXCELLENT | REFRESH
 *****************************************************************************************************/
public class LinkedListFindCycle {
    public static boolean verify(ListNode head) {
        if (head.next == head) {
            // Single node cycle
            return true;
        }

        // At least we have two nodes now!
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while((fastPointer != null) && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }

    public static int cycleLength(ListNode head) {
        if (head.next == head) {
            // Single node cycle
            return 1;
        }

        ListNode slow = head, fast = head;
        while((fast != null) && (fast.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (slow != fast) return 0;

        // If we are here then it means that our both pointers are pointing to same node
        // and will keep rotating in same cycle.
        int count = 1;
        fast = fast.next;
        while(slow != fast) {
            fast = fast.next;
            count++;
        }

        return count;
    }

    public static ListNode getFirstCycleNode(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            if (isNodePartOfCycle(curr) == true) {
               break;
            }
            curr = curr.next;
        }

        return curr;
    }

    public static boolean isNodePartOfCycle(ListNode head) {
        if (head == null) return false;

        if (head.next == head) {
            // Single node cycle
            return (head == head) ? true : false;
        }

        ListNode slow = head, fast = head;
        while ((fast != null) && (fast.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // found the cycle
                break;
            }
        }

        fast = fast.next;
        while (slow != fast) {
            fast = fast.next;
            if (fast == head) return true;
        }

        return false;
    }
}
