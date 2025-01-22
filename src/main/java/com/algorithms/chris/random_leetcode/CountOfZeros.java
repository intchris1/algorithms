package com.algorithms.chris.random_leetcode;

/**
 * Нужно передвинуть все нули в конец, не копируя массив, и сохранить оригинальный порядок не нулевых элементов.
 * <p>
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 */
public class CountOfZeros {

    public static void moveZeroes(int[] nums) {
        int countOfZeros = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current == 0) {
                countOfZeros++;
            } else {
                int newIndex = i - countOfZeros;
                if (newIndex != i) {
                    nums[newIndex] = current;
                    nums[i] = 0;
                }
            }
        }
    }
}
