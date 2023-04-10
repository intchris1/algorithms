package com.algorithms.chris.neetcode.linked_list;

/**
 * Нужно найти дубликат в массиве с уникальными числами, каждое число 1 <= nums[i] <= n.
 * Трата памяти должна быть O(1), время O(n).
 * Решение - алгоритм Флойда. Считать массив связным списком, где каждое число - указатель на следущий узел.
 * 1) Два указателя, быстрый и медленный, быстрый двигается в два раза быстрее.
 * 2) Как только найдено совпадение, сохраняем медленный указатель, теперь он - быстрый.
 * 3) Запускаем еще один быстрый указатель сначала, как только найдется совпадение - вернуть это число.
 * <p>
 * Find duplicate in an array with unique numbers, each number 1<= nums[i] <= n.
 * Space complexity O(1), time complexity O(n).
 * Solution - Floyd algorithm. Consider the array as a linked list, where each number is index of the next node.
 * 1) Two pointers, fast and slow, fast is two times faster than the slow one.
 * 2) When found a match, save the slow pointer, now this pointer is fast again.
 * 3) Have another fast pointer from the beginning of an array, as soon as the match is found - return this number.
 */
public class FindTheDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);
        int slow2 = 0;
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow2 == slow) {
                return slow;
            }
        }
    }
}
