package com.algorithms.chris.neetcode.binary_search;

/**
 * Дан отсортированный массив, который был подвинут по часовой стрелке. Найти заданное число.
 * Решение: бинарный поиск.
 * 1) Левый указатель - начало массива, правый - конец массива.
 * 2) Пока левый указатель меньше или равен правому:
 * 2.1) Если мы находимся в левой части отсортированного массива (nums[mid] > nums[left]):
 * 2.1.1) Если число меньше или равно mid и больше или равно left, нужно идти налево
 * 2.1.2) Иначе, нужно идти налево
 * 2.2) Если мы находимся в правой части отсортированного массива (nums[mid] <= nums[left]):
 * 2.2.1) Если число больше или равно mid и меньше или равно right, нужно идти направо
 * 2.2.2) Иначе, нужно идти налево
 * <p>
 * Given a sorted array, which was rotated clockwise, find target element.
 * Solution: binary search.
 * 1) Left pointer - the beginning of the array, right pointer - the end of the array.
 * 2) While left pointer is less than or equal to right pointer:
 * 2.1) If in a left sorted portion (nums[mid] > nums[left]):
 * 2.1.1) If target is less than or equal to mid and greater than or equal to left, go left
 * 2.1.2) Else, go right
 * 2.2) If in a right sorted portion (nums[mid] <= nums[left]):
 * 2.2.1) If target is greater than or equal to mid and less than or equal to right, go right
 * 2.2.2) Else, go left
 */
public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midNumber = nums[mid];
            if (midNumber == target) {
                return mid;
            }
            // left sorted portion
            int leftNumber = nums[left];
            if (midNumber >= leftNumber) {
                if (leftNumber <= target && target <= midNumber) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //right sorted portion
                if (midNumber <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

