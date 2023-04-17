package com.algorithms.chris.neetcode.linked_list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Соединить несколько сортированных связных списков в один сортированный.
 * Решение - сортировка слиянием. Сначала слить каждые два соседних списка, получившийся список списков прогнать еще раз через слияние.
 * <p>
 * Merge k sorted linked lists into one sorted linked list.
 * Solution - merge sort. First, merge every two lists into one, final list of lists send through merging again.
 */
public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        var mergedLists = new ListNode[lists.length % 2 == 0 ? lists.length / 2 : lists.length + 1];
        for (int i = 0; i < lists.length; i += 2) {
            var left = lists[i];
            var right = i + 1 < lists.length ? lists[i + 1] : null;
            var mergedTwo = mergeTwo(left, right);
            mergedLists[i / 2] = mergedTwo;
        }
        return mergeKLists(mergedLists);
    }

    private static ListNode mergeTwo(ListNode left, ListNode right) {
        if (right == null) {
            return left;
        }
        var first = new ListNode();
        var current = first;
        while (left != null || right != null) {
            ListNode next;
            if (left == null || (right != null && left.val > right.val)) {
                next = right;
                right = right.next;
            } else {
                next = left;
                left = left.next;
            }
            current.next = next;
            current = current.next;
        }
        return first.next;
    }

    public static ListNode mergeKListsSlow(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        var pq = new PriorityQueue<ListNode>(Comparator.comparingInt(it -> it.val));
        for (ListNode listNode : lists) {
            var cur = listNode;
            if (cur == null) {
                continue;
            }
            while (cur != null) {
                pq.add(cur);
                cur = cur.next;
            }
        }
        if (pq.isEmpty()) {
            return null;
        }
        var cur = pq.remove();
        var first = cur;
        while (cur != null) {
            cur.next = pq.poll();
            cur = cur.next;
        }
        return first;
    }
}
