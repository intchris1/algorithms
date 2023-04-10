package com.algorithms.chris.neetcode.linked_list;

/**
 * Нужно проверить, если ли в связном списке цикл.
 * Решение:
 * Быстрый и медленный указатель. Если они встретились на одном узле, цикл есть.
 * <p>
 * Check if a linked list has cycle.
 * Slow and fast pointers. If they met at the same node, there is a cycle.
 */
public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        boolean isUpdateSlow = false;
        while (head != null) {
            if (isUpdateSlow) {
                slow = slow.next;
                isUpdateSlow = false;
            } else {
                isUpdateSlow = true;
            }
            head = head.next;
            if (head == slow) {
                return true;
            }
        }
        return false;
    }
}
