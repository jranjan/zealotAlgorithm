package org.zealot.ds.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LinkedListUtils {
    public static List<Integer> toArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while(curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        return list;
    }

    public static void display(ListNode head) {
        System.out.println(LinkedListUtils.toArray(head));
    }
}
