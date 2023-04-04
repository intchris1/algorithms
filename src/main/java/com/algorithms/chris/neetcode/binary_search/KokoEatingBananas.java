package com.algorithms.chris.neetcode.binary_search;

import static java.lang.Math.min;

/**
 * Найти минимальный k (скорость поедания бананов в час), за которое Коко съест все бананы в течение h часов.
 * Решение:
 * Бинарный поиск среди значений от 1 до максимального значения в массиве.
 * <p>
 * Return the minimum integer k (eating speed per hour) such that Koko can eat all the bananas in piles within h hours.
 * Solution:
 * Binary search among values between 1 and the maximum value in array.
 */
public class KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {
        int right = 0;
        for (int pile : piles) {
            if (pile > right) {
                right = pile;
            }
        }
        int left = 1;
        int res = right;
        while (left <= right) {
            int hoursLeft = h;
            int k = (left + right) / 2;
            for (int pile : piles) {
                int hoursForPile = (int) Math.ceil((double) pile / k);
                hoursLeft -= hoursForPile;
                if (hoursLeft < 0) {
                    left = k + 1;
                    break;
                }
            }
            if (hoursLeft >= 0) {
                res = min(res, k);
                right = k - 1;
            }
        }
        return res;
    }
}

