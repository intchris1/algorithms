package com.algorithms.chris.neetcode.binary_search;

import java.util.Arrays;

/**
 * Дан массив чисел, сортированный по возрастанию. Нужно найти заданное число и вернуть его индекс, если такого числа нет - вернуть -1.
 * <p>
 * An array of integers is given, which is sorted in ascending order. Find target number and return its index, if there is no such number - return -1.
 */
public class BinarySearch {

    public static int search(int[] nums, int target) {
        var result = Arrays.binarySearch(nums, target);
        if (result < 0) {
            return -1;
        }
        return result;
    }
}

