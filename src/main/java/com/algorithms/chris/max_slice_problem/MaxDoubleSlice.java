package com.algorithms.chris.max_slice_problem;

/**
 * Дан массив, найти максимальную сумму элементов двойных подмассивов среди всех возможных двойных подмассивов.
 * Двойной подмассив - триплет (X, Y, Z), такой что 0 ≤ X < Y < Z < N. (например (0, 2, 5) - элементы на индексах [1,2] [3,4]
 * <p>
 * 1) Для каждого i найти максимальную сумму среди подотрезков слева, которые заканчиваются на этом индексе #{@link MaxSlice}
 * 2) Для каждого i найти максимальную сумму среди подотрезков справа, которые заканчиваются на этом индексе #{@link MaxSlice}
 * 3) Для каждого i посчитать сумму сумм слева и справа и вычесть i, найти максимальную среди них.
 * <p>
 * Given an array, find the maximum sum of elements of a double sub array among all possible double sub arrays.
 * A double slice is an array cut into two slices by a triplet of values (X, Y, Z), so that as 0 ≤ X < Y < Z < N.
 * <p>
 * 1) For each i find maximum sum among sub arrays on the left, that end at this index #{@link MaxSlice}
 * 2) For each i find maximum sum among sub arrays on the right, that end at this index #{@link MaxSlice}
 * 3) For each i calculate sum of these sums minus i, find max.
 */
public class MaxDoubleSlice {

    public static int solution(int[] A) {
        int maxEnding = 0;
        int[] maxEndingsFromLeft = new int[A.length];
        int[] maxEndingsFromRight = new int[A.length];
        for (int i = 1; i < A.length - 1; i++) {
            maxEnding = Math.max(A[i], maxEnding + A[i]);
            maxEndingsFromLeft[i] = maxEnding;
            if (maxEndingsFromLeft[i] < 0) {
                maxEndingsFromLeft[i] = 0;
            }
        }
        maxEnding = 0;
        for (int i = A.length - 2; i > 0; i--) {
            maxEnding = Math.max(A[i], maxEnding + A[i]);
            maxEndingsFromRight[i] = maxEnding;
            if (maxEndingsFromRight[i] < 0) {
                maxEndingsFromRight[i] = 0;
            }
        }
        int result = 0;
        for (int i = 1; i < A.length - 1; i++) {
            result = Math.max(maxEndingsFromLeft[i - 1] + maxEndingsFromRight[i + 1], result);
        }
        return result;
    }
}

