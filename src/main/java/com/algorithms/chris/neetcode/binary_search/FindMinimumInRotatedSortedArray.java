package com.algorithms.chris.neetcode.binary_search;

import static java.lang.Math.min;

/**
 * Дан отсортированный массив, который был подвинут по часовой стрелке. Найти минимальное число.
 * Решение: бинарный поиск.
 * 1) Левый указатель - начало массива, правый - конец массива.
 * 2) Пока левый указатель меньше или равен правому:
 * 2.1) Проверить, является ли число на левом указателе меньше, чем на правом. Если да, сравнить с наименьшим.
 * 2.2) Проверить число посередине между двумя указателями, не является ли оно самым маленьким.
 * 2.3) Если число посередине больше или равно левому, подвинуть левый указатель вправо от середины.
 * 2.4) Иначе подвинуть правый влево от середины.
 * <p>
 * Given a sorted array, which was rotated clockwise, find minimum element.
 * Solution: binary search.
 * 1) Left pointer - 0, right pointer - end of the array.
 * 2) While left pointer is less than or equal to the right pointer:
 * 2.1) Check if left number is less than right. If yes, compare to the minimum.
 * 2.2) Check if mid number is less than the minimum.
 * 2.3) If mid number is greater or equal to left, move left pointer to one right from mid.
 * 2.4) Else move right pointer to one left from mid.
 */
public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int result = nums[0];
        while (left <= right) {
            if (nums[left] < nums[right]) {
                result = min(result, nums[left]);
                break;
            }
            int mid = (left + right) / 2;
            result = min(result, nums[mid]);
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}

