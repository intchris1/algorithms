package com.algorithms.chris.codility.prefix_sums;

public class CountDiv {
    public static int solution(int A, int B, int K) {
        if (K > B && A == 0) return 1;
        if (K > B) return 0;
        if (A == B) {
            if (A % K == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int minDivisibleIncluded;
        if (A < K) {
            minDivisibleIncluded = A;
        } else {
            minDivisibleIncluded = A + A % K;
        }
        int maxDivisibleIncluded = B - B % K;
        int difference = maxDivisibleIncluded - minDivisibleIncluded;
        int number = difference / K;
        return number + 1;
    }
}
