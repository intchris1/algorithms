package com.algorithms.chris.neetcode.linked_list;

/**
 * Дано два связных списка, в каждом узле - цифра, все цифры в обратном порядке составляют число.
 * Нужно сложить два этих числа, вернуть связный список, в каждом узле которого цифра итоговой суммы. Цифры должны быть в обратном порядке.
 * Решение:
 * 1) Сложить текущие числа из левого и правого списка и предыдущий остаток.
 * 2) Если получившаяся цифра больше десяти, сложить единицу в остаток.
 * 3) В результирующий список положить остаток от деления числа из пункта 1) на 10.
 * <p>
 * Given two linked lists, each node is a digit, all digits are in reverse order.
 * You should sum two numbers and return a linked list, each node is a digit of the resulting sum. The digits should be in reverse order.
 * Solution:
 * 1) Sum two current numbers from linked lists and previous remainder.
 * 2) If the current number is greater than ten, put one in a remainder.
 * 3) Put remainder from division of the number from 1) by 10 in the resulting list.
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var current = new ListNode();
        var result = current;
        var left = l1;
        var right = l2;
        var remainder = 0;
        while (left != null || right != null) {
            var leftNum = left == null ? 0 : left.val;
            var rightNum = right == null ? 0 : right.val;
            var resultDigit = leftNum + rightNum + remainder;
            remainder = resultDigit / 10;
            var valueInList = resultDigit % 10;
            current.next = new ListNode(valueInList);
            current = current.next;
            left = left == null ? null : left.next;
            right = right == null ? null : right.next;
        }
        if (remainder > 0) {
            current.next = new ListNode(remainder);
        }
        return result.next;
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
