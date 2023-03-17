package com.algorithms.chris.neetcode.two_pointers;


import static java.lang.Math.max;

/**
 * Дан массив из n позитивных чисел, каждое из которых обозначают высоту.
 * Нужно посчитать, сколько воды сможет остаться между элементов после дождя.
 * Алгоритм - два указателя.
 * Двигать левый указатель, если максимальная высота слева меньше или равна максимальной высоте справа от правого указателя
 * Иначе двигать правый указатель
 * Для только что сдвинутого указателя посчитать количество воды по формуле -
 * (текущая максимальная высота слева или справа от соответствующего указателя - текущая высота)
 * <p>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 * Solution - two pointers algorithm.
 * Shift left pointer, if maximum height on the left is less that or equal to the maximum height on the right from the right pointer
 * Otherwise move left shift
 * For each last shifted pointer calculate the amount of water -
 * (Current maximum height on the left or on the right from corresponding pointer - current height)
 */
public class TrappingRainWater {

    public static int trap(int[] height) {
        int trapped = 0;
        int l = 0;
        int r = height.length - 1;
        int maxLeft = height[l];
        int maxRight = height[r];
        while (l < r) {
            if (maxLeft < maxRight) {
                l++;
                maxLeft = max(maxLeft, height[l]);
                trapped += maxLeft - height[l];
            } else {
                r--;
                maxRight = max(maxRight, height[r]);
                trapped += maxRight - height[r];
            }
        }
        return trapped;
    }
}
