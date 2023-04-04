package com.algorithms.chris.codility.time_complexity;

public class TapeEquilibrium {

    public static int solution(int[] A) {
        for (int i = 1; i < A.length; i++) {
            A[i] += A[i - 1];
        }
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < A.length; i++) {
            //в последнем элементе лежит сумма всех чисел 1021
            //в элементе i лежит сумма всех чисел слева для данного элемента 21
            int diff = Math.abs(A[A.length - 1] - (2 * A[i - 1]));
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }
}
