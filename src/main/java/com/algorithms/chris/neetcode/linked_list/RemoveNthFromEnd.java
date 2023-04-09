package com.algorithms.chris.neetcode.linked_list;

/**
 * Удалить n-ый по счету элемент с конца в связном списке.
 * Решение:
 * 1) Завести два указателя: быстрый и медленный, медленный отстает от быстрого на n + 1 (чтобы зацепить элемент перед тем элементом, который надо удалить).
 * 2) Если элемент медленного указателя == null, это значит, что либо в списке один элемент (тогда его и удаляем),
 * либо что удаляем первый элемент (тогда возвращаем следующий элемент от головы).
 * 3) Иначе - элемент перед удаляемым теперь должен ссылаться на послеследующий элемент.
 * <p>
 * Remove nth element from the end of the linked list.
 * Solution:
 * 1) Have two pointers: one slow and one fast, a slow one is n + 1 elements behind (to catch an element that is before the one to remove).
 * 2) If a slow pointer is null, it means either we have one element in a list (return head.next, which is null),
 * either we should remove the first element (return head.next, which is the second element).
 * 3) Otherwise a slow pointer now references the element after the next one.
 */
public class RemoveNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode elementBeforeRemoval = null;
        ListNode fast = head;
        int count = 0;
        while (fast != null) {
            fast = fast.next;
            count++;
            if (count == n + 1) {
                elementBeforeRemoval = head;
            } else if (count > n + 1) {
                elementBeforeRemoval = elementBeforeRemoval.next;
            }
        }
        if (elementBeforeRemoval == null || elementBeforeRemoval.next == null) {
            return head.next;
        }
        elementBeforeRemoval.next = elementBeforeRemoval.next.next;
        return head;
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
