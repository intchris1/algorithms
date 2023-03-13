package com.algorithms.chris.neetcode.two_pointers;

/**
 * Найти элементы, которые в сумме дают нужное число.
 * Решение - алгоритм two pointers
 * <p>
 * Find indexes of two elements such that add up to a given number.
 * Solution - two pointers algorithm
 */
public class TwoSumSorted {

    public static int[] twoSumSorted(int[] numbers, int target) {
        int leftIndex = 0;
        int rightIndex = numbers.length - 1;
        while (leftIndex < rightIndex) {
            if (numbers[leftIndex] + numbers[rightIndex] == target) {
                return new int[]{leftIndex + 1, rightIndex + 1};
            }
            while (leftIndex < rightIndex && numbers[leftIndex] + numbers[rightIndex] < target) {
                leftIndex++;
            }
            while (leftIndex < rightIndex && numbers[leftIndex] + numbers[rightIndex] > target) {
                rightIndex--;
            }
        }
        return new int[0];
    }
}

