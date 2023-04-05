package com.algorithms.chris.neetcode.binary_search;

/**
 * Найти медиану от двух сортированных массивов.
 * Решение: бинарный поиск.
 * 1) Определить, какой из массивов более короткий. Короткий - a, длинный - b
 * 2) Завести два указателя - левый = 0, правой - длина a.
 * 3) Пока левый указатель <= правого:
 * 3.1) Найти среднее значение в массиве a между левым и правым.
 * 3.2) Найти значение в массиве b под оставшуюся длину - половина от общей длинны массивов / 2 - индекс из 3.1
 * 3.3) Если макс из левой части a больше мин из правой части b, нужно укоротить левую часть a.
 * 3.4) Если макс из левой части b больше мин из правой части a, нужно удлинить левую часть a.
 * 3.5) Иначе медианные числа найдены:
 * 3.5.1) Если общая длина двух массивов четная, то медиана -
 * максимальное значение (макс левой части массива a, макс значение левой части b) + минимальное значение (мин правой части a, мин правой части b) / 2
 * 3.5.2) Иначе минимальное значение (мин правой части a, мин правой части b)
 * <p>
 * Find median of two sorted arrays.
 * Solution: binary search.
 * 1) a - shortest array, b - longest array.
 * 2) Left pointer - 0, right pointer - a's length.
 * 3) While left pointer <= right:
 * 3.1) Find mid between left and right in a.
 * 3.2) Find mid in b - total length of two arrays / 2 - mid of a.
 * 3.3) If max of a's left part is greater than min of b's right part, shorten a's left part.
 * 3.4) if max of b's left part is greater than min of a's right part, make a's left part longer.
 * 3.5) Else median numbers found:
 * 3.5.1) If total arrays length is even, median is:
 * Max(max of a's left part, max of b's left part) + min (min of a's right part, min of b's right part) / 2
 * 3.5.2) Else min (min of a's right part, min of b's right part)
 */
public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int shortArrayLength = nums1.length;
        int longArrayLength = nums2.length;
        int left = 0;
        int right = shortArrayLength;
        while (left <= right) {
            int mid1 = (left + right) / 2;
            int mid2 = (shortArrayLength + longArrayLength) / 2 - mid1;
            int left1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int left2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int right1 = mid1 == shortArrayLength ? Integer.MAX_VALUE : nums1[mid1];
            int right2 = mid2 == longArrayLength ? Integer.MAX_VALUE : nums2[mid2];
            if (left1 > right2) {
                right = mid1 - 1;
            } else if (left2 > right1) {
                left = mid1 + 1;
            } else {
                return ((shortArrayLength + longArrayLength) % 2 == 0) ? (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0 : Math.min(right1, right2);
            }
        }
        return 0.0;
    }
}
