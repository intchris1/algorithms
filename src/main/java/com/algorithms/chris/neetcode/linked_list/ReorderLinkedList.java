package com.algorithms.chris.neetcode.linked_list;

/**
 * Переставить элементы связного списка таким образом: [0, n, 1, n-1...]
 * Решение:
 * 1) Сохранить элемент из середины в переменную за один проход, для этого вводится два указателя - быстрый и медленный,
 * быстрый передвигается в два раза быстрее медленного.
 * 2) Начиная от следующего элемента после середины, развернуть связный список.
 * 3) Слить два списка.
 * <p>
 * Reorder linked list nodes like this: [0, n, 1, n-1...]
 * Solution:
 * 1) Save the middle element in a variable for one iteration, for this purpose there are two pointers - fast and slow,
 * fast pointer is moving two times faster than the slow one.
 * 2) Starting from the next element after the middle one, reverse linked list.
 * 3) Merge two lists.
 */
public class ReorderLinkedList {

    public static void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }
        var slow = head;
        var fast = head;
        boolean moveSlowPointer = true;
        while (fast.next != null) {
            moveSlowPointer = !moveSlowPointer;
            fast = fast.next;
            if (moveSlowPointer) {
                slow = slow.next;
            }
        }
        var headOfRight = reverseList(slow.next);
        var current = head;
        while (headOfRight != null) {
            var previousNext = current.next;
            current.next = headOfRight;
            headOfRight = headOfRight.next;
            current.next.next = previousNext;
            current = previousNext;
        }
        current.next = null;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode previous = null;
        while (head != null) {
            var previousNext = head.next;
            head.next = previous;
            previous = head;
            head = previousNext;
        }
        return previous;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
