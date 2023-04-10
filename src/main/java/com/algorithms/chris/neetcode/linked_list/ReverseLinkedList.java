package com.algorithms.chris.neetcode.linked_list;

public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
