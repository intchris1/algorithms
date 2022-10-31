package com.algorithms.chris.prime_and_composite_numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Посчитать количество флагов, которые можно разместить на пиках.
 * Пик - такое число в массиве, которое больше чисел справа и слева.
 * Нужно ставить флаг только так, чтобы дистанция между любыми двумя флагами была больше или равна количеству флагов.
 * <p>
 * Решение:
 * 1) сделать массив пиков.
 * 2) найти максимальное количество возможных флагов - квадратный корень длины массива.
 * 3) проверять, можем ли мы поставить столько флагов, начиная от максимального числа.
 * проходиться по массиву с обоих концов. На каждом конце проверять, можно ли поставить следующий флаг -
 * не нарушает ли он условия по отношению к ранее поставленным флагам с обоих концов.
 * <p>
 * Calculate the number of flags that can be placed on peaks.
 * Peak is the number in an array that is greater than the numbers on the right and left.
 * It is necessary to set the flag only so that the distance between any two flags is greater than or equal to the number of flags.
 * <p>
 * Solution:
 * 1) make an array of peaks.
 * 2) find the maximum number of possible flags - the square root of the length of the array.
 * 3) check if we can set as many flags, starting from the maximum number.
 * traverse the array from both ends. At each end, check if the following flag can be set -
 * whether it violates the conditions in relation to previously set flags from both ends.
 */
public class Flags {

    public static int solution(int[] A) {
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i]) {
                if (A[i + 1] < A[i]) {
                    peaks.add(i);
                }
            }
        }
        if (peaks.size() <= 1) {
            return peaks.size();
        }
        int maxFlags = (int) Math.ceil(Math.sqrt(peaks.get(peaks.size() - 1) - peaks.get(0)));
        for (int flags = maxFlags; flags > 1; flags--) {
            int startIndex = 0;
            int endIndex = peaks.size() - 1;
            int startFlag = peaks.get(startIndex);
            int endFlag = peaks.get(endIndex);
            int flagsPlaced = 2;
            while (startIndex < endIndex) {
                startIndex++;
                endIndex--;
                if (peaks.get(startIndex) >= startFlag + flags) {
                    if (peaks.get(startIndex) <= endFlag - flags) {
                        flagsPlaced++;
                        startFlag = peaks.get(startIndex);
                    }
                }
                if (peaks.get(endIndex) >= startFlag + flags) {
                    if (peaks.get(endIndex) <= endFlag - flags) {
                        flagsPlaced++;
                        endFlag = peaks.get(endIndex);
                    }
                }
                if (flagsPlaced == flags) {
                    return flags;
                }
            }
        }
        return 0;
    }
}

