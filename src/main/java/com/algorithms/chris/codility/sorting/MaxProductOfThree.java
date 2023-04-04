package com.algorithms.chris.codility.sorting;

/**
 * Найти максимально возможное число, полученное из перемножения трех любых чисел
 * Максимальное число от умножения можно получить, если:
 * 1) Перемножить три самых больших числа
 * 2) Перемножить два самых маленьких числа и одно самое большое
 */
public class MaxProductOfThree {

    public static int solution(int[] A) {
        var max1 = Integer.MIN_VALUE;
        var max2 = Integer.MIN_VALUE;
        var max3 = Integer.MIN_VALUE;
        var min1 = Integer.MAX_VALUE;
        var min2 = Integer.MAX_VALUE;
        for (int i : A) {
            if (i > max1) {
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if (i > max2) {
                max3 = max2;
                max2 = i;
            } else if (i > max3) {
                max3 = i;
            }
            if (i < min1) {
                min2 = min1;
                min1 = i;
            } else if (i < min2) {
                min2 = i;
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}
