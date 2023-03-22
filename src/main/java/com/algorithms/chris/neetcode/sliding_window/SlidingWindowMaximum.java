package com.algorithms.chris.neetcode.sliding_window;

import java.util.ArrayDeque;
import java.util.Deque;

import static java.lang.Math.max;

/**
 * Найти максимальное число в каждом окне размером k в массиве.
 * Решение:
 * Завести dequeue для индексов.
 * В цикле:
 * 1) Если элементы с головы <= левой границе текущего окна, удалить с головы
 * 2) Если номера с индексами элементов с хвоста < текущего номера, удалить с хвоста
 * 3) Добавить текущий номер в хвост
 * 4) Если это конец какого-то окна, добавить в результат элемент с головы.
 * <p>
 * Find maximum in each window (size == k) in array.
 * Solution:
 * Have a dequeue for indexes.
 * In a loop:
 * 1) While (the head <= left bound of current window), remove the head.
 * 2) While (corresponding nums of the tail < current num), remove the tail
 * 3) Add current num to the tail.
 * 4) If this is the right bound of current window, add the head element to result
 */
public class SlidingWindowMaximum {


    public static int[] slidingWindowMaximum(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }
        int[] result = new int[n - k + 1];
        Deque<Integer> win = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < n; ++i) {
            // remove indices that are out of bound
            while (!win.isEmpty() && win.peekFirst() <= i - k) {
                win.pollFirst();
            }
            // remove indices whose corresponding values are less than nums[i]
            while (!win.isEmpty() && nums[win.peekLast()] < nums[i]) {
                win.pollLast();
            }
            // add nums[i]
            win.offerLast(i);
            // add to result
            if (i >= k - 1) {
                result[i - k + 1] = nums[win.peekFirst()];
            }
        }
        return result;
    }

    public static int[] slidingWindowMaximumMySolution(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int windowMax = Integer.MIN_VALUE;
        int indexOfWindowMax = -1;
        for (int i = 0; i < k; i++) {
            if (nums[i] > windowMax) {
                windowMax = nums[i];
                indexOfWindowMax = i;
            }
        }
        result[0] = windowMax;
        for (int right = k; right < nums.length; right++) {
            if (nums[right] > windowMax) {
                indexOfWindowMax = right;
                windowMax = nums[right];
            }
            if (right - k + 1 > indexOfWindowMax) {
                int left = max(right - k + 1, indexOfWindowMax);
                windowMax = Integer.MIN_VALUE;
                indexOfWindowMax = -1;
                while (left <= right) {
                    if (nums[left] > windowMax) {
                        windowMax = nums[left];
                        indexOfWindowMax = left;
                    }
                    left++;
                }
            }
            result[right - k + 1] = windowMax;
        }
        return result;
    }
}
