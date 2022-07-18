package com.algorithms.chris.max_slice_problem;

/**
 * Дан массив, найти максимальную сумму элементов подмассива среди всех возможных подмассивов.
 * <p>
 * 1) Для каждого i найти максимальную сумму среди подотрезков, которые заканчиваются на этом индексе (maxEnding).
 * Чтобы посчитать maxEnding, нужно:
 * 1.1) Найти максимальную сумму среди подотрезков которые оканчиваются на индексе i - 1.
 * 1.2) Взять максимальное значение - либо число из пункта 1), либо само число на индексе i.
 * 2) Найти максимальное число среди всех таких maxEnding.
 * <p>
 * Given an array, find the maximum sum of elements of a sub array among all possible sub arrays.
 * <p>
 * 1) For each i, find the maximum sum among sub arrays that end at this index (maxEnding).
 * To calculate maxEnding:
 * 1.1) Find the maximum sum among subsegments that end at index i - 1.
 * 1.2) Take the maximum value - either the number from p. 1), or the number at index i itself.
 * 2) Find the maximum number among all such maxEndings.
 */
public class MaxSlice {

    public static int solution(int[] A) {
        long maxEnding = A[0];
        long result = A[0];
        for (int i = 1; i < A.length; i++) {
            maxEnding = Math.max(A[i], maxEnding + A[i]);
            if (maxEnding > result && maxEnding <= Integer.MAX_VALUE) {
                result = maxEnding;
            }
        }
        return (int) result;
    }
}

