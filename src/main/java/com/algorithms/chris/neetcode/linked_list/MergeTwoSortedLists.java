package com.algorithms.chris.neetcode.linked_list;

/**
 * Даны первые элементы двух связных сортированных списков, нужно слить их в один сортированный список.
 * Решение:
 * 1) Пока голова первого или голова второго списка != null:
 * 2) Если голова первого списка == null или голова второго списка != null и меньше первой головы, следующий элемент итогового списка - вторая голова.
 * 3) Иначе - первая.
 * 4) Прицепить полученный следующий элемент к текущему элементу итогового списка.
 * 5) Теперь текущий элемент итогового списка - полученный следующий элемент.
 * <p>
 * You are given the heads of two sorted linked lists, merge the two lists in a one sorted list.
 * Solution:
 * 1) While list1 head or list2 head != null:
 * 2) If list1 head == null or list2 head != null and less that list1 head, the next element of the result list is list2 head.
 * 3) Otherwise list1 head.
 * 4) Attach next acquired element to current element of the result list.
 * 5) Now the current result list element is the next acquired element.
 */
public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = null;
        ListNode currentResultListNode = null;
        while (list1 != null || list2 != null) {
            ListNode next;
            if (list1 == null || (list2 != null && list1.val > list2.val)) {
                next = list2;
                list2 = list2.next;
            } else {
                next = list1;
                list1 = list1.next;
            }
            if (currentResultListNode != null) {
                currentResultListNode.next = next;
            }
            currentResultListNode = next;
            if (result == null) {
                result = currentResultListNode;
            }
        }
        return result;
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