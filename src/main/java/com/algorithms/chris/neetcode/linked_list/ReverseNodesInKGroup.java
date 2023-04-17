package com.algorithms.chris.neetcode.linked_list;

/**
 * Нужно каждые k узлов связного списка перевернуть в обратном порядке.
 * Решение - медленный и быстрый указатель, медленный отстает от быстрого на k + 1.
 * Каждый раз, когда набирается k узлов, переворачивать получившуюся группу.
 * <p>
 * Reverse every k nodes in a list.
 * Solution - slow and fast pointer, the slow pointer is behind the fast one by k + 1.
 * Each time k nodes are passed, reverse current group starting from the slow index.
 */
public class ReverseNodesInKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode slow = new ListNode(0, head);
        var result = slow;
        ListNode fast = head;
        var nodesPassed = 0;
        while (fast != null) {
            fast = fast.next;
            nodesPassed++;
            if (nodesPassed == k) {
                nodesPassed = 0;
                var futureGroupTail = slow.next;
                slow.next = reverseList(futureGroupTail, fast);
                futureGroupTail.next = fast;
                slow = futureGroupTail;
            }
        }
        return result.next;
    }

    private static ListNode reverseList(ListNode futureGroupTail, ListNode nodeAfterTail) {
        ListNode previous = null;
        var current = futureGroupTail;
        while (current != nodeAfterTail) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
